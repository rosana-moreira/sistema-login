<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Erro</title>
</head>
<body>
	<h1>Mensagem de erro, entre em contato com a equipe de suporte do
		sistema!</h1>
	<%
	out.print(request.getAttribute("msg"));
	%>
</body>
</html>