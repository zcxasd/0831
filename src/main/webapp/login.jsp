<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/31
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--username的值是从作用域里获取的而jsp页面有pageContext request session application四个作用域--%>
    <h1>欢迎登录！！！${username}</h1>
     <%--测试乱码--%>
    <%--http://localhost:8080/0831_Session/Servlet(不加"/"相对路径,加"/"绝对路径)--%>
    <form method="post" action="Servlet">
        <input name="username"/>
        <input type="submit"/>
    </form>
</body>
</html>
