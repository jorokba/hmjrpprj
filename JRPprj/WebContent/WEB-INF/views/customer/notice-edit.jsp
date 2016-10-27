<%@page import="com.newlec.web.entities.Notice"%>
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
	<h1>수정 페이지</h1>
	<form action="notice-edit" method="post">
		<fieldset>
			<legend>공지사항 수정 정보 필드</legend>
			<table border="2">
				<tbody>
					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text" name="title" value="${n.title}" /></td>
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
						<td colspan="4">
							<textarea name="content" rows="20" cols="60">${n.content}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<input type="hidden" name="code" value="${n.code}" /><!-- name="code"가 무엇인가 키값이 무엇인가 -->
				<input type="submit" value="저장" /> 
				<a href="notice-detail?code=${n.code}">취소</a>
			</div>
		</fieldset>
	</form>
</body>
</html>