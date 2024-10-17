<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">

<style>
    body {
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px;
    }

    .container {
        width: 100%;
    }

    .form-control {
        width: 100%;
    }

    table {
        width: 100%;
        margin-bottom: 20px;
    }

    .btn-primary, .btn-secondary {
        padding: 10px 20px;
        font-size: 16px;
    }

    .btn-secondary {
        margin-right: 10px; /* 글쓰기 버튼과 간격 추가 */
    }
</style>

<script>
    // 취소 버튼 클릭 시 페이지 이동
    function cancelAction() {
        window.location.href = "${pageContext.request.contextPath}/front?key=board&methodName=readnoti";
    }
</script>

</head>
<body>

    <div class="container">
        <div class="row">
            <form method="post" action="${pageContext.request.contextPath}/front">
                <input type="hidden" name="key" value="board">
                <input type="hidden" name="methodName" value="write">
                <input type="hidden" name="categorySeq" value="1">
                
                <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                    <thead>
                        <tr>
                            <th colspan="2" style="background-color: #eeeeee; text-align: center;">
                                게시판 글쓰기 양식
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
                        </tr>
                        <tr>
                            <td><textarea class="form-control" placeholder="글 내용" name="bbsContent" maxlength="2048" style="height: 350px"></textarea></td>
                        </tr>
                    </tbody>
                </table>
                
                <!-- 취소 버튼 및 글쓰기 버튼 -->
                <button type="button" class="btn btn-secondary" onclick="cancelAction()">취소</button>
                <input type="submit" class="btn btn-primary pull-right" value="글쓰기">
            </form>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>
