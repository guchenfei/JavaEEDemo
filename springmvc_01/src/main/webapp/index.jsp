<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
<script>
    $(function (){
        $("#btn").click(function (){
            $.get("testAjax",{pname:"aaa",page:"10"},function (data){
                // console.log(data.petName)
                // console.log(data.petType)
                console.log(data)
            })
        })
    })

</script>

</head>
<body>
     <input id="btn" type="button" value="testJson">
</body>
</html>
