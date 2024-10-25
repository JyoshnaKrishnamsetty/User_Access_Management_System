package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.SoftwareModel;

public class SoftwareDAO {

	public String insertsoftwaredata(SoftwareModel sm) {
		String status = "fail";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Databse_password");
			PreparedStatement Ps = con.prepareStatement("INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)");
			Ps.setString(1, sm.getName());
			Ps.setString(2, sm.getDescription());
			Ps.setString(3, sm.getAccess_levels());
			int n= Ps.executeUpdate();
			if(n>0) {
				status="softwaresuccess";
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public List<SoftwareModel> selectallsoftwaredata(){
		List<SoftwareModel> softwarelist=new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Databse_password");
			PreparedStatement Ps = con.prepareStatement("select *from software");
			ResultSet rs= Ps.executeQuery();
			while(rs.next()) {
				softwarelist.add(new SoftwareModel(
		                rs.getInt("id"),
		                rs.getString("name"),
		                rs.getString("description"),
		                rs.getString("access_levels")
		            ));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return softwarelist;
	}
}
