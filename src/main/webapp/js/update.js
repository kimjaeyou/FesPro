$(document).ready(function() {
	const password = $('#pw');
	const confirmPassword = $('#check-pw');
	const message = $('#print');

	confirmPassword.on('input', function() {
		if (password.val() === "" || confirmPassword.val() === "") {
			message.text('  ');
			return;
		}

		if (password.val() === confirmPassword.val()) {
			password.css('color', 'green');
			confirmPassword.css('color', 'green');
			message.text("비밀번호가 일치합니다").css('color','green');
		} else {
			password.css('color', 'red');
			confirmPassword.css('color', 'red');
			message.text("비밀번호가 틀렸습니다").css('color','red');
		}
	});

	const signupForm = $('#update-form');

	signupForm.on('submit', function(event) {
		if (password.val() !== confirmPassword.val()) {
			event.preventDefault(); // 기본 제출 동작 막기
			alert("비밀번호가 일치하지 않습니다."); // 경고 메시지 표시
		}
	})
})