$(document).ready(function() {
	// 비밀번호 확인 로직
	const password = $('#password');
	const confirmPassword = $('#confirm-password');
	const passwordMatchMessage = $('#password-match-message');

	confirmPassword.on('input', function() {
		if (password.val() === "" || confirmPassword.val() === "") {
			passwordMatchMessage.text('');
			return;
		}

		if (password.val() === confirmPassword.val()) {
			passwordMatchMessage.text('비밀번호가 일치합니다.').css('color', 'green');
		} else {
			passwordMatchMessage.text('비밀번호가 일치하지 않습니다.').css('color', 'red');
		}
	});

	const signupForm = $('#signup-form');

	signupForm.on('submit', function(event) {
		if (password.val() !== confirmPassword.val()) {
			event.preventDefault(); // 기본 제출 동작 막기
			alert("비밀번호가 일치하지 않습니다."); // 경고 메시지 표시
		}
	});
});

$("#username").keyup(function() {
	if ($("#username").attr("readonly")) {
		return;
	}
	if ($(this).val() == "") {
		$("span").text("");
		return;
	}

	$.ajax({
		url: "../ajax", //서버요청주소
		type: "post", //요청방식(method방식 : get | post | put | delete )
		dataType: "json", //서버가 보내온 데이터(응답)타입(text | html | xml | json )
		data: { key: "user", methodName: "idCheck", id: $("#username").val() }, //서버에게 보낼 데이터정보(parameter정보)
		success: function(result) {
			if(result) {
			$("span").text(result).css('color', 'green');
			} else {
			$("span").text(result).css('color', 'red');
			}
		},
		error: function(err) {
			alert(err + "에러 발생했어요.");
		}
	});//ajax
});//keyup
