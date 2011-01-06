/*
 * Importar.java
 *
 * Created on 19 de octubre de 2007, 19:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package cl.prien.encuestas;

import com.heatonresearch.datamover.DataMover;
import com.heatonresearch.datamover.db.Access;
import com.heatonresearch.datamover.db.Database;
import com.heatonresearch.datamover.db.DatabaseException;
import com.heatonresearch.datamover.db.MySQL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.JProgressBar;

/**
 *
 * @author manuel
 */
public class Importar implements Runnable {

    private Connection connection;
    private Database source;
    private Database target;
    private JProgressBar progress;
    private List<String> tables;
    private static final String sourceDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private PreparedStatement newRegistro,  registro;

    /** Creates a new instance of Importar */
    public Importar(String filename, JProgressBar progress) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            this.progress = progress;
            progress.setValue(0);
            String sourceURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            sourceURL += filename.trim() + ";DriverID=22;READONLY=true}";
            System.out.println(filename);
            source = new Access();
            target = new MySQL();
            source.connect(sourceDriver, sourceURL);
            Conexion.getConnection(); // inicializar las variables
            target.connect(Conexion.driver, Conexion.fullurl);
            newRegistro = Conexion.getConnection().prepareStatement("INSERT INTO informacion_general(cliente,nombre,fecha,calle,num,dpto,comuna,tipo_vivienda) VALUES(?,?,?,?,?,?,?,?)");
            registro = Conexion.getConnection().prepareStatement("SELECT count(*) " +
                    "from informacion_general where cliente = ? and fecha = ? and calle = ? and num = ? and dpto = ? and comuna = ?");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Agrega una llave asociada a cada reigstro para poder identificarlo en todas las tablas
     * */
    private void addKeys() throws SQLException {

        PreparedStatement stmt1 = Conexion.getConnection().prepareStatement("SELECT * FROM clientes1 WHERE SERIAL is NULL and cliente = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stmt2 = Conexion.getConnection().prepareStatement("SELECT * FROM clientes2 WHERE SERIAL is NULL and cliente = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stmt3 = Conexion.getConnection().prepareStatement("SELECT * FROM clientes3 WHERE SERIAL IS NULL and cliente = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stmt4 = Conexion.getConnection().prepareStatement("SELECT * FROM informacion_general_dpto WHERE SERIAL IS NULL and cliente = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stmt5 = Conexion.getConnection().prepareStatement("SELECT * FROM AguaCaliente_y_coccion WHERE SERIAL IS NULL and cliente = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stmt6 = Conexion.getConnection().prepareStatement("SELECT * FROM Aparatos WHERE SERIAL IS NULL and cliente = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stmt7 = Conexion.getConnection().prepareStatement("SELECT * FROM Iluminaciondpto WHERE SERIAL IS NULL and cliente = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stmt8 = Conexion.getConnection().prepareStatement("SELECT * FROM Acondicionamiento_termico WHERE SERIAL IS NULL and cliente = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stmt9 = Conexion.getConnection().prepareStatement("SELECT * FROM tablaresumen WHERE SERIAL IS NULL", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resumen = stmt9.executeQuery();
        while (resumen.next()) {
            String cliente = resumen.getString("cliente");
            String tipoVivienda, fecha, calle, num, dpto, comuna, nombre;
            stmt1.setString(1, cliente);
            stmt2.setString(1, cliente);
            stmt3.setString(1, cliente);
            ResultSet casas1 = stmt1.executeQuery();
            int serial = -1;

            if (casas1.next()) {
                //es una casa
                tipoVivienda = "Casa";
                ResultSet casas2 = stmt2.executeQuery();
                ResultSet casas3 = stmt3.executeQuery();
                casas2.absolute(1);
                casas3.absolute(1);
                fecha = casas2.getString("fecha");
                calle = casas1.getString("calle");
                num = casas1.getString("num");
                dpto = casas1.getString("dpto");
                comuna = casas1.getString("comuna");
                nombre = casas1.getString("nombre");
                if (!existeVivienda(cliente, fecha, calle, num, dpto, comuna)) {
                    serial = crearVivienda(cliente, nombre, fecha, calle, num, dpto, comuna, tipoVivienda);
                }
                casas1.updateInt("serial", serial);
                casas2.updateInt("serial", serial);
                casas3.updateInt("serial", serial);
                casas1.updateRow();
                casas2.updateRow();
                casas3.updateRow();
            } else {
                //entonces deberia ser un depto
                tipoVivienda = "Departamento";
                stmt4.setString(1, cliente);
                stmt5.setString(1, cliente);
                stmt6.setString(1, cliente);
                stmt7.setString(1, cliente);
                stmt8.setString(1, cliente);

                ResultSet depto1 = stmt4.executeQuery();
                ResultSet depto2 = stmt5.executeQuery();
                ResultSet depto3 = stmt6.executeQuery();
                ResultSet depto4 = stmt7.executeQuery();
                ResultSet depto5 = stmt8.executeQuery();

                depto1.absolute(1);
                depto2.absolute(1);
                depto3.absolute(1);
                depto4.absolute(1);
                depto5.absolute(1);

                calle = depto1.getString("Direccion");
                num = depto1.getString("num");
                dpto = depto1.getString("dpto");
                comuna = depto1.getString("comuna");
                fecha = depto1.getString("fecha");
                nombre = depto1.getString("nombre");

                if (!existeVivienda(cliente, fecha, calle, num, dpto, comuna)) {
                    serial = crearVivienda(cliente, nombre, fecha, calle, num, dpto, comuna, tipoVivienda);
                }

                depto1.updateInt("serial", serial);
                depto2.updateInt("serial", serial);
                depto3.updateInt("serial", serial);
                depto4.updateInt("serial", serial);
                depto5.updateInt("serial", serial);
                depto1.updateRow();
                depto2.updateRow();
                depto3.updateRow();
                depto4.updateRow();
                depto5.updateRow();

            }

            //serial es -1 si es que la vivienda ya existia
            resumen.updateInt("serial", serial);
            resumen.updateRow();

        }


        collectGarbage();

    }

    /**
     * Elimina información temporal o incompleta que pueda haber quedado en la base de datos
     *
     */
    public void collectGarbage() throws SQLException {
        Vector<String> v = new Vector<String>();
        v.add("clientes1");
        v.add("clientes2");
        v.add("clientes3");
        v.add("informacion_general_dpto");
        v.add("AguaCaliente_y_coccion");
        v.add("Aparatos");
        v.add("Iluminaciondpto");
        v.add("Acondicionamiento_termico");
        v.add("tablaresumen");
        for (String table : v) {
            Conexion.getConnection().createStatement().execute("DELETE FROM " + table + " WHERE serial = -1 or serial is NULL");
        }

    }

    private boolean existeVivienda(String cliente, String fecha, String calle, String num, String dpto, String comuna) throws SQLException {
        //System.out.println("Buscando Vivienda " + cliente + "\t" + fecha + "\t " + calle + "\t" + num + "\t" + dpto + "\t" + comuna);
        registro.setString(1, cliente);
        registro.setString(2, fecha);
        registro.setString(3, calle);
        registro.setString(4, num);
        registro.setString(5, dpto);
        registro.setString(6, comuna);
        ResultSet rs = registro.executeQuery();
        rs.absolute(1);
        int counter = rs.getInt(1);
        if (counter == 0) {
            return false;
        }
        if (counter == 1) {
            return true;
        } else {
            throw new RuntimeException("Direccion esta siendo compartida por vivienda y departamente, error de inconsistencia");
        }

    }

    public int crearVivienda(String cliente, String nombre, String fecha, String calle, String num, String dpto, String comuna, String tipo_vivienda) throws SQLException {
        newRegistro.setString(1, cliente);
        newRegistro.setString(2, nombre);
        newRegistro.setString(3, fecha);
        newRegistro.setString(4, calle);
        newRegistro.setString(5, num);
        newRegistro.setString(6, dpto);
        newRegistro.setString(7, comuna);
        newRegistro.setString(8, tipo_vivienda);
        newRegistro.executeUpdate();
        ResultSet key = newRegistro.getGeneratedKeys();
        key.absolute(1);
        int id = key.getInt(1);
        System.out.println("Serial record " + id);
        return id;
    }

    public void validar(Object a, Object b) {
        if (!a.equals(b)) {
            Error n = new Error("La base de datos presenta inconsistencias.\n Se esperaba " + a + " y se recibio " + b);
            throw new RuntimeException("Error de conversion \n Se esperaba " + a + " y se recibio " + b);
        }
    }

    /**
     * Realiza una verificación simple de que los datos esten correctos en la base de datos, solo un primer approach
     */
    public void validarIntegridadBaseDatos() {

    }

    public void run() {
        DataMover mover = new DataMover();
        mover.setSource(source);
        mover.setTarget(target);
        try {
            tables = new ArrayList<String>();
            DatabaseMetaData dbm = source.getConnection().getMetaData();

            String types[] = {"TABLE"};
            ResultSet rs = dbm.getTables(null, null, null, types);


            //tratamos de asegurar consistencia en la base de datos
            collectGarbage();



            while (rs.next()) {
                String str = rs.getString("TABLE_NAME");
                if (!str.toLowerCase().equals("configuracion") && !str.toLowerCase().equals("informacion_general")) {
                    progress.setValue(progress.getValue() + 1);
                    tables.add(str);
                    try {
                        mover.copyTable(str);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Exception Catched");
                    }
                }
            }
            source.close();
            target.close();
            addKeys();

            calcularEficiencia();
        } catch (Exception e) {
            Error er = new Error(e);
            e.printStackTrace();
        }
        progress.setVisible(false);
    }

    public void calcularEficiencia() throws SQLException {
        String query = "update tablaresumen set eficiencia = (case when `Ahorro total`/`Total KWH` > 0.2 then \"A\" when `Ahorro total`/`Total KWH` > 0.1  then \"B\" when `Ahorro total`/`Total KWH`>0.03 then \"C\" when `Ahorro total`/`Total KWH` > 0 then \"D\" else \"E\" END)";
        Conexion.getConnection().createStatement().execute(query);

    }
}
