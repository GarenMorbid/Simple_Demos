<%@page import="entity.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result</title>
</head>
<body>
	<a href="../add.jsp?method=add">添加</a><br>
	<form action="findAuthorByID.action" method="post">
		<input type="text" name="select_id">
		<input type="submit" value="查询">
	</form>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>密码</td>
			<td>邮箱</td>
			<td>bio</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${authors }" var="author">
			<tr>
				<td>${author.id }</td>
				<td>${author.username }</td>
				<td>${author.password }</td>
				<td>${author.email }</td>
				<td>${author.bio }</td>
				<td>
					<a href="delAuthor.action?id=${author.id }">删除</a>
					<a href="../add.jsp?method=edit&id=${author.id }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>