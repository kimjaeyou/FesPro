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
