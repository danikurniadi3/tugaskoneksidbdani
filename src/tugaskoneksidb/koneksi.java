/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaskoneksidb;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author DaniPC
 */
public class koneksi {
      private static Connection KoneksiDatabase;
    public static Connection koneksiDB() throws SQLException{
        try{
            String DB="jdbc:mysql://localhost/penjualan";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            KoneksiDatabase = (Connection) DriverManager.getConnection(DB,user,pass);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "tidak ada koneksi","error",
            JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return KoneksiDatabase;
    }
}
