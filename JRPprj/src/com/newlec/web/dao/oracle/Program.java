/*package com.newlec.web.dao.oracle;

import java.sql.SQLException;

import com.newlec.web.dao.sqlserver.SqlServerNoticeDao;
import com.newlec.web.entities.Notice;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SqlServerNoticeDao dao = new SqlServerNoticeDao();
		
		Notice notice = new Notice();
		
		notice.setTitle("다오 테스트");
		notice.setWriter("다오");
		notice.setContent("다오를 위한 테스트 파일");
		
		int c = dao.insert(notice);
		
		System.out.println(c);
	}
}*/