<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<SCRIPT language=javascript>
function sendUpdate(){
	document.requestForm.methodName.value ="updateForm";
	document.requestForm.submit();
}
function sendDelete(){
	document.requestForm.methodName.value ="delete";
	document.requestForm.submit();
}
</script>
</head>
<body>
<form name="requestForm" method=post action="${path}/front">
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
	<thead>
		<tr>
 			<th style="background-color: #eeeeee; text-align: center;" colspan="2">서비스 등록 신청내역</th>
       	</tr>
	</thead>
	<tbody>
		<tr>
			<td><p align="center"><span>서비스아이디</span></p></td>
			<td><p align="center"><span><b>${fesDTO.SVCID}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>대분류명</span></p></td>
			<td><p align="center"><span><b>${fesDTO.MAXCLASSNM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>소분류명</span></p></td>
			<td><p align="center"><span><b>${fesDTO.MINCLASSNM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>서비스상태</span></p></td>
			<td><p align="center"><span><b>${fesDTO.SVCSTATNM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>서비스명</span></p></td>
			<td><p align="center"><span><b>${fesDTO.SVCNM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>결제방법</span></p></td>
			<td><p align="center"><span><b>${fesDTO.PAYATNM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>서비스대상</span></p></td>
			<td><p align="center"><span><b>${fesDTO.USETGTINFO}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>서비스개시시작일시</span></p></td>
			<td><p align="center"><span><b>${fesDTO.SVCOPNBGNDT}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>서비스개시종료일시</span></p></td>
			<td><p align="center"><span><b>${fesDTO.SVCOPNENDDT}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>접수시작일시</span></p></td>
			<td><p align="center"><span><b>${fesDTO.RCPTBGNDT}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>접수종료일시</span></p></td>
			<td><p align="center"><span><b>${fesDTO.RCPTENDDT}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>지역명</span></p></td>
			<td><p align="center"><span><b>${fesDTO.AREANM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>장소명</span></p></td>
			<td><p align="center"><span><b>${fesDTO.PLACENM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>장소 위도</span></p></td>
			<td><p align="center"><span><b>${fesDTO.getX()}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>장소 경도</span></p></td>
			<td><p align="center"><span><b>${fesDTO.getY()}</b></span></p></td>
		</tr>
		<!-- 여기까지 15개 -->
		<tr>
			<td><p align="center"><span>서비스 이미지/포스터</span></p></td>
			<td><p align="center"><span><b>${fesDTO.IMGURL}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>상세내용</span></p></td>
			<td><p align="center"><span><b>${fesDTO.DTLCONT}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>전화번호</span></p></td>
			<td><p align="center"><span><b>${fesDTO.TELNO}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>서비스이용 시작시간</span></p></td>
			<td><p align="center"><span><b>${fesDTO.getV_MIN()}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>서비스이용 종료시간</span></p></td>
			<td><p align="center"><span><b>${fesDTO.getV_MAX()}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>취소기간 기준정보</span></p></td>
			<td><p align="center"><span><b>${fesDTO.REVSTDDAYNM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>취소기간 기준일까지</span></p></td>
			<td><p align="center"><span><b>${fesDTO.REVSTDDAY}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>등록신청 정보</span></p></td>
			<td><p align="center"><span><b>${fesDTO.getFes_state()}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>등록신청/수정신청 일시</span></p></td>
			<td><p align="center"><span><b>${fesDTO.getUpdate_date()}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>최대 인원수</span></p></td>
			<td><p align="center"><span><b>${fesDTO.MAXNUM}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>가격</span></p></td>
			<td><p align="center"><span><b>${fesDTO.PRICE}</b></span></p></td>
		</tr>
		<tr>
			<td><p align="center"><span>주최자 sequence</span></p></td>
			<td><p align="center"><span><b>${fesDTO.host_seq}</b></span></p></td>
		</tr>
		<tr>
			
        	<td width="450" height="20" colspan="2" align="center">
        		<input type=hidden name="SVCID" value="${fesDTO.SVCID}">
				<input type=hidden name="key" value="fes">
				<input type=hidden name="methodName">
        		
        		<input type=button value="수정하기" onClick="sendUpdate()">
				<input type=button value="삭제하기" onClick="sendDelete()">
        	</td>
        	
    	</tr>
	</tbody>
</table>
</form>
</body>
</html>