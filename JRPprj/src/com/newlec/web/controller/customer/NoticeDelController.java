package com.newlec.web.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.web.dao.NoticeDao;
import com.newlec.web.dao.mybatis.MyBatisNoticeDao;

@SuppressWarnings("serial")
@WebServlet("/customer/notice-del")
public class NoticeDelController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		noticeDao.delete(code);
		response.sendRedirect("notice");
	}
}
