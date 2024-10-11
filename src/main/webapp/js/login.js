function showSection(section) {
    // 모든 로그인 섹션을 숨깁니다.
    var sections = document.getElementsByClassName('login-section');
    for (var i = 0; i < sections.length; i++) {
        sections[i].classList.remove('active');
    }

    // 모든 탭 버튼에서 active 클래스를 제거합니다.
    var tabButtons = document.getElementsByClassName('tab-btn');
    for (var i = 0; i < tabButtons.length; i++) {
        tabButtons[i].classList.remove('active');
    }

    // 선택된 섹션을 활성화하고 해당 탭에 active 클래스를 추가합니다.
    document.getElementById(section + '-login').classList.add('active');
    document.getElementById(section + '-tab').classList.add('active');
}
