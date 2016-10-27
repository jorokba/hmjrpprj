/*package com.newlec.peb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class Index extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String _cnt = request.getParameter("cnt");
	    
		int cnt = 0;
	      
	    if(_cnt != null)
	    	cnt = Integer.parseInt(_cnt);
	   
	    PrintWriter out = response.getWriter();
	    
	    out.write("<!DOCTYPE html>");
	    out.write("<html>");
	    out.write("<head>");
	    out.write("<meta charset=\"UTF-8\">");
	    out.write("<title>Insert title here</title>");
	    out.write("</head>");
	    out.write("<body>");
	    out.write("	<form action=\"greeting\" method=\"get\">");
	    out.write("	<fieldset>");
	    out.write("			<legend>È¯¿µÀÎ»ç ÀÔ·Â Æû</legend>");
	    out.write("		<div>");
	    out.write("			<label>¹Ýº¹È½¼ö:</label>");
	    out.write("			<input type=\"text\" name=\"cnt\"/>");
	    out.write("		</div>");
	    out.write("		<div>");
	    out.write("			<input type=\"submit\" name=\"say hello\" />");
	    out.write("		</div>");
	    out.write("	</fieldset>");
	    out.write("</form>");
	    for(int i =0; i<cnt; i++)
			out.println((i+1)+":¾È³ç? ¼­ºí·¿~~?</br>");
	    out.write("</body>");
	    out.write("</html>");
	}
}*/