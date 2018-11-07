<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<html>
<head>
<title>display data from the table using jsp</title>
</head>
<body>
<h2>Data from the table</h2>
<h3 name="data">mobile_phones</h3>
<%
String DRIVER = "org.apache.derby.jdbc.ClientDriver";
String JDBC_URL = "jdbc:derby:/home/ashwin/MyDB;create=true";
String data=request.getParameter("data");
try {
Connection connection = null;
Statement statement = null;
ResultSet rs = null;
Class.forName(DRIVER);
connection = DriverManager.getConnection(JDBC_URL, "root", "root");
statement = connection.createStatement();
String QueryString = "SELECT * from DBCart";
rs = statement.executeQuery(QueryString);
%>
<TABLE cellpadding="15" border="1" style="background-color: #ffffcc;">
<%
while (rs.next()) {
String rep=rs.getString(1);
rep=rep.replace(' ', '-');
%>
<TR>
<TD><%=rs.getString(1)%></TD>
<TD><%=rs.getString(2)%></TD>
<TD><%=rs.getString(3)%></TD>
</TR>
<% } %>
<%
// close all the connections.
rs.close();
statement.close();
connection.close();
} catch (Exception ex) {
%>
</font>
<font size="+3" color="red"></b>
<%
out.println(ex);
}
%>
</TABLE><TABLE>
<TR>
<TD><FORM ACTION="welcome_to_database_query.jsp" method="get" >
<button type="submit"><-- back</button></TD>
</TR>
</TABLE>
</font>
</body>
</html>