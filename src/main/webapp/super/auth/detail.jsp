<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
        /* 스크롤을 제거하는 스타일 */
        html, body {
            overflow: hidden; /* 스크롤을 숨김 */
            height: 100%; /* 100% 높이를 차지하도록 설정 */
            margin: 0;
            padding: 0;
        }
        
        /* 페이지 전체 크기를 채우는 레이아웃을 유지하기 위한 스타일 */
        #layoutSidenav_content {
            min-height: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<h1>회원 상세페이지</h1>
	<form action="front?key=superAuth&methodName=update" method="post">
        <label for="user_seq">회원 번호:</label>
        <input type="text" id="user_seq" name="user_seq" value="${user.user_seq}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_id">회원 아이디:</label>
        <input type="text" id="user_id" name="user_id" value="${user.user_id}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_pw">비밀번호:</label>
        <input type="text" id="user_pw" name="user_pw" value="${user.user_pw}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="age">나이:</label>
        <input type="text" id="age" name="age" value="${user.age}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="addr">주소:</label>
        <input type="text" id="addr" name="addr" value="${user.addr}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="gender">성별:</label>
        <input type="text" id="gender" name="gender" value="${user.gender}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="email">이메일:</label>
        <input type="text" id="email" name="email" value="${user.email}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_name">이름:</label>
        <input type="text" id="user_name" name="user_name" value="${user.user_name}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="disable">장애 여부:</label>
        <input type="text" id="disable" name="disable" value="${user.disable}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_tel">전화번호:</label>
        <input type="text" id="user_tel" name="user_tel" value="${user.user_tel}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_ben_check" style="font-weight: bold; background-color: #e0f7fa;">유저 벤 여부:</label>
        <!-- 드롭다운 메뉴로 유저 벤 상태를 선택할 수 있도록 구현 -->
        <select id="user_ben_check" name="user_ben_check">
            <option value="0" <c:if test="${user.user_ben_check == 0}"</c:if>>벤</option>
            <option value="1" <c:if test="${user.user_ben_check == 1}"</c:if>>활성화</option>
        </select><br><br>
        
        
        <input type="submit" value="저장">
    </form>
</body>
</html>