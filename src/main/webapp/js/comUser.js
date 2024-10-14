const pw = document.getElementById('company-pw'); // 비밀번호 입력 필드
const pwCheck = document.getElementById('confirm-password'); // 비밀번호 확인 필드
const message = document.getElementById('password-match-message'); // 비밀번호 일치 여부 메시지

pwCheck.addEventListener('input', function() {
	if (pw.value === '' || pwCheck.value === '') {
		message.textContent = '';
		return;
	}

	if (pw.value === pwCheck.value) {
		message.textContent = '비밀번호가 일치합니다.';
		message.style.color = 'green';
	} else {
		message.textContent = '비밀번호가 일치하지 않습니다.';
		message.style.color = 'red';
	}
});