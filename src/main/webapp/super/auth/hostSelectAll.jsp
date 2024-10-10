<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 .a{border:solid red 5px}
 span{width:150px; color:red}
 input{border:solid gray 1px}
 table{width:100%;border-collapse: collapse;}
 th,td{border:1px gray solid; text-align:center;padding:3px}
 h2{text-align:center}
 
 a{text-decoration: none;}
 a:hover{color: red}
 
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


<script type="text/javascript" >
$(function(){
	   
	   //전체검색
	   function selectAll(){
		   $.ajax({
			url :"ajax" , //서버요청주소
			type:"post", //요청방식(method방식 : get | post | put | delete )
			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
			data: {key:"customer" , methodName : "selectAll"}, //서버에게 보낼 데이터정보(parameter정보)
			success :function(result){
				console.log(result);
				
				let str="";
				$.each(result, function(index, item){
				    str+="<tr>";
				    str+=`<td>${(index+1)}</td>`;
				    str+=`<td><a href='#'>${item.id}</a></td>`;
				    str+=`<td>${item.name}</td>`;
				    str+=`<td>${item.age}</td>`;
				    str+=`<td>${item.tel}</td>`;
				    str+=`<td>${item.addr}</td>`;
				    str+=`<td><input type='button' value='삭제' name='${item.id}'></td>`;
				    str+="</tr>";
			  });
				
				$("#listTable tr:gt(0)").remove();
				$("#listTable tr:eq(0)").after(str);//형제노드로 뒤에 추가
				
			} , //성공했을때 실행할 함수 
			error : function(err){  
				alert(err+"에러 발생했어요.");
			}  //실팽했을때 실행할 함수 
		});//ajax끝
	   }//selectAll 함수끝
	   /////////////////////////////////////////////////////////////
	   
	   /*
	     아이디중복체크
	   */
	   $("#id").keyup(function(){
		   if($("#id").attr("readonly")){
			   return;
		   }
		   
		   if($(this).val() == ""){
			   $("span").text("중복결과여부");
			   return;
		   }
		   
		   $.ajax({
	   			url :"ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: {key:"customer" , methodName : "idCheck" , id : $(this).val() }, //서버에게 보낼 데이터정보(parameter정보)
	   			success :function(result){
	   				console.log(result);
	   				//$("span").text(result);
	   				
	   			   $("span").text(result.info);
	   				
	   			} , //성공했을때 실행할 함수 
	   			error : function(err){  
	   				alert(err+"에러 발생했어요.");
	   			}  //실팽했을때 실행할 함수 
	   		});//ajax끝
	   });//keyup끝
	   //////////////////////////////////////////////////////////////
	   /**
	      가입하기 또는 수정하기 
	   */
	   $("#btn").click(function(){
		   let state=true; //가입 또는 수정을 할때 유효성체크를 하고 ajax를 실행해도 되는지 여부를 판단는 변수(true면 ajax한다, false이면 ajax안한다.) 
		   //유효성체크필요!(값 존재유무)
		   $("input[type=text]").each(function(index, item){ //item은 input element이다.
			   if($(this).val()==""){
				   alert("값을 입력해주세요.");
				   $(this).focus();//커서놓기
				   
				   state=false;
				   return false;//return false의 의미는 each함수를 빠져나가라.
			   }
		   });
		   
		   
		  if(state){ //가입 또는 수정하자!
			  
			 if($(this).val()=="수정하기"){
				   $("[name=methodName]").val("update");
				   
				   //버튼 글씨 가입하기 변경
				   $("#btn").val("가입하기");
				   
				   //span 보이기
				   $("span").show();
				   
				   //readonly 속성 제거 
				   $("#id").removeAttr("readonly");
			  }
			  
		   
		    $.ajax({
	   			url :"ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"text"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: $("#inForm").serialize() , //.serialize()는 폼전송!
	   			success :function(result){
	   				if(result==0){
	   					alert("실패하였습니다.");
	   				}else{
	   					//text내용지우고
	   					$("input[type=text]").val("");
	   					$("span").text("중복결과여부");
	   					
	   					//화면갱신
	   					selectAll();
	   					
	   					$("[name=methodName]").val("insert");
	   				}
	   				
	   			} , //성공했을때 실행할 함수 
	   			error : function(err){  
	   				alert(err+"에러 발생했어요.");
	   			}  //실팽했을때 실행할 함수 
	   		});//ajax끝
		  }
	   		
	   });//click이벤트끝
	   ////////////////////////////////////////////////////////////
	   
	   /*아이디를 클릭했을때 이벤트 처리 */
	   $(document).on("click","#listTable > tbody > tr > td:nth-child(2) > a" , function(){
		   //text박스에 값넣기 
		   let name = $(this).parent().next();// 이름이있는 <td>
		   let age = name.next(); //형제다음 element를 찾는다.
		   let tel = age.next();
		   let addr = tel.next();
		   
		   $("#id").val( $(this).text() );
		   $("#name").val(name.text());
		   $("#age").val(age.text());
		   $("#tel").val(tel.text());
		   $("#addr").val(addr.text());
		   
		   //아이디박스 비활성화(입력불가능) - atrr()이용
		   $("#id").attr("readonly", "readonly");
		   
		   //span태그 숨기기 
		   $("span").hide();
		   
		   //btn의 글씨 수정하기로 변경
		   $("#btn").val("수정하기");
	   });
	   ///////////////////////////////////////////////////////////////////////////
	   /*
	     삭제하기
	   */
	   $(document).on("click","[value=삭제]" , function(){
			  // alert( $(this).attr("name") )
			  $.ajax({
		   			url :"ajax" , //서버요청주소
		   			type:"post", //요청방식(method방식 : get | post | put | delete )
		   			dataType:"text"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
		   			data: {key:"customer" , methodName : "delete" , id : $(this).attr("name") }, //서버에게 보낼 데이터정보(parameter정보)
		   			success :function(result){
		   				if(result==0){
		   					alert("삭제되지 않았습니다.");
		   				}else{
		   					selectAll();//화면갱신
		   				}
		   				
		   			} , //성공했을때 실행할 함수 
		   			error : function(err){  
		   				alert(err+"에러 발생했어요.");
		   			}  //실팽했을때 실행할 함수 
		   		});//ajax끝
		   });
	   
	   
	   //setInterval(selectAll, 1000)
	   
	   selectAll();
	   
});//ready끝

