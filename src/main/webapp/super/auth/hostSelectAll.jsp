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
	   
	   //��ü�˻�
	   function selectAll(){
		   $.ajax({
			url :"ajax" , //������û�ּ�
			type:"post", //��û���(method��� : get | post | put | delete )
			dataType:"json"  , //������ ������ ������(����)Ÿ��(text | html | xml | json )
			data: {key:"customer" , methodName : "selectAll"}, //�������� ���� ����������(parameter����)
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
				    str+=`<td><input type='button' value='����' name='${item.id}'></td>`;
				    str+="</tr>";
			  });
				
				$("#listTable tr:gt(0)").remove();
				$("#listTable tr:eq(0)").after(str);//�������� �ڿ� �߰�
				
			} , //���������� ������ �Լ� 
			error : function(err){  
				alert(err+"���� �߻��߾��.");
			}  //���������� ������ �Լ� 
		});//ajax��
	   }//selectAll �Լ���
	   /////////////////////////////////////////////////////////////
	   
	   /*
	     ���̵��ߺ�üũ
	   */
	   $("#id").keyup(function(){
		   if($("#id").attr("readonly")){
			   return;
		   }
		   
		   if($(this).val() == ""){
			   $("span").text("�ߺ��������");
			   return;
		   }
		   
		   $.ajax({
	   			url :"ajax" , //������û�ּ�
	   			type:"post", //��û���(method��� : get | post | put | delete )
	   			dataType:"json"  , //������ ������ ������(����)Ÿ��(text | html | xml | json )
	   			data: {key:"customer" , methodName : "idCheck" , id : $(this).val() }, //�������� ���� ����������(parameter����)
	   			success :function(result){
	   				console.log(result);
	   				//$("span").text(result);
	   				
	   			   $("span").text(result.info);
	   				
	   			} , //���������� ������ �Լ� 
	   			error : function(err){  
	   				alert(err+"���� �߻��߾��.");
	   			}  //���������� ������ �Լ� 
	   		});//ajax��
	   });//keyup��
	   //////////////////////////////////////////////////////////////
	   /**
	      �����ϱ� �Ǵ� �����ϱ� 
	   */
	   $("#btn").click(function(){
		   let state=true; //���� �Ǵ� ������ �Ҷ� ��ȿ��üũ�� �ϰ� ajax�� �����ص� �Ǵ��� ���θ� �Ǵܴ� ����(true�� ajax�Ѵ�, false�̸� ajax���Ѵ�.) 
		   //��ȿ��üũ�ʿ�!(�� ��������)
		   $("input[type=text]").each(function(index, item){ //item�� input element�̴�.
			   if($(this).val()==""){
				   alert("���� �Է����ּ���.");
				   $(this).focus();//Ŀ������
				   
				   state=false;
				   return false;//return false�� �ǹ̴� each�Լ��� ����������.
			   }
		   });
		   
		   
		  if(state){ //���� �Ǵ� ��������!
			  
			 if($(this).val()=="�����ϱ�"){
				   $("[name=methodName]").val("update");
				   
				   //��ư �۾� �����ϱ� ����
				   $("#btn").val("�����ϱ�");
				   
				   //span ���̱�
				   $("span").show();
				   
				   //readonly �Ӽ� ���� 
				   $("#id").removeAttr("readonly");
			  }
			  
		   
		    $.ajax({
	   			url :"ajax" , //������û�ּ�
	   			type:"post", //��û���(method��� : get | post | put | delete )
	   			dataType:"text"  , //������ ������ ������(����)Ÿ��(text | html | xml | json )
	   			data: $("#inForm").serialize() , //.serialize()�� ������!
	   			success :function(result){
	   				if(result==0){
	   					alert("�����Ͽ����ϴ�.");
	   				}else{
	   					//text���������
	   					$("input[type=text]").val("");
	   					$("span").text("�ߺ��������");
	   					
	   					//ȭ�鰻��
	   					selectAll();
	   					
	   					$("[name=methodName]").val("insert");
	   				}
	   				
	   			} , //���������� ������ �Լ� 
	   			error : function(err){  
	   				alert(err+"���� �߻��߾��.");
	   			}  //���������� ������ �Լ� 
	   		});//ajax��
		  }
	   		
	   });//click�̺�Ʈ��
	   ////////////////////////////////////////////////////////////
	   
	   /*���̵� Ŭ�������� �̺�Ʈ ó�� */
	   $(document).on("click","#listTable > tbody > tr > td:nth-child(2) > a" , function(){
		   //text�ڽ��� ���ֱ� 
		   let name = $(this).parent().next();// �̸����ִ� <td>
		   let age = name.next(); //�������� element�� ã�´�.
		   let tel = age.next();
		   let addr = tel.next();
		   
		   $("#id").val( $(this).text() );
		   $("#name").val(name.text());
		   $("#age").val(age.text());
		   $("#tel").val(tel.text());
		   $("#addr").val(addr.text());
		   
		   //���̵�ڽ� ��Ȱ��ȭ(�ԷºҰ���) - atrr()�̿�
		   $("#id").attr("readonly", "readonly");
		   
		   //span�±� ����� 
		   $("span").hide();
		   
		   //btn�� �۾� �����ϱ�� ����
		   $("#btn").val("�����ϱ�");
	   });
	   ///////////////////////////////////////////////////////////////////////////
	   /*
	     �����ϱ�
	   */
	   $(document).on("click","[value=����]" , function(){
			  // alert( $(this).attr("name") )
			  $.ajax({
		   			url :"ajax" , //������û�ּ�
		   			type:"post", //��û���(method��� : get | post | put | delete )
		   			dataType:"text"  , //������ ������ ������(����)Ÿ��(text | html | xml | json )
		   			data: {key:"customer" , methodName : "delete" , id : $(this).attr("name") }, //�������� ���� ����������(parameter����)
		   			success :function(result){
		   				if(result==0){
		   					alert("�������� �ʾҽ��ϴ�.");
		   				}else{
		   					selectAll();//ȭ�鰻��
		   				}
		   				
		   			} , //���������� ������ �Լ� 
		   			error : function(err){  
		   				alert(err+"���� �߻��߾��.");
		   			}  //���������� ������ �Լ� 
		   		});//ajax��
		   });
	   
	   
	   //setInterval(selectAll, 1000)
	   
	   selectAll();
	   
});//ready��

