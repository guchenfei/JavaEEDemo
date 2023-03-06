<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
<%--    <script type="text/javascript" src="js/jquery.min.js"></script>--%>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#uploadFile").click(function(){
                alert("上传文件")
            })
        })
    </script>
</head>
<body>
 <form action="addPlayer" method="post">
     <p>账号:<input type="text" name="name"></p>
     <p>密码:<input type="text" name="password"></p>
     <p>昵称:<input type="text" name="nickname"></p>
     <p>头像:<br/>
         <input id="photo" type="file">
         <a id="uploadFile" href="javascript:void(0)">立即上传</a>
     </p>
     <p>昵称:<input type="submit" name="注册"></p>
 </form>
</body>
</html>
