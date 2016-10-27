package com.newlec.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.newlec.web.dao.NoticeFileDao;
import com.newlec.web.entities.NoticeFile;

public class MyBatisNoticeFileDao implements NoticeFileDao{
	private SqlSessionFactory ssf;
	
	public MyBatisNoticeFileDao(){
		ssf = NewlecSessionFactoryBuilder.getSqlsessionfactory();
	}
	
	@Override
	public List<NoticeFile> getList(String noticeCode) {
		SqlSession session = ssf.openSession();
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);
		
		List<NoticeFile> list = noticeFileDao.getList(noticeCode);
		session.close();
		
		return list;
	}

	@Override
	public int insert(NoticeFile file) {
		SqlSession session = ssf.openSession();
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);
		
		int result = noticeFileDao.insert(file);
		
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int update(NoticeFile file) {
		SqlSession session = ssf.openSession();
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);
		
		int result = noticeFileDao.update(file);
		
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int delete(String code) {
		SqlSession session = ssf.openSession();
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);
		
		int result = noticeFileDao.delete(code);
		
		session.commit();
		session.close();
		return result;
	}
}