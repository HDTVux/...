/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author HP
 */
public class LoginDAO extends DBContext {
public Account checkLogin (String username, String password) {
try{
String sql = "SELECT * FROM Account WHERE username=? and password = ?";
PreparedStatement ps = connection.prepareStatement (sql);
ps.setString(1, username);
ps.setString(2, password);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
return new Account (rs.getString(1), rs.getString (2));
}
} catch (Exception e){
}
return null;
}
}

