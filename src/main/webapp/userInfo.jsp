<%--
  Created by IntelliJ IDEA.
  User: 黄河清
  Date: 2022/4/10
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr>
        <td>Username</td><td><%=request.getParameter("username")%></td>
    </tr><tr>
    <td>Password</td><td><%=request.getAttribute("password")%></td>
</tr><tr>
    <td>Email</td><td><%=request.getAttribute("email")%></td>
</tr><tr>
    <td>Gender</td><td><%=request.getAttribute("gender")%></td>
</tr><tr>
    <td>Birth Date</td><td><%=request.getAttribute("birthdate")%></td>
</tr>
</table>
<%@include file="footer.jsp"%>
