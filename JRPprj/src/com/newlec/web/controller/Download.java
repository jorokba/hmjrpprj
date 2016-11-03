package com.newlec.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class Download extends HttpServlet {
	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String fname = request.getParameter("f");
	         
	         response.setHeader("Content-Disposition"
	               , String.format("attatchment; filename=\"%s\"" , fname));
	         
	         //-------File stream----------------------------------------------------------
	         
	         ServletContext ctx = request.getServletContext();
	         
	         String path = "/customer/upload/"+fname;
	         path = ctx.getRealPath(path);
	         
	         try{
	            File file = new File(path);
	            byte[] buf = new byte[1024];

	            FileInputStream fis = new FileInputStream(file);
	            
	            ServletOutputStream wos = response.getOutputStream();
	            
	            int count = -1;
	            
	            while((count =fis.read(buf)) !=-1)
	               wos.write(buf, 0, count);
	            
	            wos.flush();
	            fis.close();
	            wos.close();
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	   }
	}