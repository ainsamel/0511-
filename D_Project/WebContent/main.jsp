<%@page session="false" import="java.util.Iterator"%>
<html>
<head>
<title>Login Form</title>
</head>
<body>
	<h2>Login Form</h2>
	<%--  <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
            --%>

	<form action="loginServlet" method="post">
		<table>
			<tr>
				<td>Login Select:</td>
				<td><select name="usertype">
						<option name="usertype" value="unknown">Your Select
						<option name="usertype" value="A">Administrator
						<option name="usertype" value="C">Customer
				</select></td>
			</tr>
			<tr>
				<td>Userid:</td>
				<td><input type="text" name="Userid" size="24"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" size="24"></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>