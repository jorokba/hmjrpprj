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
		
		//----File �����------------------------------------------
		ServletContext ctx = request.getServletContext();
		String path = "/customer/upload/"+fname;  //���� ��� �ִ��� �˰�
		path = ctx.getRealPath(path); //���� ��� ����
		
		File file = new File(path);//���� ��ü�� ������ ��� ����
		FileInputStream fis = new FileInputStream(file);
		
		OutputStream wos = response.getOutputStream();
		
		int count =-1;
		byte[] buf = new byte[1024]; //1kb�� �аڴ�
		while((count = fis.read(buf)) == -1){//�о�°� �?
			wos.write(buf,0,count);
			
			fis.close();
			wos.close();
		}
	}

}
