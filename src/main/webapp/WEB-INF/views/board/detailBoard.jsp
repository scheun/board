<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sche1
  Date: 2022-10-05
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="utf-8">
    <title>detailBoard</title>
    <script>
    </script>
</head>
<style>
    table {
        border-collapse: collapse;
        border-spacing: 0;
    }
    section.notice {
        padding: 80px 0;
    }

    .page-title {
        margin-bottom: 60px;
    }
    .page-title h3 {
        font-size: 28px;
        color: #333333;
        font-weight: 400;
        text-align: center;
    }

    #board-search .search-window {
        padding: 15px 0;
        background-color: #f9f7f9;
    }
    #board-search .search-window .search-wrap {
        position: relative;
        /*   padding-right: 124px; */
        margin: 0 auto;
        width: 80%;
        max-width: 564px;
    }
    #board-search .search-window .search-wrap input {
        height: 40px;
        width: 100%;
        font-size: 14px;
        padding: 7px 14px;
        border: 1px solid #cccccc;
    }
    #board-search .search-window .search-wrap input:focus {
        border-color: #333;
        outline: 0;
        border-width: 1px;
    }
    #board-search .search-window .search-wrap .btn {
        position: absolute;
        right: 0;
        top: 0;
        bottom: 0;
        width: 108px;
        padding: 0;
        font-size: 16px;
    }

    .board-table {
        font-size: 13px;
        width: 100%;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
    }

    .board-table a {
        color: #333;
        display: inline-block;
        line-height: 1.4;
        word-break: break-all;
        vertical-align: middle;
    }
    .board-table a:hover {
        text-decoration: underline;
    }
    .board-table th {
        text-align: center;
    }

    .board-table .th-num {
        width: 100px;
        text-align: center;
    }

    .board-table .th-date {
        width: 200px;
    }

    .board-table th, .board-table td {
        padding: 14px 0;
    }

    .board-table tbody td {
        border-top: 1px solid #e7e7e7;
        text-align: center;
    }

    .board-table tbody th {
        padding-left: 28px;
        padding-right: 14px;
        border-top: 1px solid #e7e7e7;
        text-align: left;
    }

    .board-table tbody th p{
        display: none;
    }

    .btn {
        display: inline-block;
        padding: 0 30px;
        font-size: 15px;
        font-weight: 400;
        background: transparent;
        text-align: center;
        white-space: nowrap;
        vertical-align: middle;
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        border: 1px solid transparent;
        text-transform: uppercase;
        -webkit-border-radius: 0;
        -moz-border-radius: 0;
        border-radius: 0;
        -webkit-transition: all 0.3s;
        -moz-transition: all 0.3s;
        -ms-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
    }

    * {
        list-style: none;
        text-decoration: none;
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }

    .container {
        width: 1500px;
        margin: 0 auto;
    }
</style>
<body>
<section class="notice">
    <div class="page-title">
        <div class="container">
            <h3>글 상세</h3>
        </div>
    </div>
    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">제목</th>
                    <th scope="col" class="th-date">작성자</th>
                    <th scope="col" class="th-date">등록일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="board" items="${board}">
                    <tr style="width: 100rem">
                        <td>${board.boardNum}<input type='hidden' id='board_num' value='${board.boardNum}' readonly></td>
                        <td>${board.title}</td>
                        <td>${board.id}</td>
                        <td>${board.date}</td>
                    </tr>
                </c:forEach>
                </tbody><br>
                <table class='table'>
                    <c:forEach var="board" items="${board}">
                        <tr>
                            <td><textarea id='content' cols='210' rows='15' readonly>${board.content}</textarea></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>
                            <div style='float:right;'>
                                <button type='button' id='listBtn' class='btn btn-outline-secondary btn-sm'
                                        onclick="location.href='/'">목록</button>
                                <button type='button' id='delBtn' class='btn btn-outline-secondary btn-sm'>삭제 </button>
                                <button type='button' id='fixBtn' class='btn btn-outline-secondary btn-sm'>수정 </button>
                            </div>
                        </td>
                    </tr>
                </table>
            </table>
        </div>
    </div>
</section>
</body>
</html>