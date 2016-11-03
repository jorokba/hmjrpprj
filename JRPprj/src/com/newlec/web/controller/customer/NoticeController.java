package com.newlec.web.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

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
		
		if(t != null && !t.equals(""))
			field = t;
		
		
		if(q != null)
			query = q;
		
		//if(p != null && !p.equals(""))
		if(p != null)
			page = Integer.parseInt(p);
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		List<NoticeModel> list = noticeDao.getList(page, field, query);
		int count = noticeDao.getCount(field, query);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
	      container.render("customer.notice", request, response);
	      container.endContext(request, response);
		/*request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp").forward(request, response);*/
	}
}