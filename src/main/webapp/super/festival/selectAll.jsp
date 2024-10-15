<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <jsp:include page="/common/header.jsp"/> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<%-- <link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script> --%>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	
<!-- datatables -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/v/bs5/dt-2.1.8/datatables.min.css" rel="stylesheet">
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.datatables.net/v/bs5/dt-2.1.8/datatables.min.js"></script>

<script>
	$(function() {
		$('#example').DataTable();
		
/* 		$(".detailBtn").click(function() {
							console.log("상세보기 버튼 클릭");
							const svcid = $(this).data("svcid");
							//console.log(svcid);
							window.location.href = "${path}/front?key=superfestival&methodName=detail&svcid="+ svcid;
		}); */
		
		function bindDetailButtonEvent() {
	        $(".detailBtn").off('click').on('click', function() {
	            console.log("상세보기 버튼 클릭");
	            const svcid = $(this).data("svcid");
	            window.location.href = "${path}/front?key=superfestival&methodName=detail&svcid=" + svcid;
	        });
	    } 
		
		// 초기 바인딩
	    bindDetailButtonEvent();
		
	    const table = new simpleDatatables.DataTable("#datatablesSimple");
	    
		 table.on('datatable.draw', function() {
			 console.log("!!!!!!!!!");
 	        bindDetailButtonEvent();
		 });
		 
		
		//검색 인풋
		searchInput = $('input[type="search"]');
		
		searchInput.val("asdasd");
		
		/* searchInput.on('input', function() {
		    var currentValue = $(this).val();
		    console.log('현재 입력된 값:', currentValue);
		    
		}); */
		
	});
	
	/*  $(document).ready(function() {
         const s = "${search}";
         console.log("@@@@@@@" + s);
         let searchInput;

         if (s === "searchWaiting") {
             searchInput = $('input[type="search"]');
             searchInput.focus();
             searchInput.val('대기'); // 값 설정

             // 강제로 엔터 키 이벤트를 발생시키는 함수
             function triggerEnter() {
                 var enterEvent = new KeyboardEvent('keydown', { // Vanilla JS를 사용하여 KeyboardEvent 생성
                     key: 'Enter',
                     code: 'Enter',
                     keyCode: 13,
                     which: 13,
                     bubbles: true // 이벤트가 버블링 되도록 설정
                 });
                 searchInput[0].dispatchEvent(enterEvent); // jQuery 객체에서 DOM 요소로 접근하여 이벤트 디스패치
             }

             // 엔터 키가 눌렸을 때 검색을 수행하는 함수
             searchInput.on('keydown', function(event) {
                 if (event.key === 'Enter') {
                	 
                     var inputValue = searchInput.val(); // 현재 입력값 가져오기
                    // $('#display').text('입력된 값: ' + inputValue); // 입력값 표시
                     console.log('입력된 값:', inputValue); // 콘솔에 출력
                 }
             });

             // 엔터 키 입력 함수 호출
             triggerEnter(); // 강제 엔터 키 입력
         }
     }); */
     
      /* $(document).ready(function() {
    	    const table = new simpleDatatables.DataTable("#datatablesSimple");

    	    // 페이지 로드 시 기본적으로 상세보기 버튼에 이벤트 추가
    	     function bindDetailButtonEvent() {
    	        $(".detailBtn").off('click').on('click', function() {
    	            console.log("상세보기 버튼 클릭");
    	            const svcid = $(this).data("svcid");
    	            window.location.href = "${path}/front?key=superfestival&methodName=detail&svcid=" + svcid;
    	        });
    	    } 

    	    // 초기 바인딩
    	    bindDetailButtonEvent();

    	    // DataTables에서 테이블이 다시 그려질 때마다 버튼 클릭 이벤트 재바인딩
    	    table.on('datatable.draw', function() {
    	        bindDetailButtonEvent();
    	    });
    	});  */
    	
	
</script>

 <!--        <style>
        /* 스크롤을 제거하는 스타일 */
        html, body {
            overflow: hidden; 
            height: 100%;
            margin: 0;
            padding: 0;
        }
 	  	</style> -->
