package com.newlec.web.dao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.web.dao.NoticeDao;
import com.newlec.web.dao.mybatis.MyBatisNoticeDao;
import com.newlec.web.entities.Notice;


@SuppressWarnings("serial")
@WebServlet("/customer/notice-edit") //지금 나는 얘가 가상이지만 같은 디렉토리안에 있는 것 처럼 보이게 할거야!
public class NoticeEditController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		Notice n = new Notice();
		n.setCode(code);
		n.setTitle(title);
		n.setContent(content);
		
		noticeDao.update(n);
		
		response.sendRedirect("notice-detail?code="+code);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String _code = request.getParameter("code");
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice = noticeDao.get(_code);

		request.setAttribute("n", notice);

		request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request, response);
	}
}