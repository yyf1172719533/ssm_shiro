<%--
  Created by IntelliJ IDEA.
  User: yyf1172719533
  Date: 2020/4/17
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
        <shiro:hasPermission name="user:query">
                <h1><a href="query.action">查询用户</a></h1>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:add">
                <h1><a href="add.action">添加用户</a></h1>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:update">
                <h1><a href="update.action">修改用户</a></h1>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:delete">
                <h1><a href="delete.action">删除用户</a></h1>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:export">
                <h1><a href="export.action">导出用户</a></h1>
        </shiro:hasPermission>
</body>
</html>
