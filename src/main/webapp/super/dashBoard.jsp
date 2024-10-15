<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="${path}/css/My_styles.css" rel="stylesheet" />

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
                        <div class="card-body">행사등록 미승인건</div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a href="${path}/front?key=superfestival&methodName=dashFesSelectAll" class="small text-white stretched-link">목록가기</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>

                <!-- 2번째 카드: 행사수정 미승인건 -->
                <div class="col-12">
                    <div class="card bg-warning text-white mb-4">
                        <div class="card-body">행사수정 미승인건</div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a href="${path}/front?key=superfestival&methodName=dashFesUpSelectAll" class="small text-white stretched-link">목록가기</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>

                <!-- 3번째 카드: 주최자 회원가입 미승인건 -->
                <div class="col-12">
                    <div class="card bg-success text-white mb-4">
                        <div class="card-body">주최자 회원가입 미승인건</div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">목록가기</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>

                <!-- 4번째 카드: 행사취소 미승인건 -->
                <div class="col-12">
                    <div class="card bg-danger text-white mb-4">
                        <div class="card-body">행사취소 미승인건</div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">목록가기</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
                </main>
                
            </div>
        </div>
</body>
</html>