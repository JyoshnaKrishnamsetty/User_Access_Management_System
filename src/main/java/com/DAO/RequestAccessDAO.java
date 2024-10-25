package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Model.RequestAccessModel;
import com.Model.SignUpModel;
import com.Model.SoftwareModel;

public class RequestAccessDAO {

	public String requestaccessdata(RequestAccessModel ram) {
		System.out.println(ram.getUser_id());
		String mystatus = "fail";
		String status = "Pending";
		ram.setStatus(status);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Databse_password");
			PreparedStatement Ps = con.prepareStatement(
					"INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, ?)");
			Ps.setInt(1, ram.getUser_id());
			Ps.setInt(2, ram.getSoftware_id());
			Ps.setString(3, ram.getAccess_type());
			Ps.setString(4, ram.getReason());
			Ps.setString(5, ram.getStatus());
			int n = Ps.executeUpdate();
			if (n > 0) {
				mystatus = "requestsuccess";
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mystatus;
	}
	public static  SoftwareModel getSofwarebyId(int id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Databse_password");
			PreparedStatement Ps = con.prepareStatement("Select * from software where id=?");
			Ps.setInt(1, id);
			ResultSet set = Ps.executeQuery();
			while(set.next()) {
				int softid = set.getInt(1);
				String softname = set.getString(2);
				String softdesc = set.getString(3);
				return new SoftwareModel(softid, softname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
