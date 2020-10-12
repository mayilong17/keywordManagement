<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/12
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
</head>
<body>
<form action="findAllServlet?comm=add" method="post" id="add">
    <table align="center" width="600px" border="1">
        <tr align="center">
            <td colspan="3"><h3>添加关键词</h3></td>
        </tr>
        <tr align="center">
            <td width="200">关键词（*）：</td>
            <td width="200"><input type="text" name="name" id="name"></td>
            <td><span id="mname"></span></td>

        </tr>
        <tr align="center">
            <td width="200">业务类型（*）：</td>
            <td width="200"><input type="text" name="type" id="type"></td>
            <td><span id="mtype"></span></td>

        </tr>
        <tr align="center">
            <td width="200">创建时间（*）：</td>
            <td width="200"><input type="text" name="date" id="date"></td>
            <td><span id="mdate"></span></td>
        </tr>
        <tr align="center">
            <td colspan="3"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
