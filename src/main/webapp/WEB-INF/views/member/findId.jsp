<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<%--
  Created by IntelliJ IDEA.
  User: sche1
  Date: 2022-11-10
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>FINDID</title>
    <script>
        $(document).ready(function (){
            $('#findBtn').click(function (){

                $.ajax({
                    type:"POST",
                    url: "/member/findId",
                    data : {
                        email : $('#email').val()
                    },
                    success : function (data) {
                        result:data,
                        document.getElementById("view1").style.display = "none";
                        $('.msg').text(data);
                        document.getElementById("view2").style.display = "block";
                    },
                    error: function (data) {
                        result:data,
                        alert("실패")
                        document.getElementById("view1").style.display = "none";
                        document.getElementById("view2").style.display = "block";
                    },
                });
            });
        });
    </script>
</head>
<body>
<br><br>
<h4 style='text-align:center;'><b>아이디 찾기</b></h4><hr><br>
<div class='row'>
    <div class='col' id='view1' style='text-align:center;'>
        <label>이메일&emsp;</label>
        <input type='text' id='email' name='email'/><br><br><br>
        <div  style="display: flex; justify-content: center;">
              <button type='button' class='btn btn-secondary btn-block'
                        id='findBtn' style="width:120">아이디 찾기</button>
        </div>
    </div>
    <div class='col' id='view2'  style ="display:none;text-align:center" >
        <span class="msg"></span><br><br><br>
        <div  style="display: flex; justify-content: center;">
            <button type='button' class='btn btn-secondary btn-block'
                    id='mainBtn' style="width: 120" onclick="location.href='/'">메인으로</button>
        </div>
    </div>
</div>
</body>
</html>