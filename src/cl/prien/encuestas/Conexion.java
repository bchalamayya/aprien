/*
 * Connection.java
 *
 * Created on 19 de octubre de 2007, 18:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package cl.prien.encuestas;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author manuel
 */
public class Conexion {

    private static Connection c;
    public static String driver;
    public static String url,  fullurl;
    public static String username,  password,  host;

    /** Creates a new instance of Connection */
    public Conexion() {
    }

    public static Connection resetConnection() throws SQLException {
        c = null;
        Conexion conexion = new Conexion();
        return conexion.getConnection();
    }

    public static List<String> getRawColumns(String table) {
        List<String> result = new ArrayList<String>();
        ResultSet rs = null;
        try {
            rs = c.getMetaData().getColumns(null, null, table, null);
            while (rs.next()) {
                result.add(rs.getString("COLUMN_NAME"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static Connection getConnection() {
        if (c == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("configuracion.properties"));
                driver = (String) properties.get("driver");
                url = (String) properties.get("url");
                username = (String) properties.get("username");
                password = (String) properties.get("password");
                fullurl = url + "?user=" + username + "&password=" + password;
                Class.forName(driver);
                c = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                Config config = new Config();
                config.setVisible(true);
            }

        }
        return c;
    }
}
