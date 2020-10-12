<%--
  Created by IntelliJ IDEA.
  User: 蚂蚁
  Date: 2020/10/11
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
    <script type="text/javascript" src="js/show.js"></script>
</head>
<body>
<table border="1px" width="400px" align="center">
    <tr align="center">
        <td colspan="5"><h2>关键词信息列表</h2></td>
    </tr>
    <tr align="center">
    <td>编号</td>
    <td>关键词名称</td>
    <td>业务类型</td>
    <td>创建时间</td>
    <td>操作</td>
</tr>
    <c:forEach items="${list}" var="keyword" >
    <tr align="center">
    <td>${keyword.id}</td>
    <td>${keyword.name}</td>
    <td>${keyword.type}</td>
    <td> <fmt:formatDate value="${keyword.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
    <td><a href="javascript:del('${keyword.id}')">删除</a></td>
</tr>
    </c:forEach>
</table>
<div align="center">
    <form a action="/keywordManagement/add.jsp" method="post">
        <input type="submit" value="添加关键词">
    </form>
</div>

</body>
</html>
