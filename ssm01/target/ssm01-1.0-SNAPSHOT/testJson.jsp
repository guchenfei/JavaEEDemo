<%--
  Created by IntelliJ IDEA.
  User: guchenfei
  Date: 2023/3/11
  Time: 4:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script>
        $(function (){
            var jsonObj = {ename:"zhangsan",hiredate:"2022-2-2"}
            var jsonStr = JSON.stringify(jsonObj);
            console.log(jsonStr)
            $.ajax({
                url:"demo1.action",
                data:jsonStr,
                type:"post",
                contentType:"application/json",
                success:function(result){
                    console.log(result)
                }
            })
        })
    </script>
</head>
<body>

</body>
</html>
