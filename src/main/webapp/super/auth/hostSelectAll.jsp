<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<!-- datatables -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/v/bs5/dt-2.1.8/datatables.min.css" rel="stylesheet">

<!-- jquery 및 datatables JS 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.datatables.net/v/bs5/dt-2.1.8/datatables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>

<script>
$(function() {
    // DataTable 초기화
    $('#example').DataTable();

    // 버튼 클릭 시 상세보기로 이동
    $(document).on('click', '.btn.btn-primary', function() {
        const host_id = $(this).data('host_id');
        window.location.href = "${path}/front?key=superAuth&methodName=hostDetail&host_id=" + host_id;
    });
});
</script>
</head>

<body>
<!-- 페이지 제목 -->
<h1 class="mt-4">전체 주최자 조회</h1>
<ol class="breadcrumb mb-4">
    <li class="breadcrumb-item active">전체 주최자의 목록을 출력합니다</li>
</ol>

<!-- 주최자 테이블 -->
<div class="card mb-4">
    <div class="card-header">
        <i class="fas fa-table me-1"></i> 전체 주최자 테이블
    </div>
    <div class="card-body">
        <table id="example" class="table table-striped" style="width: 100%">
            <thead>
                <tr>
                    <th>주최자 고유번호</th>
                    <th>주최자 아이디</th>
                    <th>주최자 기업명</th>
                    <th>주최자 비밀번호</th>
                    <th>주최자 전화번호</th>
                    <th>대표자 이름</th>
                    <th style="font-weight: bold;">회원가입 승인여부</th>
                    <th>가입자 이름</th>
                    <th style="font-weight: bold;">밴 여부</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="host" items="${hostList}">
                    <tr>
                        <td>${host.host_seq}</td>
                        <td>
                            <button type="button" class="btn btn-primary" data-host_id="${host.host_id}">
                                ${host.host_id}
                            </button>
                        </td>
                        <td>${host.com_name}</td>
                        <td>${host.host_pw}</td>
                        <td>${host.host_tel}</td>
                        <td>${host.host_name}</td>
                        <td style="font-weight: bold;">
                            <c:choose>
                                <c:when test="${host.host_check == 0}">
                                    <span class="badge rounded-pill text-bg-warning">미승인 상태</span>
                                </c:when>
                                <c:when test="${host.host_check == 1}">
                                    <span class="badge rounded-pill text-bg-success">승인 상태</span>
                                </c:when>
                            </c:choose>
                        </td>
                        <td>${host.rep_name}</td>
                        <td style="font-weight: bold;">
                            <c:choose>
                                <c:when test="${host.host_ben_check == 0}">
                                    <span class="badge rounded-pill text-bg-danger">벤 상태</span>
                                </c:when>
                                <c:when test="${host.host_ben_check == 1}">
                                    <span class="badge rounded-pill text-bg-success">활성화 상태</span>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>