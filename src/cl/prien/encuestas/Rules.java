/*
 * Rules.java
 *
 * Created on 22 de octubre de 2007, 23:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package cl.prien.encuestas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author manuel
 */
public class Rules {

    private ResultSet rs = null;
    private Hashtable<String, Vector> tablas;
    public static final String queryResumenCasas = "SELECT tablaresumen.* FROM tablaresumen, informacion_general WHERE informacion_general.serial = tablaresumen.serial AND Tipo_Vivienda='Casa'";
    public static final String queryResumenDepto = "SELECT tablaresumen.* FROM tablaresumen, informacion_general WHERE informacion_general.serial = tablaresumen.serial AND Tipo_Vivienda='Departamento'";

    /** Creates a new instance of Rules */
    public Rules() {
        tablas = new Hashtable<String, Vector>();
        fixDB();
    }

    /**
     * Construye de manera dinamica una consulta en la base de datos para extraer todas las columnas especificadas
     * @params columns Hashtable con todas las columnas que deben ser retornadas
     * @returns Consulta SQL 
     **/
    public static String queryFor(Hashtable<String, Field> columns) {
        Vector<String> table = new Vector();
        String query = "SELECT ";
        Vector v = new Vector(columns.keySet());
        Iterator it = v.iterator();
        while (it.hasNext()) {
            Field aux = columns.get(it.next());
            String t = aux.table;
            if (t.toLowerCase().indexOf("tabla_resumen") == 0) {
                t = "tablaresumen";
            }
            query += t + ".`" + aux.column + "` ,";
            if (!table.contains(t)) {
                table.add(t);
            }
        }

        System.out.println("Tablas detectadas " + table.size());

        query = query.substring(0, query.length() - 1);

        query += ",1 FROM ";

        for (String t : table) {
            query += t + " ,";
        }
        query = query.substring(0, query.length() - 1);

        if (table.size() < 2) {
            return query;
        }

        query += " WHERE ";
        for (int i = 0; i < table.size() - 1; i++) {
            query += table.get(i) + ".serial = " + table.get(i + 1) + ".serial AND ";
        }
        query = query.substring(0, query.length() - 5);
        return query;
    }

    public List<String> getColumns(Hashtable<String, Field> columns) {
        List<String> headers = new ArrayList<String>();
        Vector v = new Vector(columns.keySet());
        Iterator it = v.iterator();
        while (it.hasNext()) {
            headers.add(columns.get(it.next()).alias);
        }
        return headers;

    }

