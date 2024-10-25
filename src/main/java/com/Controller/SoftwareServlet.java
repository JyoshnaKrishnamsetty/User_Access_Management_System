package com.Controller;

import java.io.IOException;

import com.DAO.SoftwareDAO;
import com.Model.SoftwareModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SoftwareServlet")
public class SoftwareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String softwarename = request.getParameter("softwarename");
		String description = request.getParameter("description");
		String read = request.getParameter("read");
		String write = request.getParameter("write");
		String admin = request.getParameter("admin");
		StringBuilder accessLevelsBuilder = new StringBuilder();
		if (read != null) {
			accessLevelsBuilder.append("Read");
		}
		if (write != null) {
			if (accessLevelsBuilder.length() > 0) {
				accessLevelsBuilder.append(", ");
			}
			accessLevelsBuilder.append("Write");
		}
		if (admin != null) {
			if (accessLevelsBuilder.length() > 0) {
				accessLevelsBuilder.append(", ");
			}
			accessLevelsBuilder.append("Admin");
		}
		String accessLevelsString = accessLevelsBuilder.toString();
		SoftwareModel sm = new SoftwareModel();
		sm.setName(softwarename);
		sm.setDescription(description);
		sm.setAccess_levels(accessLevelsString);
		SoftwareDAO sd = new SoftwareDAO();
		String status = sd.insertsoftwaredata(sm);
		if (status.equals("softwaresuccess")) {
			request.setAttribute("Message", "Sofware Created Successfully!!");
			RequestDispatcher rp = request.getRequestDispatcher("createSoftware.jsp");
			rp.include(request, response);
		}
	}
}
