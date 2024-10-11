const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirm-password');
const passwordMatchMessage = document.getElementById('password-match-message');

confirmPassword.addEventListener('input', function() {
    if (password.value === confirmPassword.value) {
        passwordMatchMessage.textContent = '비밀번호가 일치합니다.';
        passwordMatchMessage.style.color = 'green';
    } else {
        passwordMatchMessage.textContent = '비밀번호가 일치하지 않습니다.';
        passwordMatchMessage.style.color = 'red';
    }
});

// 중복 체크 버튼 이벤트 (예시)
document.getElementById('check-username').addEventListener('click', function() {
    alert("아이디 중복 체크 기능이 필요합니다."); // 실제 기능은 서버와 연동하여 구현
});
