package com.Controller;

import java.io.IOException;

import com.DAO.SignUpDAO;
import com.Model.SignUpModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String role = request.getParameter("role");
		SignUpModel sum = new SignUpModel();
		sum.setUsername(username);
		sum.setPassword(password);
		sum.setRole(role);
		SignUpDAO sud = new SignUpDAO();
		String status = sud.signupdata(sum);
		if (status.equals("signupsuccess")) {
			RequestDispatcher rp = request.getRequestDispatcher("/login.jsp");
			rp.include(request, response);
		} else {
			RequestDispatcher rp = request.getRequestDispatcher("/signup.jsp");
			rp.include(request, response);
		}
	}
}
