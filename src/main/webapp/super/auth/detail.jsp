<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
        /* ��ũ���� �����ϴ� ��Ÿ�� */
        html, body {
            overflow: hidden; /* ��ũ���� ���� */
            height: 100%; /* 100% ���̸� �����ϵ��� ���� */
            margin: 0;
            padding: 0;
        }
        
        /* ������ ��ü ũ�⸦ ä��� ���̾ƿ��� �����ϱ� ���� ��Ÿ�� */
        #layoutSidenav_content {
            min-height: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<h1>ȸ�� ��������</h1>
	<form action="front?key=superAuth&methodName=update" method="post">
        <label for="user_seq">ȸ�� ��ȣ:</label>
        <input type="text" id="user_seq" name="user_seq" value="${user.user_seq}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_id">ȸ�� ���̵�:</label>
        <input type="text" id="user_id" name="user_id" value="${user.user_id}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_pw">��й�ȣ:</label>
        <input type="text" id="user_pw" name="user_pw" value="${user.user_pw}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="age">����:</label>
        <input type="text" id="age" name="age" value="${user.age}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="addr">�ּ�:</label>
        <input type="text" id="addr" name="addr" value="${user.addr}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="gender">����:</label>
        <input type="text" id="gender" name="gender" value="${user.gender}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="email">�̸���:</label>
        <input type="text" id="email" name="email" value="${user.email}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_name">�̸�:</label>
        <input type="text" id="user_name" name="user_name" value="${user.user_name}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="disable">��� ����:</label>
        <input type="text" id="disable" name="disable" value="${user.disable}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_tel">��ȭ��ȣ:</label>
        <input type="text" id="user_tel" name="user_tel" value="${user.user_tel}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="user_ben_check" style="font-weight: bold; background-color: #e0f7fa;">���� �� ����:</label>
        <input type="text" id="user_ben_check" name="user_ben_check" value="${user.user_ben_check}"><br><br>
        
        
        <input type="submit" value="����">
    </form>
</body>
</html>