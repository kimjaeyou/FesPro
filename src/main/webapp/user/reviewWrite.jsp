<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>리뷰 작성</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* 화면 높이를 꽉 채우기 */
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        .form-container {
            max-width: 400px; /* 작은 창처럼 보이게 하기 위해 최대 너비를 줄임 */
            width: 100%;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
            color: #555;
            display: block;
            margin-bottom: 10px;
        }

        textarea, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        textarea {
            height: 100px; /* 작은 창에 맞춰 높이를 줄임 */
        }

        .button-group {
            display: flex;
            justify-content: space-between;
        }

        .button-group button {
            width: 48%;
            padding: 10px;
            font-size: 14px; /* 작은 창에 맞춰 폰트 크기 줄임 */
            cursor: pointer;
            border-radius: 4px;
            border: none;
            transition: background-color 0.3s ease;
        }

        .submit-button {
            background-color: #5cb85c;
            color: white;
        }

        .submit-button:hover {
            background-color: #4cae4c;
        }

        .cancel-button {
            background-color: #d9534f;
            color: white;
        }

        .cancel-button:hover {
            background-color: #c9302c;
        }

        .rating-container {
            text-align: center;
            margin-bottom: 20px;
        }

        .rating-container select {
            width: auto;
            display: inline-block;
            font-size: 16px; /* 폰트 크기를 작게 조정 */
        }

        .already-exists {
            text-align: center;
            font-size: 16px;
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>간단 리뷰 작성</h2>
        <c:choose>
            <c:when test="${reviewExists}">
                <p class="already-exists">이미 해당 예약에 대한 리뷰를 작성하셨습니다.</p>
            </c:when>
            <c:otherwise>
                <form action="${path}/front?key=superAuth&methodName=reviewInsert" method="post">
                    <input type="hidden" name="svcId" value="${svcId}">
                    <input type="hidden" name="userSeq" value="${userSeq}">
                    <label for="reviewContent">리뷰 내용:</label>
                    <textarea id="reviewContent" name="reviewContent"></textarea>

                    <div class="rating-container">
                        <label for="reviewRating">별점 (1-5):</label><br>
                        <select id="reviewRating" name="reviewRating">
                            <option value="1">1점</option>
                            <option value="2">2점</option>
                            <option value="3">3점</option>
                            <option value="4">4점</option>
                            <option value="5">5점</option>
                        </select>
                    </div>

                    <div class="button-group">
                        <button type="submit" class="submit-button">리뷰 제출</button>
                        <button type="button" class="cancel-button" onclick="cancelReview()">등록 취소</button>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>

    <script>
        function cancelReview() {
            window.location.href = '${path}/front?key=mypage&methodName=resSelectAll'; // 원하는 경로로 수정
        }
    </script>
</body>
</html>