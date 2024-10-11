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


$(document).ready(function() {
    $("#username").keyup(function() {
        // readonly 속성이 있을 경우 조기 종료
        if ($(this).attr("readonly")) {
            return;
        }

        // 입력값이 비어있는 경우
        if ($(this).val() == "") {
            $("span").text("중복결과여부"); // 기본 메시지로 초기화
            return;
        }

        // AJAX 요청
        $.ajax({
            url: "ajax", // 서버 요청 주소 (적절한 주소로 변경)
            type: "post", // 요청 방식
            dataType: "json", // 응답 타입
            data: {
                key: "user",
                methodName: "idCheck",
                id: $(this).val()
            }, // 서버에게 보낼 데이터
            success: function(result) {
                console.log(result);
                
                // 사용 가능한 아이디인지 여부를 확인
                if (result.available) {
                    $("span").text("사용 가능한 아이디입니다."); // 사용 가능
                } else {
                    $("span").text("이미 사용 중인 아이디입니다."); // 사용 불가
                }
            }, // 성공했을 때 실행할 함수
            error: function(err) {
                console.error(err);
                alert("서버와의 통신에 실패했습니다.");
            } // 실패했을 때 실행할 함수
        }); // AJAX 끝
    }); // keyup 끝
}); // document ready 끝


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
