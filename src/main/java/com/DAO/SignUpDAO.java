package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Model.SignUpModel;

public class SignUpDAO {

	public String signupdata(SignUpModel sum) {
		String status = "fail";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Databse_password");
			PreparedStatement Ps = con.prepareStatement("INSERT INTO users(username, password, role) VALUES (?, ?, ?)");
			Ps.setString(1, sum.getUsername());
			Ps.setString(2, sum.getPassword());
			Ps.setString(3, sum.getRole());
			int n = Ps.executeUpdate();
			if (n > 0) {
				status = "signupsuccess";
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static SignUpModel  getUserbyId(int id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Databse_password");
			PreparedStatement Ps = con.prepareStatement("Select * from users where id=?");
			Ps.setInt(1, id);
			ResultSet set = Ps.executeQuery();
			while(set.next()) {
				int userid = set.getInt(1);
				String username = set.getString(2);
				String password = set.getString(3);
				String role = set.getString(4);
				return new SignUpModel(userid, username, password, role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
