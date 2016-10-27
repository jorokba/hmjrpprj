package com.newlec.web.dao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.web.dao.NoticeDao;
import com.newlec.web.dao.mybatis.MyBatisNoticeDao;
import com.newlec.web.model.NoticeModel;

@SuppressWarnings("serial")
@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String t = request.getParameter("t");
		String q = request.getParameter("q");
		String p = request.getParameter("p");
		
		int page = 1;
		
		String field = "TITLE";
		String query = "";
		
		if(t != null && !t.equals(""))//빈 문자열도 안된다.
			field = t;
		
		if(q != null)
			query = q;
		
		//if(p != null && !p.equals("")) p가 빈 문자열을 받을 일이 있나??
		if(p != null)
			page = Integer.parseInt(p);
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		List<NoticeModel> list = noticeDao.getList(page, field, query);
		int count = noticeDao.getCount(field, query);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);

		request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp").forward(request, response);
	}
}