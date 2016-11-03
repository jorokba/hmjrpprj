package com.newlec.web.controller.customer;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@SuppressWarnings("serial")
@WebServlet("/customer/notice-reg")
public class NoticeRegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
	    container.render("customer.notice-reg", request, response);
	    container.endContext(request, response);
		
		/*request.getRequestDispatcher("/WEB-INF/views/customer/notice-reg.jsp").forward(request, response);*/ //forward- �̾ ����ϰڴ�.
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/customer/upload");
		System.out.println(path);
	
		MultipartRequest req = new MultipartRequest(request, path, 1024*1024*100, "UTF-8", new DefaultFileRenamePolicy());
		
		/*request.setCharacterEncoding("UTF-8");	//�ѱ۷� ����� �����ϰ� */
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		Notice n = new Notice();
		n.setTitle(title);
		n.setContent(content);
		
		n.setWriter("oldlec");
		
		noticeDao.insert(n);
		String lastCode = noticeDao.getlastCode();
		
		Enumeration en = req.getFileNames();
		
		/*String fname = req.getFilesystemName("file");*/
		
		NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();  //���
		int cnt=0; //???????
		
		while(en.hasMoreElements()){
			NoticeFile nf = new NoticeFile();
			String name = (String)en.nextElement();
			String fname = req.getFilesystemName(name);
			nf.setSrc(fname);
			nf.setNoticeCode(lastCode);
			noticeFileDao.insert(nf);
			cnt++;//?????
		}
		
		response.sendRedirect("notice");
	}
}
