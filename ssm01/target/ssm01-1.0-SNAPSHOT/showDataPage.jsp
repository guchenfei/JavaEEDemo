<%--
  Created by IntelliJ IDEA.
  User: guchenfei
  Date: 2023/3/5
  Time: 6:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 requestScope : message:${requestScope.message},uname : ${requestScope.users[0].uname}<br/>
 sessionScope : message:${sessionScope.message},uname : ${sessionScope.users[0].uname}<br/>
 applicationScope : message:${applicationScope.message},uname : ${applicationScope.users[0].uname}<br/>
 requestParam : ${param.message}<br/>
</body>
</html>
