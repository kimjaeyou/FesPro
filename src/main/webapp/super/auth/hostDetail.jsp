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
<h1>주최자 상세페이지</h1>
	<form action="front?key=superAuth&methodName=hostUpdate" method="post">
        <label for="host_seq">주최자 번호:</label>
        <input type="text" id="host_seq" name="host_seq" value="${host.host_seq}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_id">주최자 아이디:</label>
        <input type="text" id="host_id" name="host_id" value="${host.host_id}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="com_name">기업명:</label>
        <input type="text" id="com_name" name="com_name" value="${host.com_name}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_pw">주최자 비밀번호:</label>
        <input type="text" id="host_pw" name="host_pw" value="${host.host_pw}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_tel">주최자 전화번호:</label>
        <input type="text" id="host_tel" name="host_tel" value="${host.host_tel}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_name">대표자 명:</label>
        <input type="text" id="host_name" name="host_name" value="${host.host_name}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
       <label for="host_check" style="font-weight: bold; background-color: #e0f7fa;">승인 여부:</label>
        <!-- 드롭다운 메뉴로 유저 벤 상태를 선택할 수 있도록 구현 -->
        <select id="host_check" name="host_check">
            <option value="0" <c:if test="${host.host_check == 0}"</c:if> >미승인</option>
            <option value="1" <c:if test="${host.host_check == 1}"</c:if>>승인</option>
        </select><br><br>
        
        <label for="rep_name">가입자 명:</label>
        <input type="text" id="rep_name" name="rep_name" value="${host.rep_name}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_ben_check" style="font-weight: bold; background-color: #e0f7fa;">주최자 벤 여부:</label>
        <!-- 드롭다운 메뉴로 유저 벤 상태를 선택할 수 있도록 구현 -->
        <select id="host_ben_check" name="host_ben_check">
            <option value="0" <c:if test="${host.host_ben_check == 0}"</c:if> >벤</option>
            <option value="1" <c:if test="${host.host_ben_check == 1}"</c:if>>활성화</option>
        </select><br><br>
        
        <input type="submit" value="저장">
    </form>
</body>
</html>