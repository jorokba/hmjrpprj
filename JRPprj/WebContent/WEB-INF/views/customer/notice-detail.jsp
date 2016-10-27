<%@page import="com.newlec.web.entities.Notice"%>
<%@page import="com.newlec.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.newlec.web.dao.NoticeDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="2">
		<tbody>
			<tr>
				<td>제목</td>
				<td colspan="3">${n.title}</td>
				<%-- requestScope.aa / ${requestScope.aa} / ${pageContext.request.remoteAddr} /--%>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="3">${n.regdate}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${n.writer}</td>
				<td>조회수</td>
				<td>${n.hit}</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4">${n.content}</td>
			</tr>
		</tbody>
	</table>
	<div>
		<a href="notice">목록</a> 		
		<a href="notice-edit?code=${n.code}">수정</a>
		<a href="notice-del?code=${n.code}">삭제</a>
	</div>
</body>
</html>