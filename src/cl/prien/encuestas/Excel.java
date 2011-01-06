/*
 * Excel.java
 *
 * Created on 22 de octubre de 2007, 22:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package cl.prien.encuestas;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.swing.JProgressBar;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author manuel
 */
public class Excel implements Runnable {

    private WritableWorkbook workbook;
    private Rules rules;
    private String filename;
    private JProgressBar progress;
    private Hashtable<String, Field> columns;
    private List<String> tables;
    private List<String> headers;
    private File file;

    /** Creates a new instance of Excel */
    public Excel(File file, Hashtable columns, JProgressBar progress) {
        this.file = file;
        this.columns = columns;
        this.filename = file.getAbsolutePath();
        if (!filename.toLowerCase().endsWith(".xls")) {
            filename += ".xls";
        }
        this.progress = progress;
        progress.setValue(0);
        rules = new Rules();
        System.out.println("Columns tiene " + columns.size() + " elementos");
        if (columns.size() > 0) {
            tables = new ArrayList<String>();
            tables.add("resumen");
        } else {
            tables = rules.getTables();
        }

    }

    public void run() {
        try {
            WorkbookSettings ws = new WorkbookSettings();
            workbook = Workbook.createWorkbook(new File(filename), ws);
            int i = 0;
            for (String table : tables) {
                WritableSheet s = workbook.createSheet(table, i);
                System.out.println("Writing headers....");
                writeHeaders(table, s);
                System.out.println("Writing data...");
                writeData(table, s);
                progress.setValue(progress.getValue() + 1);
                System.out.println("Removing columns");
                removeColumns(table, s);
            }
            System.out.println("Closing");
            workbook.write();
            workbook.close();
            System.out.println("Finished");
            progress.setVisible(false);

        } catch (Exception ex) {
            Error e = new Error(ex);
            ex.printStackTrace();
        }
    }

    private void writeHeaders(String table, WritableSheet s) throws WriteException {
        table = table.toLowerCase();
        if (table.equals("tabla_resumen_casas") || table.equals("tabla_resumen_dpto")) {
            table = "tablaresumen";
        }

        if (this.columns.size() > 0) {
            headers = rules.getColumns(columns);
        } else {
            headers = rules.getColumns(table);
        }
        WritableCellFormat wrappedText = new WritableCellFormat(WritableWorkbook.ARIAL_10_PT);
        wrappedText.setWrap(true);
        for (int i = 0; i < headers.size(); i++) {
            Label l = new Label(i, 0, headers.get(i), wrappedText);
            s.addCell(l);
        }
    }

    private void writeData(String table, WritableSheet s) throws Exception {
        System.out.println("Writing data for table " + table);
        table = table.toLowerCase();
        String query = "";
        if (table.equals("tabla_resumen_casas")) {
            query = Rules.queryResumenCasas;
        } else if (table.equals("tabla_resumen_dpto")) {
            query = Rules.queryResumenDepto;
        } else {
            query = "SELECT * FROM " + table;
        }
        if (table.equals("tabla_resumen_casas") || table.equals("tabla_resumen_dpto")) {
            table = "tablaresumen";
        }
        if (columns.size() > 0) {
            query = Rules.queryFor(columns);
            System.out.println("QUERY ES : " + query);

        }



        WritableCellFormat wrappedText = new WritableCellFormat(WritableWorkbook.ARIAL_10_PT);

        ResultSet rs = Conexion.getConnection().createStatement().executeQuery(query);
        for (int i = 0; rs.next(); i++) {
            Iterator it = columns.keySet().iterator();
            int max = rs.getMetaData().getColumnCount();
            if (table.equals("informacion_general")) {
                max++;
            }
            for (int j = 1; j < max; j++) {
                Object data;
                if (columns.size() > 0) {
                    Field f = columns.get(it.next());
                    System.out.println("Pidiendo convertir " + f.table + "." + f.column + ":" + f.columnId);
                    data = rules.convertData(f.table, f.columnId, rs.getString(j));
                } else {
                    data = rules.convertData(table, j - 1, rs.getString(j));
                }

                if (data instanceof String) {
                    Label l = new Label(j - 1, i + 1, (String) data, wrappedText);
                    s.addCell(l);
                }
                if (data instanceof Integer) {
                    Number n = new Number(j - 1, i + 1, (Integer) data, wrappedText);
                    s.addCell(n);
                }
                if (data instanceof Float) {
                    Number n = new Number(j - 1, i + 1, (Float) data, wrappedText);
                    s.addCell(n);
                }


            }

        }




    }

    /**
     * Elimina las columnas que no deben ser mostradas en el excel.
     * La primera columna es la cero
     * */
    private void removeColumns(String table, WritableSheet s) {
        table = table.toLowerCase();
        if (table.equals("acondicionamiento_termico")) {
            s.removeColumn(94 - 1); //tamaño_kerosene_0
            s.removeColumn(47 - 1); //estufas
            s.removeColumn(29 - 1); //ctos_sistema_aire1
        }
        if (table.equals("clientes1")) {
            s.removeColumn(25 - 1); //meses
        }
        if (table.equals("clientes2")) {
            s.removeColumn(51 - 1); //cong_tipo
        }
        if (table.equals("aguacaliente_y_coccion")) {
            s.removeColumn(8 - 1); //precio_cte_acs
        }
    }
}
