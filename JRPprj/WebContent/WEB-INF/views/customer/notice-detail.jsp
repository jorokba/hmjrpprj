<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<main>
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
				<td colspan="3">
					<c:forEach var="f" items="${files}" varStatus="s"> 
						<a href="../download?f="${f.src}">${f.src}</a>
						<c:if test="${!s.last}">,</c:if>	
						<%-- index : ${s.index} / count : ${s.count} / ${s.first}/${s.last} <br/><!--count 개수. 몇번 반복되었을까.  --> --%>						
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="4">${n.content}</td>
					<c:forEach var="f" items="${files}" varStatus="s"> 
						<img src="upload/${f.src}" />					
					</c:forEach>
			</tr>
		</tbody>
	</table>
	<div>
		이전글 :<a href="notice-detail?code=${prev.code}">${prev.title}</a>
		<c:if test="${empty prev.code}">
			이전글이 없습니다.
		</c:if>
	</div>
	<div>
		다음글 :<a href="notice-detail?code=${next.code}">${next.title}</a>
		<c:if test="${empty next.code}">
			다음글이 없습니다.
		</c:if>
	</div>
	<div>
		<a href="notice">목록</a> 		
		<a href="notice-edit?code=${n.code}">수정</a>
		<a href="notice-del?code=${n.code}">삭제</a>
	</div>
</main>
			 