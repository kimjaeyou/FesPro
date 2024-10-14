$(document).ready(function() {
    const password = $('#pw');
    const confirmPassword = $('#check-pw');
    const passwordMatchMessage = $('#message');

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

    const signupForm = $('#member-update-form');

    signupForm.on('submit', function(event) {
        if (password.val() !== confirmPassword.val()) {
            event.preventDefault();
            alert("비밀번호가 일치하지 않습니다.");
        }
    });
});
