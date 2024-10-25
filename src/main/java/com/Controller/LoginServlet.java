package com.Controller;

import java.io.IOException;
import java.util.List;

import com.DAO.ApprovalDAO;
import com.DAO.LoginDAO;
import com.DAO.SoftwareDAO;
import com.Model.RequestAccessModel;
import com.Model.RequestForManager;
import com.Model.SignUpModel;
import com.Model.SoftwareModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		SignUpModel sum = new SignUpModel();
		sum.setUsername(username);
		sum.setPassword(password);

		HttpSession session = request.getSession();
		LoginDAO ld = new LoginDAO();
		String role = ld.logindata(sum, session);

		 if (role.equals("Employee")&& role!=null) {
			 SoftwareDAO sd=new SoftwareDAO();
	    	 List<SoftwareModel> softwarelist=sd.selectallsoftwaredata();
	    	 request.setAttribute("softwareList", softwarelist);
			RequestDispatcher rp = request.getRequestDispatcher("requestAccess.jsp");
			rp.include(request, response);
		} else if (role.equals("Manager") && username.equals("Manager01") && password.equals("Manager@123")&& role!=null) {
			ApprovalDAO apd=new ApprovalDAO();
			List<RequestForManager> selectAllList = ApprovalDAO.selectAllRequest();
			request.setAttribute("ApprovalList",selectAllList);
			RequestDispatcher rp = request.getRequestDispatcher("pendingRequests.jsp");
			rp.include(request, response);
		} else if (role.equals("Admin") && username.equals("Admin01") && password.equals("Admin@123")&& role!=null) {
			RequestDispatcher rp = request.getRequestDispatcher("createSoftware.jsp");
			rp.include(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid username or password.");
			RequestDispatcher rp = request.getRequestDispatcher("login.jsp");
			rp.include(request, response);
		}
	}

}
