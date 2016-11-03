package com.newlec.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//(NoticeDao, MyBatisNoticeDao, NewlecSessionFactoryBuilder, config.xml, NoticeMapper.xml, notice-detail.jsp)�� ��� MyBatis
public class NewlecSessionFactoryBuilder extends HttpServlet{
	static String src = "com/newlec/web/dao/mybatis/config.xml";
	static SqlSessionFactory ssf = null;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
InputStream is = null;
		
		try{
			is = Resources.getResourceAsStream(src);
		}catch (IOException e) {
			e.printStackTrace();
		}
		ssf = new SqlSessionFactoryBuilder().build(is);
	}

	/*static{
		InputStream is = null;
		
		try{
			is = Resources.getResourceAsStream(src);
		}catch (IOException e) {
			e.printStackTrace();
		}
		ssf = new SqlSessionFactoryBuilder().build(is);
	}*/
	
	public static SqlSessionFactory getSqlsessionfactory(){
		return ssf;
	}
}
