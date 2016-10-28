package com.newlec.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/down")
public class down extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("f");		
		response.setHeader("Content-Disposition",
				String.format("attachment; filename=\"%s\"",fname));
		
		//----File 입출력------------------------------------------
		ServletContext ctx = request.getServletContext();
		String path = "/customer/upload/"+fname;  //먼저 어디에 있는지 알것
		path = ctx.getRealPath(path); //물리 경로 얻어내기
		
		File file = new File(path);//파일 자체의 정보를 얻기 위해
		FileInputStream fis = new FileInputStream(file);
		
		OutputStream wos = response.getOutputStream();
		
		int count =-1;
		byte[] buf = new byte[1024]; //1kb씩 읽겠다
		while((count = fis.read(buf)) == -1){//읽어온게 몇개?
			wos.write(buf,0,count);
			
			fis.close();
			wos.close();
		}
	}

}
