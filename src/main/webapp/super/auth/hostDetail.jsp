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
<h1>������ ��������</h1>
	<form action="front?key=superAuth&methodName=hostUpdate" method="post">
        <label for="host_seq">������ ��ȣ:</label>
        <input type="text" id="host_seq" name="host_seq" value="${host.host_seq}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_id">������ ���̵�:</label>
        <input type="text" id="host_id" name="host_id" value="${host.host_id}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="com_name">�����:</label>
        <input type="text" id="com_name" name="com_name" value="${host.com_name}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_pw">������ ��й�ȣ:</label>
        <input type="text" id="host_pw" name="host_pw" value="${host.host_pw}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_tel">������ ��ȭ��ȣ:</label>
        <input type="text" id="host_tel" name="host_tel" value="${host.host_tel}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_name">��ǥ�� ��:</label>
        <input type="text" id="host_name" name="host_name" value="${host.host_name}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_check" style="font-weight: bold; background-color: #e0f7fa;">���ο���:</label>
        <input type="text" id="host_check" name="host_check" value="${host.host_check}" ><br><br>
        
        <label for="rep_name">������ ��:</label>
        <input type="text" id="rep_name" name="rep_name" value="${host.rep_name}" readonly style="color: gray; background-color: #f0f0f0;"><br><br>
        
        <label for="host_ben_check" style="font-weight: bold; background-color: #e0f7fa;">�� ����:</label>
        <input type="text" id="host_ben_check" name="host_ben_check" value="${host.host_ben_check}" ><br><br>
        
        <input type="submit" value="����">
    </form>
</body>
</html>