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
@WebServlet("/customer/notice-detail") //���� ���� �갡 ���������� ���� ���丮�ȿ� �ִ� �� ó�� ���̰� �Ұž�!
public class NoticeDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
		
		Notice notice;
		Notice prev;
		Notice next;
		
		noticeDao.hitUp(_code);
		List<NoticeFile> noticeFiles; //���� ������ �ø����ϱ�?
		
		notice = noticeDao.get(_code);
		prev = noticeDao.getPrev(_code);
		next = noticeDao.getNext(_code);
		noticeFiles = noticeFileDao.getList(_code);
		
		request.setAttribute("n", notice);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("files", noticeFiles);

		/*TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("customer.notice-detail", request, response);*/
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
	      container.render("customer.notice-detail", request, response);
	      container.endContext(request, response);
		/*request.getRequestDispatcher("/WEB-INF/views/customer/notice-detail.jsp").forward(request, response);*/
	}
}