<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>

<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css?ver=789" type="text/css" rel="stylesheet" />
<link href="css/notice.css" type="text/css" rel="stylesheet" />
<script src="../js/modernizr-custom.js"></script>
</head>
<body>
	<!------------------ <header> -------------------->
 		<jsp:include page="../inc/header.jsp" />
      <!---------------- <visual> -------------------->
		<jsp:include page="inc/visual.jsp" />
      <!----------------- <body> --------------------->
      <div id="body">
      	<div class="content-container clearfix">	

      <!---------------- aside --------------->
	     <jsp:include page="inc/aside.jsp" />
      <!----------------------- main ----------------------->
	      <main>
		      <h2>공지사항</h2>
		
		      <div id="breadlet">
		         <h3>breadlet</h3>
		         <ul>
		            <li>home</li>
		            <li>고객센터</li>
		            <li>공지사항</li>
		         </ul>
		      </div>
		
		      <div>
		         <h3>공지사항 검색폼</h3>
		         <form>
		            <fieldset>
		               <legend>공지사항 검색</legend>
		               <select>
		                  <option>제목</option>
		                  <option>작성자</option>
		               </select> 
		               <label>검색어</label> 
		               	<input type="text" /> 
		               	<input type="submit" value="검색" />
		            </fieldset>
		         </form>
		      </div>
		
		      <div>
		         <h3>공지사항 목록</h3>
		         <table>
		            <thead>
		               <tr>
		                  <td>번호</td>
		                  <td>제목</td>
		                  <td>작성자</td>
		                  <td>작성일</td>
		                  <td>조회수</td>
		               </tr>
		            </thead>
		            <tbody>
		               <c:forEach var="n" items="${list}">
						<tr>
							<td>${n.code}</td>
							<td><a href="notice-detail?code=${n.code}">${n.title}</a></td>
							<td>${n.writer}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regdate}" />
							</td>
							<td>${n.hit}</td>
						</tr>
					</c:forEach>
		            </tbody>
		         </table>
		      </div>
		
		     	 범용적인 도구
		      <div>
		         <h3>현재 페이지</h3>
		         <div>1/3 pages</div>
		      </div>
		
		      <div>
		         <h3>페이지</h3>
					<s:pager />
		
		      </div>
	      </main>
   		</div>
   	</div>
   <!-------------------- footer --------------------->
	  <jsp:include page="../inc/footer.jsp" />
</body>
</html>