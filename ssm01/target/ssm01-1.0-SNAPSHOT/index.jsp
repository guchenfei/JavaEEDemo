<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        .progress {
            width: 200px;
            height: 10px;
            border: 1px solid #ccc;
            border-radius: 10px;
            margin: 10px 0px;
            overflow: hidden;
        }

        /* 初始状态设置进度条宽度为0px */
        .progress > div {
            width: 0px;
            height: 100%;
            background-color: yellowgreen;
            transition: all .3s ease;
        }

    </style>
    <%--    <script type="text/javascript" src="js/jquery.min.js"></script>--%>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#uploadFile").click(function () {
                var photoFile = $("#photo")[0].files[0]
                if (photoFile == undefined) {
                    alert("您还未选中文件")
                    return
                }
                var formData = new FormData()
                formData.append("headPhoto", photoFile)
                $.ajax({
                    type: "post",
                    data: formData,
                    url: "fileUpload.do",
                    processData: false,
                    contentType: false,
                    xhr: function () {
                        var xhr = new XMLHttpRequest();
                        //使用XMLHttpRequest.upload监听上传过程，注册progress事件，打印回调函数中的event事件
                        xhr.upload.addEventListener('progress', function (e) {
                            console.log(e);
                            //loaded代表上传了多少
                            //total代表总数为多少
                            var progressRate = (e.loaded / e.total) * 100 + '%';

                            //通过设置进度条的宽度达到效果
                            $('.progress > div').css('width', progressRate);
                        })

                        return xhr;
                    },
                    success: function (result) {
                        alert(result.message)
                        $("#headImg").attr("src", "http://guchenfei:8090/upload/" + result.newFileName)
                        //将文件类型,文件名放到form表单
                        $("#photoInput").val(result.newFileName)
                        $("#filetypeInput").val(result.fileType)
                    }
                })
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
        </br>
        <img id="headImg" style="width: 200px;height: 200px" alt="您还未上传图片">
        </br>
    <div class="progress">
        <div></div>
    </div>
    <a id="uploadFile" href="javascript:void(0)">立即上传</a>
    </p>
    <%--    使用隐藏输入框--%>
    <input id="photoInput" type="hidden" name="photo">
    <input id="filetypeInput" type="hidden" name="filetype">
    <p><input type="submit" name="注册"></p>
</form>
</body>
</html>