</script>



</head>
<body>
<h2>회원정보 입력 </h2>

<form name="inForm" method="post" id="inForm">
	<table >
		<tr bgcolor="pink" >
		    <th >아이디</th>
			<th >이름</th>
			<th  >나이</th>
			<th  >전화번호</th>	
			<th  >주소</th>
		</tr>
		<tr>
		    <td style="text-align:left"><input type="text" size="8" name="id" id="id"> <span>중복결과여부</span></td>
			<td><input type="text" size="8" name="name" id="name"></td>
			<td><input type="text" size="4" name="age" id="age"></td>
			<td><input type="text" size="12" name="tel" id="tel"></td>
			<td><input type="text" size="30" name="addr" id="addr"></td>
		</tr>
		<tr>
			<td colspan="5" align="center"> 
			    <input type="hidden" name="key" value="customer">
			    <input type="hidden" name="methodName" value="insert">
				<input type="button" value="가입하기"  id="btn">
			</td>
		</tr>
	</table>
</form>
<br>
<hr color="red">

<h2> 고객 리스트 !  </h2>
<table id="listTable" >
	<tr bgcolor="pink">
	   <th>번호</th>
	   <th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>전화번호</th>	
		<th>주소</th>
		<th>삭제</th>
	</tr>
	<!-- 데이터 출력 -->
	
</table>



</body>
</html>