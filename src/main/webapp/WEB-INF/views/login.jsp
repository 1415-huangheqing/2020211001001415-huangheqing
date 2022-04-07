<%--
  Created by IntelliJ IDEA.
  User: 黄河清
  Date: 2022/3/31
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<form method="post" action="login">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>

</form>
<%@include file="footer.jsp"%>
