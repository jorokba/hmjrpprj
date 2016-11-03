<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${empty param.p}">
		<c:set var="page" value="1" />
	</c:if>
	<c:if test="${not empty param.p}">
		<c:set var="page" value="${param.p}" />
	</c:if>
	
	<c:set var="start" value="${page-(page-1)%5}" />
		<c:set var="end" value="${fn:substringBefore((count%10==0?count/10:count/10+1), '.')}" />
<div>
		<div><a href="notice?p=${(start==1)?1:start-1}">이전 페이지 목록</a></div>
		<div><a href="notice?p=${(page==1)?1:page-1}">이전</a></div>
		<ul>
			<c:forEach var="i" begin="0" end="4"> <!-- p는 페이지..?!  -->
				<c:if test="${start+i <= end}">
					<c:if test="${page==start+i}">
						<li><a href="notice?p=${start+i}&t=${param.t}&q=${param.q}" class="strong">${start+i}</a></li> <!--현재 페이지와 같은 녀석은 이런아이  -->
					</c:if>
					<c:if test="${page!=start+i}">
						<li><a href="notice?p=${start+i}&t=${param.t}&q=${param.q}">${start+i}</a></li> <!-- 같지 않은 녀석은 이 아이  -->
					</c:if>
				</c:if>
			</c:forEach>
		</ul>
		<div><a href="notice?p=${(page==1)?1:page+1}&t=${param.t}&q=${param.q}">다음</a></div>
		<div><a href="notice?p=${start+5}&t=${param.t}&q=${param.q}">다음 페이지 목록</a></div>
	</div>