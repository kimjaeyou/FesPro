$(document).ready(function() {
	const pw = $('#company-pw'); // 비밀번호 입력 필드
	const pwCheck = $('#confirm-password'); // 비밀번호 확인 필드
	const message = $('#password-match-message'); // 비밀번호 일치 여부 메시지

	pwCheck.on('input', function() {
		if (pw.val() === "" || pwCheck.val() === "") {
			message.text('');
			return;
		}

		if (pw.val() === pwCheck.val()) {
			message.text('비밀번호가 일치합니다.').css('color', 'green');
		} else {
			message.text('비밀번호가 일치하지 않습니다.').css('color', 'red');
		}
	});

	const signupForm = $('#corporate-signup-form');

	signupForm.on('submit', function(event) {
		if (pw.val() !== pwCheck.val()) {
			event.preventDefault(); // 기본 제출 동작 막기
			alert("비밀번호가 일치하지 않습니다."); // 경고 메시지 표시
		}
	});
});

$("#company-id").keyup(function() {
	if ($("#company-id").attr("readonly")) {
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
		data: { key: "host", methodName: "idCheck", id: $("#company-id").val() }, //서버에게 보낼 데이터정보(parameter정보)
		success: function(result) {
			if (result) {
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