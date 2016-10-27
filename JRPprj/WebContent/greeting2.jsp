<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="greeting" method="get">
		<fieldset>
			<legend>환영인사 입력 폼</legend>
			<div>
				<label>반복횟수:</label>
				<input type="text" name="cnt"/>
			</div>
			<div>
				<input type="submit" name="say hello" />
			</div>
		</fieldset>
	</form>
	<% int pag = 2; %>
	<% out.print(3+4); %>
</body>
</html>