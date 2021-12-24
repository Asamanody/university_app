
package db;

import project.Tools;
import project.Tools.Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class go {
    
    private static String url = ""; 
    private static Connection con;
    
    private static void setURL(){
        url = "jdbc:mysql://localhost:3306/project"
                + "?useUnicode=true&characterEncoding=UTF-8";
    }  
    
    public static void setConnection(){                
        try {
            setURL();
            con = DriverManager.getConnection(url,"root","");
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }        
    }
    
    public static boolean checkUserAndPass(String username, String password){
        try{
            setConnection();
            Statement stmt = con.createStatement();
            String strCheck = "SELECT * FROM users where user='"+username+"' and password ='"+password+"'";
            stmt.executeQuery(strCheck);
            while( stmt.getResultSet().next() ){
                con.close();
                return true;                
            }
            con.close();
        }catch(SQLException ex){
            Tools.msgBox(ex.getMessage());
        }
        return false;
    }
    
    public static boolean runNonQuery(String sqlStatement){
        try{
            setConnection();
            Statement stmt = con.createStatement();
            stmt.execute(sqlStatement);
            con.close();
            return true;
        }
        catch(SQLException ex){
            Tools.msgBox(ex.getMessage());            
            return false;
        }
    }
    
    public static void fillToJTable(String tableNameOrSelectStatement, JTable table){
        try{
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            String SPart = tableNameOrSelectStatement.substring(0, 6).toLowerCase();
            String strSelect;
            if( "select".equals( SPart ) ){
                strSelect = tableNameOrSelectStatement;
            }
            else{
                strSelect = "select * from " + tableNameOrSelectStatement;
            }
            rs = stmt.executeQuery(strSelect);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Vector row = new Vector();
            model.setRowCount(0);
            
            while(rs.next()){
                row = new Vector(c);
                for(int i = 1 ; i <= c ; i++){
                    row.add(rs.getString(i));
                }
                model.addRow(row);
            }
            /*if(table.getColumnCount() != c){
               // Tools.msgBox("JTable Columns Count Not Equal To Query Columns Count\nJTable Columns Count Is: " + table.getColumnCount() + "\nQuery Columns Count Is: " + c);
            }*/
            con.close();
        }
        catch(SQLException ex){
            Tools.msgBox(ex.getMessage());
        }
    }
   
}
