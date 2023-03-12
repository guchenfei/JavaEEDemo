<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #playerTable {
            width: 50%;
            border: 3px solid cadetblue;
            margin: 0px auto;
            text-align: center;
        }

        #playerTable th, td {
            border: 1px solid gray;
        }

        #playerTable img {
            width: 100px;
            height: 100px;
        }
    </style>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                type: "get",
                url: "getAllPlayer",
                success: function (players) {
                    $.each(players, function (i, e) {
                        console.log(e)
                        $("#playerTable").append(
                            '<tr> ' +
                            '<td> ' +e.id+'</td>' +
                            '<td>'+e.name+'</td>' +
                            '<td>'+e.password+'</td>' +
                            '<td>'+e.nickname+'</td>' +
                            '<td>' +
                            '    <img src="http://guchenfei:8090/upload/'+e.photo+'" alt="暂未发现图片"> ' +
                            '</td>' +
                            '<td>' +
                            '  <a href="fileDownload.do?photoName='+e.photo+'&fileType='+e.filetype+'">下载</a>' +
                            '</td>' +
                            '</tr>'
                        )
                    })
                }
            })
        })
    </script>
</head>
<body>
<table id="playerTable" cellspacing="0xp" cellpadding="0px">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>昵称</th>
        <th>头像</th>
        <th>操作</th>
    </tr>
</table>
</body>
</html>