    public List<String> getColumns(String table) {
        Vector<Hashtable> columnas = new Vector<Hashtable>();

        List<String> l = new ArrayList<String>();


        try {
            System.out.println("Buscando reglas para " + table);
            BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/cl/prien/encuestas/rules/" + table.toLowerCase() + ".csv")));

            String linea = in.readLine();
            String[] etiqueta = linea.split(";");
            for (int i = 1; i < etiqueta.length; i += 2) {
                l.add(etiqueta[i]);
                columnas.add(new Hashtable());
            }

            linea = in.readLine();
            while (linea != null) {
                int c = 0;
                etiqueta = linea.split(";");
                for (int i = 0; i < etiqueta.length; i += 2) {
                    if (etiqueta[i].length() != 0) {
                        Hashtable<String, String> rules = columnas.get(c);
                        if (etiqueta[i].equals("Valor") && etiqueta[i + 1].equals("El mismo")) {
                        // la regla por default es copiar los datos existentes
                        // no hago nada aqui
                        } else {
                            String valor = etiqueta[i + 1];
                            if (valor.toLowerCase().equals("si")) {
                                valor = "Sí";
                            }
                            rules.put(etiqueta[i], valor);
                        }
                    }
                    c++;
                }
                linea = in.readLine();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        tablas.put(table, columnas);
        return l;
    }

    public List<String> getTables() {
        List<String> tables = new ArrayList<String>();
        tables.add("Tabla_resumen_casas");
        tables.add("Tabla_resumen_dpto");
        tables.add("Clientes3");
        tables.add("Clientes2");
        tables.add("Clientes1");
        tables.add("Informacion_general_dpto");
        tables.add("AguaCaliente_y_coccion");
        tables.add("Aparatos");
        tables.add("Iluminaciondpto");
        tables.add("Acondicionamiento_termico");
        tables.add("Informacion_general");
        return tables;
    }

    public List<String> getTablesforCasa() {
        List<String> tables = new ArrayList<String>();
        tables.add("Tabla_resumen_casas");
        tables.add("Clientes3");
        tables.add("Clientes2");
        tables.add("Clientes1");
        tables.add("Informacion_general");
        return tables;
    }

    public List<String> getTablesforDpto() {
        List<String> tables = new ArrayList<String>();
        tables.add("Tabla_resumen_dpto");
        tables.add("Informacion_general_dpto");
        tables.add("AguaCaliente_y_coccion");
        tables.add("Aparatos");
        tables.add("Iluminaciondpto");
        tables.add("Acondicionamiento_termico");
        tables.add("Informacion_general");
        return tables;
    }

    /**
     * Reparar las inconsistencias presentes en la base de datos, sirve para las reglas del tipo:
     * Si en la pregunta "utiliza ampolletas fluorescentes" responde NO, entonces las siguientes respuestas deben ser N/A
     * 
     * Este método es invocado automática cada vez que se pide el archivo de salida, por lo cual la ejecución de él siempre 
     * debe dejar la base de datos en el mismo estado.
     *
     * En particular este método no sirve para reglas del tipo:
     * "Si el valor en el campo secadora es mayor que dos entonces duplicarle el valor"
     * */
    protected int fixDB() {
        int counter = 0;

        List<String> sql = importarNA();

        try {
            for (String query : sql) {
                counter += Conexion.getConnection().createStatement().executeUpdate(query);
            //              System.out.println(query);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return counter;
    }

    /**
     * Columnas que deben ser marcadas como informacion N/A
     */
    private List importarNA() {
        BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/cl/prien/encuestas/rules/reglas.txt")));
        List<String> rules = new ArrayList<String>();
        String linea;
        String table = null;
        String condition = null;
        List<String> output = new ArrayList<String>();
        try {
            while ((linea = in.readLine()) != null) {
                if (linea.indexOf("En ") == 0) {
                    table = linea.substring(3);
                } else if (linea.indexOf("Si ") == 0) {

                    rules = new ArrayList<String>();
                    condition = linea.substring(3).replaceAll(" ó ", " OR ");
                } else if (linea.indexOf("----") != 0 && linea.length() > 0) {
                    String aux = linea.trim().trim();
                    aux = aux.replaceFirst("=", "`=");
                    aux = aux.replaceFirst("N/A", " -99");
                    rules.add("`" + aux + " ");
                }
                if (linea.length() == 0) {
                    addquery(table, condition, output, rules);
                    rules = null;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addquery(table, condition, output, rules);

        return output;
    }

    private void addquery(String table, String condition, List<String> output, List<String> rules) {

        if (rules != null && rules.size() > 0) {
            String aux = "UPDATE " + table + " SET ";
            for (String rule : rules) {
                aux += rule + ",";
            }
            aux = aux.substring(0, aux.length() - 1); //elimino la ultima coma
            aux += " WHERE " + condition;
            output.add(aux);
        }
    }

    /*
     * Recibe un dato sin procesar desde la base de datos, y de acuerdo a su ubicacion (tabla y número de columna) le  
     * aplica las reglas establecidas en el archivo de reglas rules/{table}.csv 
     *
     * En caso de que el dato recibido no calce con ninguna regla, se retorna sin alterar su valor.
     * 
     * @params table Nombre de la tabla, debe existir un archivo {table}.csv desde la cual extraer las reglas de conversion
     * @params column Número de la columna, la primera es cero.
     * @params data Dato extraido desde la base de datos, sin procesar
     * @returns Object Retorna un objeto, según el tipo de dato procesado puede ser un Entero, Flotante o String 
     * */
    public Object convertData(String table, int column, String data) {
        if (data == null) {
            return null;
        }
        if (table.equals("Tabla_resumen_casas") || table.equals("Tabla_resumen_dpto")) {
            table = "tablaresumen";
        }
        System.out.println("ConvertData for " + table + " column " + column + " data " + data);
        Vector<Hashtable> columnas = tablas.get(table);
        if (columnas == null) {
            getColumns(table);
            columnas = tablas.get(table);

        }
        try {
            Hashtable<String, String> rules = columnas.get(column);
            if (rules.containsKey(data.toString())) {
                data = rules.get(data.toString());
            }

        } catch (Exception e) {
            System.out.println("Exception en tabla " + table);
            System.out.println("Columna : " + column);
            System.out.println("Etiqueta : " + data);
            e.printStackTrace();
        }

        if (data.equals("-99")) {
            data = "N/A";
        }

        try {
            if (data.indexOf(",") >= 0) {
                double n = Float.parseFloat(data.replaceFirst(",", "."));
                return new Float(n);
            } else {
                int n = Integer.parseInt(data);
                return new Integer(n);
            }
        } catch (NumberFormatException e) {
        // no era un entero 
        }


        return data;
    }
}
