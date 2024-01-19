/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dao;

import emart.dbutil.DBconnection;
import emart.pojo.EmployeePojo;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rohit
 */
public class EmployeeDAO
{
    public static String getNextEmpID() throws SQLException
    {
        Connection conn = DBconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(empid) from employees");
        rs.next();
        String empid = rs.getString(1);
        int empno = Integer.parseInt(empid.substring(1));
        empno++;
        return ("E" + empno);
    }
    
    public static boolean addEmployee(EmployeePojo emp) throws SQLException
    {
        Connection conn = DBconnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into employees values (?, ?, ?, ?)");
        ps.setString(1, emp.getEmpid());
        ps.setString(2, emp.getEmpname());
        ps.setString(3, emp.getJob());
        ps.setDouble(4, emp.getSalary());
        
        int result = ps.executeUpdate();
        
        return result == 1;
    }
    
    public static List<EmployeePojo> getAllEmployees() throws SQLException
    {
        Connection conn = DBconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from employees");
        ArrayList<EmployeePojo> empList = new ArrayList<>();
        while (rs.next())
        {
            EmployeePojo emp = new EmployeePojo();
            emp.setEmpid(rs.getString(1));
            emp.setEmpname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setSalary(rs.getDouble(4));
            
            empList.add(emp);
        }
        return (empList);
    }
    
}
