<%@page import="wep.mvc.dto.FesDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��ȭ��� ��������</h1>
	FesDto = ${fes}
	<form action="front?key=superfestival&methodName=update" method="post">
        <label for="SVCID">���� ���̵�:</label>
        <input type="text" id="SVCID" name="SVCID" value="${fes.SVCID}" readonly><br><br>
        
        <label for="MAXCLASSNM">��з���:</label>
        <input type="text" id="MAXCLASSNM" name="MAXCLASSNM" value="${fes.MAXCLASSNM}"><br><br>
        
        <label for="MINCLASSNM">�Һз���:</label>
        <input type="text" id="MINCLASSNM" name="MINCLASSNM" value="${fes.MINCLASSNM}"><br><br>
        
        <label for="SVCSTATNM">���� ����:</label>
        <input type="text" id="SVCSTATNM" name="SVCSTATNM" value="${fes.SVCSTATNM}"><br><br>
        
        <label for="SVCNM">���񽺸�:</label>
        <input type="text" id="SVCNM" name="SVCNM" value="${fes.SVCNM}"><br><br>
        
        <label for="PAYATNM">���� ���:</label>
        <input type="text" id="PAYATNM" name="PAYATNM" value="${fes.PAYATNM}"><br><br>
        
        <label for="PLACENM">��Ҹ�:</label>
        <input type="text" id="PLACENM" name="PLACENM" value="${fes.PLACENM}"><br><br>
        
        <label for="USETGTINFO">���� ���:</label>
        <input type="text" id="USETGTINFO" name="USETGTINFO" value="${fes.USETGTINFO}"><br><br>
        
        <label for="X">��� X ��ǥ:</label>
        <input type="text" id="X" name="X" value="${fes.getX()}"><br><br>
        
        <label for="Y">��� Y ��ǥ:</label>
        <input type="text" id="Y" name="Y" value="${fes.getY()}"><br><br>
        
        <label for="SVCOPNBGNDT">���� ���� �����Ͻ�:</label>
        <input type="text" id="SVCOPNBGNDT" name="SVCOPNBGNDT" value="${fes.SVCOPNBGNDT}"><br><br>
        
        <label for="SVCOPNENDDT">���� ���� �����Ͻ�:</label>
        <input type="text" id="SVCOPNENDDT" name="SVCOPNENDDT" value="${fes.SVCOPNENDDT}"><br><br>
        
        <label for="RCPTBGNDT">���� �����Ͻ�:</label>
        <input type="text" id="RCPTBGNDT" name="RCPTBGNDT" value="${fes.RCPTBGNDT}"><br><br>
        
        <label for="AREANM">������:</label>
        <input type="text" id="AREANM" name="AREANM" value="${fes.AREANM}"><br><br>
        
        <label for="IMGURL">�̹��� ���:</label>
        <input type="text" id="IMGURL" name="IMGURL" value="${fes.IMGURL}"><br><br>
        
        <label for="DTLCONT">�� ����:</label>
        <textarea id="DTLCONT" name="DTLCONT">${fes.getDTLCONT()}</textarea><br><br>
        
        <label for="TELNO">��ȭ��ȣ:</label>
        <input type="text" id="TELNO" name="TELNO" value="${fes.getTELNO()}"><br><br>
        
        <label for="V_MAX">���� �̿� ���۽ð�:</label>
        <input type="text" id="V_MAX" name="V_MAX" value="${fes.getV_MAX()}"><br><br>
        
        <label for="V_MIN">���� �̿� ����ð�:</label>
        <input type="text" id="V_MIN" name="V_MIN" value="${fes.getV_MIN()}"><br><br>
        
        <label for="REVSTDDAY">��� �Ⱓ ������:</label>
        <input type="text" id="REVSTDDAY" name="REVSTDDAY" value="${fes.REVSTDDAY}"><br><br>
        
        <label for="REVSTDDAYNM">��� �Ⱓ ���� ����:</label>
        <input type="text" id="REVSTDDAYNM" name="REVSTDDAYNM" value="${fes.getREVSTDDAYNM()}"><br><br>
        
        <label for="Fes_state">��� ����:</label>
        <input type="number" id="Fes_state" name="Fes_state" value="${fes.getFes_state()}"><br><br>
        
        <label for="Update_date">���/���� �Ͻ�:</label>
        <input type="text" id="Update_date" name="Update_date" value="${fes.getUpdate_date()}"><br><br>
        
        <label for="MAXNUM">�ִ� �ο���:</label>
        <input type="number" id="MAXNUM" name="MAXNUM" value="${fes.MAXNUM}"><br><br>
        
        <label for="PRICE">����:</label>
        <input type="number" id="PRICE" name="PRICE" value="${fes.PRICE}"><br><br>
        
        <label for="host_seq">������ Sequence:</label>
        <input type="number" id="host_seq" name="host_seq" value="${fes.getHost_seq()}" readonly><br><br>
        
        <input type="submit" value="����">
    </form>
	
</body>
</html>