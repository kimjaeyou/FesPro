<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="${path}/css/My_styles.css" rel="stylesheet" />

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" crossorigin="anonymous"></script>

<script>
 // 1. 행사등록 미승인건 개수 가져오기
function fetchPendingApprovalCount() {
    $.ajax({
        url: "${path}/ajax?key=superfestivalAjax&methodName=waitAcceptSelectAll",
        method: 'GET',
        dataType: 'text', // 서버에서 텍스트 형식으로 응답
        success: function (data) {
            $('#pendingApprovalCount').text("총 : "+data + "개");
        },
        error: function (error) {
            console.log("Error:", error);
        }
    });
}

 // 2. 행사수정 미승인건 개수 가져오기
function fetchPendingUpdateCount() {
    $.ajax({
        url: "${path}/ajax?key=superfestivalAjax&methodName=waitUpdateSelectAll",
        method: 'GET',
        dataType: 'text',
        success: function (data) {
            $('#pendingUpdateCount').text("총 : "+data + "개");
        },
        error: function (error) {
            console.log("Error:", error);
        }
    });
} 

// 3. 주최자 회원가입 미승인건 개수 가져오기
function fetchPendingHostApprovalCount() {
    $.ajax({
        url: "${path}/ajax?key=superAuthAjax&methodName=hostWaitSelectAll",
        method: 'GET',
        dataType: 'text',
        success: function (data) {
            $('#pendingHostApprovalCount').text("총 : "+data + "개");
        },
        error: function (error) {
            console.log("Error:", error);
        }
    });
}

// 4. 행사취소 미승인건 개수 가져오기
function fetchPendingCancelCount() {
    $.ajax({
        url: "${path}/ajax?key=superfestivalAjax&methodName=getPendingCancelCount",
        method: 'GET',
        dataType: 'text',
        success: function (data) {
            $('#pendingCancelCount').text("총 : "+data + "개");
        },
        error: function (error) {
            console.log("Error:", error);
        }
    });
}

        // 페이지 로드 시 각각의 카드를 업데이트
        $(document).ready(function () {
            fetchPendingApprovalCount();
            fetchPendingUpdateCount();
            fetchPendingHostApprovalCount();
            fetchPendingCancelCount();
        });
    </script>
</head>

<body>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Dashboard</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">Dashboard</li>
                </ol>

                <div class="row">
                    <!-- 1번째 카드: 행사등록 미승인건 -->
                    <div class="col-12">
                        <div class="card bg-primary text-white mb-4">
                            <div class="card-body">
                                행사등록 미승인건: <span id="pendingApprovalCount">로딩 중...</span>
                            </div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a href="${path}/front?key=superfestival&methodName=dashFesSelectAll" class="small text-white stretched-link">목록가기</a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>

                    <!-- 2번째 카드: 행사수정 미승인건 -->
                    <div class="col-12">
                        <div class="card bg-warning text-white mb-4">
                            <div class="card-body">
                                행사수정 미승인건: <span id="pendingUpdateCount">로딩 중...</span>
                            </div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a href="${path}/front?key=superfestival&methodName=dashFesWaitFesSelectAll" class="small text-white stretched-link">목록가기</a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>

                    <!-- 3번째 카드: 주최자 회원가입 미승인건 -->
                    <div class="col-12">
                        <div class="card bg-success text-white mb-4">
                            <div class="card-body">
                                주최자 회원가입 미승인건: <span id="pendingHostApprovalCount">로딩 중...</span>
                            </div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="${path}/front?key=superAuth&methodName=hostWaitSelectAll">목록가기</a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>

                    <!-- 4번째 카드: 행사취소 미승인건 -->
                    <div class="col-12">
                        <div class="card bg-danger text-white mb-4">
                            <div class="card-body">
                                행사취소 미승인건: <span id="pendingCancelCount">로딩 중...</span>
                            </div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="${path}/front?key=superfestival&methodName=dashFesCancleWaitFesSelectAll">목록가기</a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</body>

</html>