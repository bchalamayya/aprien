/*
 * Field.java
 *
 * Created on 15 de noviembre de 2007, 06:33 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cl.prien.encuestas;

/**
 *
 * @author manuel
 */
public class Field {
    
    /** Creates a new instance of Field */
    public Field(String table, String column, String alias,int columnId) {
        this.table = table;
        this.column = column;
        this.alias = alias;
        this.columnId = columnId;
    }
    
    public Field(Object table, Object column, Object alias,int columnId){
        this.table = table.toString();
        this.column = column.toString();
        this.alias = alias.toString();
        this.columnId = columnId;
    }
    
    public String table;
    public String column;
    public String alias;
    public int columnId;
}
