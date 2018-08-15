<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
</head>
<body>
	<a href="author/getAllAuthors.action">返回</a><br>
	<c:choose>
		<c:when test="${param.method == 'add'}">
			<form action="author/addAuthor.action" method="post">
				用户名：<input type="text" name="username"><br>
				密码：<input type="password" name="password"><br>
				email：<input type="text" name="email"><br>
				bio：<input type="text" name="bio"><br>
				<input type="submit" value="添加">
			</form>
		</c:when>
		 <c:otherwise>
			<form action="author/updateAuthor.action" method="post">
				<input type="hidden" name="id" value="${param.id }"><br>
				用户名：<input type="text" name="username"><br>
				密码：<input type="password" name="password"><br>
				email：<input type="text" name="email"><br>
				bio：<input type="text" name="bio"><br>
				<input type="submit" value="修改">
			</form>
		</c:otherwise>
	</c:choose>

</body>
</html>