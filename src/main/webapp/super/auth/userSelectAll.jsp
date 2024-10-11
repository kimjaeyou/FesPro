<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f7ff;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        h1 {
            color: #0066cc;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #007acc;
            text-align: left;
        }
        th {
            background-color: #007acc;
            color: white;
        }
        td {
            background-color: #e6f7ff;
        }
        .btn {
            background-color: #007acc;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #005f99;
        }
        input[type="text"] {
            width: 90%;
            padding: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>���� ���� ��ȸ �� ����</h1>

        <!-- ID�� ���� �˻� -->
        <div>
            <label for="userId">User ID:</label>
            <input type="text" id="userId" placeholder="���� ID �Է�">
            <button class="btn" onclick="getUserInfo()">��ȸ</button>
        </div>

        <h2>���� �� ���� (���� ����)</h2>
        <table id="userDetail">
            <tr>
                <th>���� ��ȣ</th>
                <th>ID</th>
                <th>��й�ȣ</th>
                <th>�̸�</th>
                <th>����</th>
                <th>�ּ�</th>
                <th>����</th>
                <th>�̸���</th>
                <th>��ȭ��ȣ</th>
                <th>����</th>
            </tr>
            <tr>
                <td><input type="text" id="userSeqField" value=""></td>
                <td><input type="text" id="userIdField" value=""></td>
                <td><input type="text" id="userPwField" value=""></td>
                <td><input type="text" id="userNameField" value=""></td>
                <td><input type="text" id="userAgeField" value=""></td>
                <td><input type="text" id="userAddrField" value=""></td>
                <td><input type="text" id="userGenderField" value=""></td>
                <td><input type="text" id="userEmailField" value=""></td>
                <td><input type="text" id="userTelField" value=""></td>
                <td><input type="text" id="userDisableField" value=""></td>
            </tr>
        </table>

        <button class="btn" onclick="updateUserInfo()">���� ���� ����</button>

        <h2>��� ���� ����</h2>
        <table id="allUsers">
            <thead>
                <tr>
                    <th>���� ����</th>
                    <th>ID</th>
                    <th>��й�ȣ</th>
                    <th>�̸�</th>
                    <th>����</th>
                    <th>�ּ�</th>
                    <th>����</th>
                    <th>�̸���</th>
                    <th>��ȭ��ȣ</th>
                    <th>����</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="">
                    <tr>
                        <td><a href="#" onclick="getUserInfo('')"></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        // Ư�� ������ ������ �������� �Լ�
        $(function(){
        
         function getUserInfo(userId) {
            if (!userId) {
                userId = $("#userId").val();
                if (!userId) {
                    alert("���� ID�� �Է��ϼ���.");
                    return;
                }
            }

            $.ajax({
                url: 'getUserInfo',
                type: 'GET',
                data: { userId: userId },
                success: function(data) {
                    var user = JSON.parse(data);
                    // �󼼺��� ���̺� ���� ���� ǥ�� �� ���� �����ϰ� �ϱ�
                    $("#userSeqField").val(user.user_seq);
                    $("#userIdField").val(user.user_id);
                    $("#userPwField").val(user.user_pw);
                    $("#userNameField").val(user.user_name);
                    $("#userAgeField").val(user.age);
                    $("#userAddrField").val(user.addr);
                    $("#userGenderField").val(user.gender);
                    $("#userEmailField").val(user.email);
                    $("#userTelField").val(user.user_tel);
                    $("#userDisableField").val(user.disable);
                }
            });
        }
 
        // ��� ���� ������ �������� �Լ�
         	function selectAll(){
        	alert("�Ӿ�dddd");
            $.ajax({
                url: '${path}/ajax',
                type: 'get',
                dataType:"json",
                data:{key:"superAuth" , methodName:"selectAll"},
                success: function(result) {
                	//alert(result)
                    var allUsersTable = $("#allUsers tbody");
                    allUsersTable.empty();
                    
                    result.forEach(function(user) {
                        allUsersTable.append(
                            "<tr>" +
                            "<td><a href='#' onclick='getUserInfo(\"" + user.user_id + "\")'>" + user.user_seq + "</a></td>" +
                            "<td>" + user.user_id + "</td>" +
                            "<td>" + user.user_pw + "</td>" +
                            "<td>" + user.user_name + "</td>" +
                            "<td>" + user.age + "</td>" +
                            "<td>" + user.addr + "</td>" +
                            "<td>" + user.gender + "</td>" +
                            "<td>" + user.email + "</td>" +
                            "<td>" + user.user_tel + "</td>" +
                            "<td>" + user.disable + "</td>" +
                            "</tr>"
                        );
                    });
                },
                error: function(err){
                	alert(err+"=> ����..")
                	console.log(err);
                }
            });
        };

        // ���� ���� �����ϴ� �Լ�
         function updateUserInfo() {
            var updatedUser = {
                user_seq: $("#userSeqField").val(),
                user_id: $("#userIdField").val(),
                user_pw: $("#userPwField").val(),
                user_name: $("#userNameField").val(),
                age: $("#userAgeField").val(),
                addr: $("#userAddrField").val(),
                gender: $("#userGenderField").val(),
                email: $("#userEmailField").val(),
                user_tel: $("#userTelField").val(),
                disable: $("#userDisableField").val()
            };

            $.ajax({
                url: 'updateUserInfo',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(updatedUser),
                success: function(response) {
                    alert("���� ������ �����Ǿ����ϴ�.");
                    // ���� �� �ʿ��� ���� (��: ���̺� ���� ��)
                }
            });
        }
        
        selectAll();
        }); 
    </script>
</body>
</html>