</head>
<table id="example" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011-04-25</td>
                <td>$320,800</td>
            </tr>
            <tr>
                <td>Garrett Winters</td>
                <td><button class="detailBtn" data-svcid="${festival.SVCID}" />${festival.SVCID}청계천1</td>
                <td>Tokyo</td>
                <td>63</td>
                <td>2011-07-25</td>
                <td>$170,750</td>
            </tr>
            <tr>
                <td>Ashton Cox</td>
                <td><button class="detailBtn" data-svcid="${festival.SVCID}" />${festival.SVCID}청계천2</td>
                <td>San Francisco</td>
                <td>66</td>
                <td>2009-01-12</td>
                <td>$86,000</td>
            </tr>
            <tr>
                <td>Cedric Kelly</td>
                <td>Senior Javascript Developer</td>
                <td>Edinburgh</td>
                <td>22</td>
                <td>2012-03-29</td>
                <td>$433,060</td>
            </tr>
            <tr>
                <td>Airi Satou</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>33</td>
                <td>2008-11-28</td>
                <td>$162,700</td>
            </tr>
            <tr>
                <td>Brielle Williamson</td>
                <td>Integration Specialist</td>
                <td>New York</td>
                <td>61</td>
                <td>2012-12-02</td>
                <td>$372,000</td>
            </tr>
            <tr>
                <td>Herrod Chandler</td>
                <td>Sales Assistant</td>
                <td>San Francisco</td>
                <td>59</td>
                <td>2012-08-06</td>
                <td>$137,500</td>
            </tr>
            <tr>
                <td>Rhona Davidson</td>
                <td>Integration Specialist</td>
                <td>Tokyo</td>
                <td>55</td>
                <td>2010-10-14</td>
                <td>$327,900</td>
            </tr>
            <tr>
                <td>Colleen Hurst</td>
                <td>Javascript Developer</td>
                <td>San Francisco</td>
                <td>39</td>
                <td>2009-09-15</td>
                <td>$205,500</td>
            </tr>
            <tr>
                <td>Sonya Frost</td>
                <td>Software Engineer</td>
                <td>Edinburgh</td>
                <td>23</td>
                <td>2008-12-13</td>
                <td>$103,600</td>
            </tr>
            <tr>
                <td>Jena Gaines</td>
                <td>Office Manager</td>
                <td>London</td>
                <td>30</td>
                <td>2008-12-19</td>
                <td>$90,560</td>
            </tr>
            <tr>
                <td>Quinn Flynn</td>
                <td>Support Lead</td>
                <td>Edinburgh</td>
                <td>22</td>
                <td>2013-03-03</td>
                <td>$342,000</td>
            </tr>
            <tr>
                <td>Charde Marshall</td>
                <td>Regional Director</td>
                <td>San Francisco</td>
                <td>36</td>
                <td>2008-10-16</td>
                <td>$470,600</td>
            </tr>
            <tr>
                <td>Haley Kennedy</td>
                <td>Senior Marketing Designer</td>
                <td>London</td>
                <td>43</td>
                <td>2012-12-18</td>
                <td>$313,500</td>
            </tr>
            <tr>
                <td>Tatyana Fitzpatrick</td>
                <td>Regional Director</td>
                <td>London</td>
                <td>19</td>
                <td>2010-03-17</td>
                <td>$385,750</td>
            </tr>
            <tr>
                <td>Michael Silva</td>
                <td>Marketing Designer</td>
                <td>London</td>
                <td>66</td>
                <td>2012-11-27</td>
                <td>$198,500</td>
            </tr>
            <tr>
                <td>Paul Byrd</td>
                <td>Chief Financial Officer (CFO)</td>
                <td>New York</td>
                <td>64</td>
                <td>2010-06-09</td>
                <td>$725,000</td>
            </tr>
            <tr>
                <td>Gloria Little</td>
                <td>Systems Administrator</td>
                <td>New York</td>
                <td>59</td>
                <td>2009-04-10</td>
                <td>$237,500</td>
            </tr>
            <tr>
                <td>Bradley Greer</td>
                <td>Software Engineer</td>
                <td>London</td>
                <td>41</td>
                <td>2012-10-13</td>
                <td>$132,000</td>
            </tr>
            <tr>
                <td>Dai Rios</td>
                <td>Personnel Lead</td>
                <td>Edinburgh</td>
                <td>35</td>
                <td>2012-09-26</td>
                <td>$217,500</td>
            </tr>
            <tr>
                <td>Jenette Caldwell</td>
                <td>Development Lead</td>
                <td>New York</td>
                <td>30</td>
                <td>2011-09-03</td>
                <td>$345,000</td>
            </tr>
            <tr>
                <td>Yuri Berry</td>
                <td>Chief Marketing Officer (CMO)</td>
                <td>New York</td>
                <td>40</td>
                <td>2009-06-25</td>
                <td>$675,000</td>
            </tr>
            <tr>
                <td>Caesar Vance</td>
                <td>Pre-Sales Support</td>
                <td>New York</td>
                <td>21</td>
                <td>2011-12-12</td>
                <td>$106,450</td>
            </tr>
            <tr>
                <td>Doris Wilder</td>
                <td>Sales Assistant</td>
                <td>Sydney</td>
                <td>23</td>
                <td>2010-09-20</td>
                <td>$85,600</td>
            </tr>
            <tr>
                <td>Angelica Ramos</td>
                <td>Chief Executive Officer (CEO)</td>
                <td>London</td>
                <td>47</td>
                <td>2009-10-09</td>
                <td>$1,200,000</td>
            </tr>
            <tr>
                <td>Gavin Joyce</td>
                <td>Developer</td>
                <td>Edinburgh</td>
                <td>42</td>
                <td>2010-12-22</td>
                <td>$92,575</td>
            </tr>
            <tr>
                <td>Jennifer Chang</td>
                <td>Regional Director</td>
                <td>Singapore</td>
                <td>28</td>
                <td>2010-11-14</td>
                <td>$357,650</td>
            </tr>
            <tr>
                <td>Brenden Wagner</td>
                <td>Software Engineer</td>
                <td>San Francisco</td>
                <td>28</td>
                <td>2011-06-07</td>
                <td>$206,850</td>
            </tr>
            <tr>
                <td>Fiona Green</td>
                <td>Chief Operating Officer (COO)</td>
                <td>San Francisco</td>
                <td>48</td>
                <td>2010-03-11</td>
                <td>$850,000</td>
            </tr>
            <tr>
                <td>Shou Itou</td>
                <td>Regional Marketing</td>
                <td>Tokyo</td>
                <td>20</td>
                <td>2011-08-14</td>
                <td>$163,000</td>
            </tr>
            <tr>
                <td>Michelle House</td>
                <td>Integration Specialist</td>
                <td>Sydney</td>
                <td>37</td>
                <td>2011-06-02</td>
                <td>$95,400</td>
            </tr>
            <tr>
                <td>Suki Burks</td>
                <td>Developer</td>
                <td>London</td>
                <td>53</td>
                <td>2009-10-22</td>
                <td>$114,500</td>
            </tr>
            <tr>
                <td>Prescott Bartlett</td>
                <td>Technical Author</td>
                <td>London</td>
                <td>27</td>
                <td>2011-05-07</td>
                <td>$145,000</td>
            </tr>
            <tr>
                <td>Gavin Cortez</td>
                <td>Team Leader</td>
                <td>San Francisco</td>
                <td>22</td>
                <td>2008-10-26</td>
                <td>$235,500</td>
            </tr>
            <tr>
                <td>Martena Mccray</td>
                <td>Post-Sales support</td>
                <td>Edinburgh</td>
                <td>46</td>
                <td>2011-03-09</td>
                <td>$324,050</td>
            </tr>
            <tr>
                <td>Unity Butler</td>
                <td>Marketing Designer</td>
                <td>San Francisco</td>
                <td>47</td>
                <td>2009-12-09</td>
                <td>$85,675</td>
            </tr>
            <tr>
                <td>Howard Hatfield</td>
                <td>Office Manager</td>
                <td>San Francisco</td>
                <td>51</td>
                <td>2008-12-16</td>
                <td>$164,500</td>
            </tr>
            <tr>
                <td>Hope Fuentes</td>
                <td>Secretary</td>
                <td>San Francisco</td>
                <td>41</td>
                <td>2010-02-12</td>
                <td>$109,850</td>
            </tr>
            <tr>
                <td>Vivian Harrell</td>
                <td>Financial Controller</td>
                <td>San Francisco</td>
                <td>62</td>
                <td>2009-02-14</td>
                <td>$452,500</td>
            </tr>
            <tr>
                <td>Timothy Mooney</td>
                <td>Office Manager</td>
                <td>London</td>
                <td>37</td>
                <td>2008-12-11</td>
                <td>$136,200</td>
            </tr>
            <tr>
                <td>Jackson Bradshaw</td>
                <td>Director</td>
                <td>New York</td>
                <td>65</td>
                <td>2008-09-26</td>
                <td>$645,750</td>
            </tr>
            <tr>
                <td>Olivia Liang</td>
                <td>Support Engineer</td>
                <td>Singapore</td>
                <td>64</td>
                <td>2011-02-03</td>
                <td>$234,500</td>
            </tr>
            <tr>
                <td>Bruno Nash</td>
                <td>Software Engineer</td>
                <td>London</td>
                <td>38</td>
                <td>2011-05-03</td>
                <td>$163,500</td>
            </tr>
            <tr>
                <td>Sakura Yamamoto</td>
                <td>Support Engineer</td>
                <td>Tokyo</td>
                <td>37</td>
                <td>2009-08-19</td>
                <td>$139,575</td>
            </tr>
            <tr>
                <td>Thor Walton</td>
                <td>Developer</td>
                <td>New York</td>
                <td>61</td>
                <td>2013-08-11</td>
                <td>$98,540</td>
            </tr>
            <tr>
                <td>Finn Camacho</td>
                <td>Support Engineer</td>
                <td>San Francisco</td>
                <td>47</td>
                <td>2009-07-07</td>
                <td>$87,500</td>
            </tr>
            <tr>
                <td>Serge Baldwin</td>
                <td>Data Coordinator</td>
                <td>Singapore</td>
                <td>64</td>
                <td>2012-04-09</td>
                <td>$138,575</td>
            </tr>
            <tr>
                <td>Zenaida Frank</td>
                <td>Software Engineer</td>
                <td>New York</td>
                <td>63</td>
                <td>2010-01-04</td>
                <td>$125,250</td>
            </tr>
            <tr>
                <td>Zorita Serrano</td>
                <td>Software Engineer</td>
                <td>San Francisco</td>
                <td>56</td>
                <td>2012-06-01</td>
                <td>$115,000</td>
            </tr>
            <tr>
                <td>Jennifer Acosta</td>
                <td>Junior Javascript Developer</td>
                <td>Edinburgh</td>
                <td>43</td>
                <td>2013-02-01</td>
                <td>$75,650</td>
            </tr>
            <tr>
                <td>Cara Stevens</td>
                <td>Sales Assistant</td>
                <td>New York</td>
                <td>46</td>
                <td>2011-12-06</td>
                <td>$145,600</td>
            </tr>
            <tr>
                <td>Hermione Butler</td>
                <td>Regional Director</td>
                <td>London</td>
                <td>47</td>
                <td>2011-03-21</td>
                <td>$356,250</td>
            </tr>
            <tr>
                <td>Lael Greer</td>
                <td>Systems Administrator</td>
                <td>London</td>
                <td>21</td>
                <td>2009-02-27</td>
                <td>$103,500</td>
            </tr>
            <tr>
                <td>Jonas Alexander</td>
                <td>Developer</td>
                <td>San Francisco</td>
                <td>30</td>
                <td>2010-07-14</td>
                <td>$86,500</td>
            </tr>
            <tr>
                <td>Shad Decker</td>
                <td>Regional Director</td>
                <td>Edinburgh</td>
                <td>51</td>
                <td>2008-11-13</td>
                <td>$183,000</td>
            </tr>
            <tr>
                <td>Michael Bruce</td>
                <td>Javascript Developer</td>
                <td>Singapore</td>
                <td>29</td>
                <td>2011-06-27</td>
                <td>$183,000</td>
            </tr>
            <tr>
                <td>Donna Snider</td>
                <td>Customer Support</td>
                <td>New York</td>
                <td>27</td>
                <td>2011-01-25</td>
                <td>$112,000</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </tfoot>
    </table>

