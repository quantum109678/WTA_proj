<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Failure!</title>
</head>
<body>
<h2>Your access has been denied bitch!</h2>
<h3><%=request.getAttribute("result") %></h3> 
<p> Try to access again</p>

<a href="tryy">Try_Again</a>
</body>
</html>