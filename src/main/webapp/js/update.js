// 이메일 선택 옵션 변경 시 두 번째 입력 필드에 값 입력 및 비활성화
document.getElementById('addressSelect').addEventListener('change', function() {
    const emailInput2 = document.getElementById('emailInput2');

    if (this.value) {
        emailInput2.value = this.value; // 선택한 옵션을 두 번째 입력 필드에 넣기
        emailInput2.disabled = true; // 두 번째 입력 필드 비활성화
    } else {
        emailInput2.value = ''; // 아무것도 선택하지 않으면 필드 비우기
        emailInput2.disabled = false; // 두 번째 입력 필드 활성화
    }
});

// 실시간으로 비밀번호 일치 여부 확인
confirmPassword.addEventListener('input', function () {
    if (password.value === confirmPassword.value) {
        passwordMessage.style.color = 'green';
        passwordMessage.textContent = '비밀번호가 일치합니다.';
    } else {
        passwordMessage.style.color = 'red';
        passwordMessage.textContent = '비밀번호가 일치하지 않습니다.';
    }
});
function confirmDelete() {
    if (confirm("정말로 회원탈퇴하시겠습니까?")) {
        // 회원탈퇴 관련 로직 추가
        alert("회원탈퇴가 완료되었습니다."); // 실제 탈퇴 로직을 구현 후 알림
    }
}