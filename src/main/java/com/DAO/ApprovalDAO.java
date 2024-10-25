package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Model.RequestAccessModel;
import com.Model.RequestForManager;
import com.Model.SignUpModel;
import com.Model.SoftwareModel;

public class ApprovalDAO {

	public static String Approvaldata(RequestAccessModel rm) {
		String status="Fail";
        	try {
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Database_password");
    			PreparedStatement Ps = con.prepareStatement("UPDATE requests SET status = ? WHERE id = ?");
    			Ps.setString(1, rm.getStatus());
    			Ps.setInt(2, rm.getId());
    			int n= Ps.executeUpdate();
    			if(n>0) {
    				status="updatesuccess";
    			}
    			con.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	return status;
	}

	public static List<RequestAccessModel> selectAllList() {
		List<RequestAccessModel> approvallist = new ArrayList<RequestAccessModel>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Database_password");
			PreparedStatement Ps=con.prepareStatement("select r.id,s.name,r.access_type,r.reason from requests as r join software as s on r.software_id=s.id");
			ResultSet rs=Ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String accesstype = rs.getString("access_type");
				String reason = rs.getString("reason");
				approvallist.add(
				new RequestAccessModel(id,name,accesstype,reason));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return approvallist;
	}
	public static List<RequestForManager> selectAllRequest() {
		List<RequestForManager> approvallist = new ArrayList<RequestForManager>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Databse_name", "Databse_password");
			PreparedStatement Ps=con.prepareStatement("select * from requests where status='Pending'");
			ResultSet rs=Ps.executeQuery();
			while (rs.next()) {
				int reqid = rs.getInt("id");
				int userid=rs.getInt("user_id");
				SignUpModel userbyId = SignUpDAO.getUserbyId(userid);
				int softid=rs.getInt("software_id");
				SoftwareModel sofwarebyId = RequestAccessDAO.getSofwarebyId(softid);
				String acctype=rs.getString("access_type");
				String reason=rs.getString("reason");
			       approvallist.add(new RequestForManager(userbyId.getId(),reqid,userbyId.getUsername(), sofwarebyId.getName(), acctype, reason));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return approvallist;
	}
}
