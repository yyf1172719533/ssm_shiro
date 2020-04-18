<%--
  Created by IntelliJ IDEA.
  User: yyf1172719533
  Date: 2020/4/17
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2 align="center">用户登录</h2>
    <form action="${pageContext.request.contextPath}/login/login.action" method="post">
        <table width="30%" align="center" border="1" cellpadding="2" cellspacing="2">
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="text" name="username" >
                </td>
            </tr>
            <tr>
                <td align="right">密码:</td>
                <td>
                    <input type="password" name="pwd" >
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="登陆">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
