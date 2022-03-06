<%--
  Created by IntelliJ IDEA.
  User: 黄河清
  Date: 2022/3/6
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>


<%@include file="header.jsp"%>
   <form method="post" action="register">
       username<input type="text" name="username"/><br/>
       password<input type="password" name="password"/><br/>
       Email<input type="text" name="email"/><br/>
       Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">female<br/>
       Date of Birth:<input type="text name" name="birthDate"><br/>
       <input type="submit" value="Register"/>
   </form>

<%@include file="footer.jsp"%>


