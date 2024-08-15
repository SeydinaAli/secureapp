package com.samanecorporation.secureapp.controller;

import java.io.IOException;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet(name = "login", value = "/login")
public class LoginServelet extends HttpServlet {
	
	private Logger log = LoggerFactory.getLogger(LoginServelet.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		
		log.info("L'email envoye est {} ", email);
		
		req.getSession().setAttribute("username", email);
		resp.sendRedirect("Welcome");
	}

}
