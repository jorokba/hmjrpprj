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
@WebServlet("/customer/notice-detail") //���� ���� �갡 ���������� ���� ���丮�ȿ� �ִ� �� ó�� ���̰� �Ұž�!
public class NoticeDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice = noticeDao.get(_code);

		request.setAttribute("n", notice);

		request.getRequestDispatcher("/WEB-INF/views/customer/notice-detail.jsp").forward(request, response);
	}
}