<main>
	<!-- 페이지 제목 -->
	<div class="container-fluid px-4">
		<h1 class="mt-4">전체 문화행사 조회</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item active">전체 문화행사의 목록을 출력합니다</li>
		</ol>
		
		<!-- 테이블 -->
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> 문화 행사 테이블
			</div>
			<div class="card-body">
				<table id="datatablesSimple">
					<thead>
						<tr>
							<th>서비스 아이디</th>
							<th>대분류명</th>
							<th>소분류명</th>
							<th>서비스상태</th>
							<th>서비스명</th>
							<!-- <th>결제방법</th> -->
							<th>장소명</th>
							<!-- <th>서비스대상</th> -->
							<!-- <th>장소 x좌표</th> -->
							<!-- <th>장소 y좌표</th> -->
							<!-- <th>서비스 개시 시작일시</th>
								<th>서비스 개시 종료일시</th>
								<th>접수 시작일시</th> -->
							<th>지역명</th>
							<!-- <th>이미지 경로</th>
								<th>상세 내용</th> -->
							<th>전화번호</th>
							<!-- <th>서비스 이용 시작시간</th>
								<th>서비스 이용 종료시간</th>
								<th>취소 기간 기준일까지</th>
								<th>취소 기간 기준정보</th> -->
							<th>등록신청 정보</th>
							<th>등록/수정 신청일</th>
							<!-- 	<th>최대 인원수</th> -->
							<!-- 	<th>가격</th>
								<th>주최자 sequence</th> -->
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>서비스 아이디</th>
							<th>대분류명</th>
							<th>소분류명</th>
							<th>서비스상태</th>
							<th>서비스명</th>
							<th>결제방법</th>
							<th>장소명</th>
							<th>서비스대상</th>
							<!-- <th>장소 x좌표</th> -->
							<!-- <th>장소 y좌표</th> -->
							<!-- <th>서비스 개시 시작일시</th>
								<th>서비스 개시 종료일시</th>
								<th>접수 시작일시</th> -->
							<th>지역명</th>
							<!-- <th>이미지 경로</th>
								<th>상세 내용</th> -->
							<th>전화번호</th>
							<!-- <th>서비스 이용 시작시간</th>
								<th>서비스 이용 종료시간</th>
								<th>취소 기간 기준일까지</th>
								<th>취소 기간 기준정보</th> -->
							<th>등록신청 정보</th>
							<th>등록/수정 신청일</th>
							<!-- 	<th>최대 인원수</th> -->
							<!-- 	<th>가격</th>
								<th>주최자 sequence</th> -->
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${festivalList}" var="festival">
							<tr>
								<td><button class="detailBtn" data-svcid="${festival.SVCID}" />${festival.SVCID}</td>
								<!-- 버튼 클릭 이벤트 -> 서블릿 -> 상세페이지 -->
								<td>${festival.MAXCLASSNM}</td>
								<td>${festival.MINCLASSNM}</td>
								<td>${festival.SVCSTATNM}</td>
								<td>${festival.SVCNM}</td>
								<%-- <td>${festival.PAYATNM}</td> --%>
								<td>${festival.PLACENM}</td>
								<%-- <td>${festival.USETGTINFO}</td> --%>
								<%-- <td>${festival.getX()}</td>
									<td>${festival.getY()}</td> --%>
								<%-- <td>${festival.SVCOPNBGNDT}</td>
									<td>${festival.SVCOPNENDDT}</td>
									<td>${festival.RCPTBGNDT}</td> --%>
								<td>${festival.AREANM}</td>
								<%-- <td>${festival.IMGURL}</td>
									<td>${festival.getDTLCONT()}</td> --%>
								<td>${festival.TELNO}</td>
								<%-- <td>${festival.getV_MAX()}</td>
									<td>${festival.getV_MIN()}</td>
									<td>${festival.REVSTDDAY}</td>
									<td>${festival.REVSTDDAYNM}</td> --%>
								<!-- 0=승인대기 / 1=승인완료 / 2=승인대기 /3=비활성화-->
								<td>
								<c:choose>
										<c:when test="${festival.getFes_state() == 0}">승인 대기</c:when>
										<c:when test="${festival.getFes_state() == 1}">승인 완료</c:when>
										<c:when test="${festival.getFes_state() == 2}">수정 대기</c:when>
										<c:when test="${festival.getFes_state() == 3}">비활성화</c:when>
										<c:otherwise>잘못된 상태</c:otherwise>
								</c:choose>
								</td>
								<td>${festival.getUpdate_date()}</td>
								<%-- <td>${festival.MAXNUM}</td> --%>
								<%-- 	<td>${festival.PRICE}</td>
									<td>${festival.getHost_seq()}</td> --%>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
		<!-- 테이블 끝 -->
</main>
<%-- <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
	
<script
	src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
	crossorigin="anonymous"></script>
<!-- 부트스트랩 테이블 라이브러리 -->
<script src="${path}/js/datatables-simple-demo.js"></script> --%>

</body>
</html>