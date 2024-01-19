/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dbutil;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//import org.mariadb.jdbc.Connection;

/**
 *
 * @author rohit
 */
public class DBconnection
{
    private static Connection conn;
    static
    {
        try
        {
            String url = "jdbc:mariadb://localhost:3306/eMart";
            String user = "root";
            String password = "12345699";
            
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Connect successfully to db.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            
            
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Error loading in driver", "Driver Error!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error in opening connection", "Opening Connection Error!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection closed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error in closing the connection", "Opening Connection Error!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
    }
    
}
