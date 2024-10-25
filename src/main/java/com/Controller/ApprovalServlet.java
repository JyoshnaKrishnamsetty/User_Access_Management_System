package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.DAO.ApprovalDAO;
import com.Model.RequestAccessModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String requestId = request.getParameter("requestId");
	        String action = request.getParameter("action");
	        RequestAccessModel rm=new RequestAccessModel();
	        rm.setId(Integer.parseInt(requestId));
	        String status ="";
	        if ("approve".equals(action)) {
	            status = "Approved";
	            rm.setStatus(status);
	        } else if ("reject".equals(action)) {
	            status = "Rejected";
	            rm.setStatus(status);
	        }
	       String status1=ApprovalDAO.Approvaldata(rm);
	       if(status1.equals("updatesuccess")) {
	    	   List<RequestAccessModel> ApprovalList = ApprovalDAO.selectAllList();
	           request.setAttribute("ApprovalList", ApprovalList);
	           request.setAttribute("Message", "Request Handled Successfully!!");
	           RequestDispatcher dispatcher = request.getRequestDispatcher("pendingRequests.jsp");
	           dispatcher.include(request, response);
	       }
	       else {
	    	   List<RequestAccessModel> ApprovalList = ApprovalDAO.selectAllList();
	           request.setAttribute("ApprovalList", ApprovalList);
	    	   RequestDispatcher dispatcher = request.getRequestDispatcher("pendingRequests.jsp");
	           dispatcher.forward(request, response);
	       }
	
	}

}
