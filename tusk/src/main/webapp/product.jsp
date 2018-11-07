<%@page import="java.util.ArrayList"%>
<%@page import="com.not4win.electro.api.Store"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Description</title>
</head>
<body>
<h2 name="user">Ashwin</h2>
<% ArrayList<String> res=(ArrayList<String>)request.getAttribute("result");
String[] a=res.get(1).split("\\s+");
String[] b=res.get(2).split("\\s+");
String[] c=res.get(3).split("\\s+");
String[] d=res.get(4).split("\\s+");
String item=res.get(0);

int i=0;
for(i=0;i<a.length;i++)
{
	
	String user=request.getParameter("user");
	user="ashwin";
	String link="buy/"+user+"/"+d[i]+"/"+item+"";
	%>

	<TR>
	<TD><%=a[i]%></TD>
	<TD><%=b[i]%></TD>
	<TD><%=c[i]%></TD>
	<TD><a href=<%=link%> ><%=d[i]%></a></TD>
	</TR>
	
	<% } %>
	<%


%>
<style>
table, th, TD {
    border: 1px solid black;
}
</style>
</body>
</html>