</script>



</head>
<body>
<h2>ȸ������ �Է� </h2>

<form name="inForm" method="post" id="inForm">
	<table >
		<tr bgcolor="pink" >
		    <th >���̵�</th>
			<th >�̸�</th>
			<th  >����</th>
			<th  >��ȭ��ȣ</th>	
			<th  >�ּ�</th>
		</tr>
		<tr>
		    <td style="text-align:left"><input type="text" size="8" name="id" id="id"> <span>�ߺ��������</span></td>
			<td><input type="text" size="8" name="name" id="name"></td>
			<td><input type="text" size="4" name="age" id="age"></td>
			<td><input type="text" size="12" name="tel" id="tel"></td>
			<td><input type="text" size="30" name="addr" id="addr"></td>
		</tr>
		<tr>
			<td colspan="5" align="center"> 
			    <input type="hidden" name="key" value="customer">
			    <input type="hidden" name="methodName" value="insert">
				<input type="button" value="�����ϱ�"  id="btn">
			</td>
		</tr>
	</table>
</form>
<br>
<hr color="red">

<h2> �� ����Ʈ !  </h2>
<table id="listTable" >
	<tr bgcolor="pink">
	   <th>��ȣ</th>
	   <th>���̵�</th>
		<th>�̸�</th>
		<th>����</th>
		<th>��ȭ��ȣ</th>	
		<th>�ּ�</th>
		<th>����</th>
	</tr>
	<!-- ������ ��� -->
	
</table>



</body>
</html>