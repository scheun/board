<%--
  Created by IntelliJ IDEA.
  User: sche1
  Date: 2022-11-10
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>INSERTBOARD</title>
    <script>
        $(document).ready(function () {
            $("#insertBtn").click(function () {

                var boards = {
                    title: $('#title').val(),
                    content: $('#content').val()
                }


                $.ajax({
                    type: "POST",
                    url: "/insertBoard",
                    data: boards,
                    success : function (data) {
                        result: data,
                            location.href="/"
                    },
                    error : function (data) {
                        result: data,
                            alert("글 작성 실패")
                    }
                })
            })
        })
    </script>
</head>
<style>
    .container {
        width: 1500px;
        margin: 0 auto;
    }
</style>
<body>
<div style="text-align: center">
    <br><h3>글&nbsp;작성</h3>
</div>
<div class="container" >
    <div class='row'>
        <div class='col'>
            <input type='text' placeholder='제목을 입력하세요.'
                   style='border:none;' minlength='3' id='title'/><hr>
            <textarea placeholder='내용을 입력하세요.'  style='width:100%' rows='15' id='content'></textarea>
            <div style='float:right; margin-top:10px;'>
                <button id='insertBtn'>등록</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>