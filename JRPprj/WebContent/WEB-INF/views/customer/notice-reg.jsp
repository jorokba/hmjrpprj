<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.newlec.web.dao.NoticeDao"%>

<%@page import="com.newlec.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.newlec.web.entities.Notice"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="notice-reg" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>등록</legend>
			<table border="2">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value=${n.title} ></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="content" rows="20" cols="60">${n.content}</textarea></td>
				</tr>
			</table>
			<div>
				<%-- <a href="notice">목록</a>
    			<a href="notice-edit?code=${n.code}">수정</a> 삭제 --%>
				<input type="submit" value="등록"> <!--저장하면 보내주겠다(submit이)  -->
				<a href="notice">취소</a>
			</div>
		</fieldset>
	</form>
</body>
</html>
