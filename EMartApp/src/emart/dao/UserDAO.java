/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dao;

import emart.dbutil.DBconnection;
import emart.pojo.UserPojo;
import emart.pojo.UserProfile;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rohit
 */
public class UserDAO
{
    public static boolean validateUser(UserPojo user) throws SQLException
    {
        Connection conn = DBconnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUsertype());
        
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            UserProfile.setUsername(rs.getString(5));
            return true;
        }
        return false;
    }
}
