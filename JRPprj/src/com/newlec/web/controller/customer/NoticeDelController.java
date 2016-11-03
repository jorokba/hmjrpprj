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
import com.newlec.web.dao.NoticeFileDao;
import com.newlec.web.dao.mybatis.MyBatisNoticeDao;
import com.newlec.web.dao.mybatis.MyBatisNoticeFileDao;
import com.newlec.web.entities.Notice;
import com.newlec.web.entities.NoticeFile;

@SuppressWarnings("serial")
@WebServlet("/customer/notice-del")
public class NoticeDelController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		Notice notice;
	    List<NoticeFile> noticeFiles;
		
	    notice = noticeDao.get(code);
		noticeFiles = noticeFileDao.getList(code);
		
		request.setAttribute("n", notice);
	    request.setAttribute("files", noticeFiles);
	      
	    TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
	    container.render("customer.notice-del", request, response);
	    container.endContext(request, response);  
	      /*request.getRequestDispatcher("/WEB-INF/views/customer/notice-detail.jsp");*/
	}
}
