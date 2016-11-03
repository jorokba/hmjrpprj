<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/<tiles:getAsString name="css"/>" type="text/css" rel="stylesheet" />

<script src="../js/modernizr-custom.js">
</script>

</head>
<body>
	<!------------------ <header> -------------------->
 		<tiles:insertAttribute name="header" />
      <!---------------- <visual> -------------------->
		<tiles:insertAttribute name="visual" />
      <!----------------- <body> --------------------->
      <div id="body">
      	<div class="content-container clearfix">
			<div id = test></div>	

      <!---------------- aside --------------->
	     <tiles:insertAttribute name="aside" />
      <!----------------- main --------------------->
		     <tiles:insertAttribute name="main" />
   		</div>
   	</div>
   <!------------------ footer -------------------->
	  <tiles:insertAttribute name="footer" />
</body>
</html>