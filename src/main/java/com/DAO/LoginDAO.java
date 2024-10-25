package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Model.SignUpModel;

import jakarta.servlet.http.HttpSession;

public class LoginDAO {
       
	public String logindata(SignUpModel sum,HttpSession session) {
		String role = "";
		int userid=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Databse_password");
			PreparedStatement Ps = con.prepareStatement("select * from users where username = ? AND password=?");			
			Ps.setString(1, sum.getUsername());
			Ps.setString(2, sum.getPassword());
			ResultSet rs = Ps.executeQuery();	
			if(rs.next()) {
				userid=rs.getInt(1);
				role=rs.getString(4);
				session.setAttribute("userId", userid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
}
