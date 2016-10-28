package com.newlec.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class Download extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("f");		
		response.setHeader("Content-Disposition",
				String.format("attachment; filename=\"%s\"",fname));
		
		//----File 입출력------------------------------------------
		ServletContext ctx = request.getServletContext();
		String path = "/customer/upload/"+fname;  //먼저 어디에 있는지 알것
		path = ctx.getRealPath(path);
		
		PrintWriter out = response.getWriter();
		out.println(fname);
		
	}
	
}
