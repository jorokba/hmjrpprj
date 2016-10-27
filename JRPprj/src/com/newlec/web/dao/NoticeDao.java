package com.newlec.web.dao;

import java.util.List;

import com.newlec.web.entities.Notice;
import com.newlec.web.model.NoticeModel;

public interface NoticeDao {
	Notice get(String code);//�����ͺ��̽��� �ִ� �����͸� ��üȭ���� �޾� ����� ���̱� ������ 
	List<NoticeModel> getList(int page, String field, String query);
	List<NoticeModel> getList(int page);
	List<NoticeModel> getList();
	
	int insert(Notice notice);
	int update(Notice notice);
	int delete(String code);
	int getCount(String field, String query);
	String getlastCode();
}