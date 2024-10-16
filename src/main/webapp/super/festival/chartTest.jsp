<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Page Title</title>
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>
<body>
  <h1>차트</h1>
  <div style="width:700px;">
    <h2>행사 분류별 통계</h2>
    <canvas id="myChart"></canvas>
    <h2>예약자 통계 - 남녀 비율</h2>
    <canvas id="myChart2"></canvas>
    <h2>예약자 통계 - 연령대 비율</h2>
    <canvas id="myChart3"></canvas>
    <h2>리뷰 평균 통계 - 성별</h2>
    <canvas id="myChart4"></canvas>
    <h2>리뷰 평균 통계 - 연령대별</h2>
    <canvas id="myChart5"></canvas>
    <h2>월간 예약자 통계 - 인원수 + 수익</h2>
    <canvas id="myChart6"></canvas>
    <h2>회차별 예약 빈도</h2>
    <canvas id="myChart7"></canvas>
  </div>
  <script>
    const ctx = document.getElementById('myChart');
    const ctx2 = document.getElementById('myChart2');
    const ctx3 = document.getElementById('myChart3');
    const ctx4 = document.getElementById('myChart4');
    const ctx5 = document.getElementById('myChart5');
    const ctx6 = document.getElementById('myChart6');
    const ctx7 = document.getElementById('myChart7');

    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['교육체험', '농장체험', '문화행사', '전시/관람', '단체봉사', '공원탐방','서울형키즈카페','산림여가'],
        datasets: [{
          label: '총 예약 수',
          data: [12, 19, 3, 5, 2, 3,5,2],
          borderWidth: 1
        },]
      },
  
    });

    new Chart(ctx2, {
      type: 'pie',
      data: {
        labels: ['남','여'],
        datasets: [{
          label: '예약 수',
          data: [10,3],
        }]
      },
    });

    new Chart(ctx3, {
      type: 'pie',
      data: {
        labels: ['영유아','10대 이하', '20대','30대','40대', '50대', '60대 이상'],
        datasets: [{
          label: '예약 수',
          data: [10,3,6,1,3,6,1],
        }]
      },
    });

    new Chart(ctx4, {
      type: 'bar',
      data: {
        labels: ['남','여'],
        datasets: [{
          label: '평균 평점',
          data: [3.6,4.2],
          backgroundColor:['#4957c4','#eb349b']
        }]
      },
    });

    new Chart(ctx5, {
      type: 'bar',
      data: {
        labels: ['영유아','10대 이하', '20대','30대','40대', '50대', '60대 이상'],
        datasets: [{
          label: '평균 평점',
          data: [3.6,4.2,2,4,3.3,2.2,5],
           backgroundColor: [
        'rgba(255, 99, 132, 1)', // 영유아
        'rgba(54, 162, 235, 1)', // 10대 이하
        'rgba(255, 206, 86, 1)', // 20대
        'rgba(75, 192, 192, 1)', // 30대
        'rgba(153, 102, 255, 1)', // 40대
        'rgba(255, 159, 64, 1)', // 50대
        'rgba(99, 255, 132, 1)'  // 60대 이상
      ],
      
        }]
      },
    });

     const team = Array.from({ length: 30 }, () => Math.floor(Math.random() * 5));
     const cost=[0,1000,1500,2500,3000];
      new Chart(ctx6, {
        type: 'bar', // 기본 차트 타입
        data: {
          labels: Array(30).fill(1).map((n, idx) => n + idx),  // x축 레이블
          datasets: [
          {
              type: 'line',  // 두 번째 데이터는 막대 그래프
            label: '수익',
            data: team.map((p)=>p * cost[Math.floor(Math.random()*5)]),
            yAxisID: 'y1',  // 두 번째 y축과 연결
          },          
          {
            label: '예약한 팀 수',
            data: team,  // 0~10 범위의 랜덤값
            tension: 0.1,
            yAxisID: 'y',  // 첫 번째 y축과 연결
          }

          ]
        },
        options: {
          scales: {
            y: {
              type: 'linear',  // 기본 y축 (인원수)
              position: 'left',  // 왼쪽에 위치
              ticks: {
                stepSize: 1  // 인원수는 1 단위로 증가
              },
              max : 5
            },
            y1: {
              type: 'linear',  // 두 번째 y축 (수익)
              position: 'right',  // 오른쪽에 위치
              grid: {
                drawOnChartArea: false  // 격자선을 그리지 않음 (차트 깔끔하게 유지)
              },
             // ticks: {
             //   stepSize: 200  // 수익은 200 단위로 증가
             // }
             min : 0,
             max : 15000
            }
          }
        }
      });

      const 회차 = ["1부 10:00~ 12:00","2부 12:00~14:00","3부 14:00~15:00"].reverse();
      const dummy = [
   { x: 1, y: 회차[0], r: 4 },   // 1일, 1부(회차[0]), 예약 팀 수 4개
    { x: 2, y: 회차[1], r: 7 },   // 2일, 2부(회차[1]), 예약 팀 수 7개
    { x: 3, y: 회차[2], r: 5 },   // 3일, 3부(회차[2]), 예약 팀 수 5개
    { x: 4, y: 회차[0], r: 2 },   // 4일, 1부(회차[0]), 예약 팀 수 2개
    { x: 5, y: 회차[1], r: 8 },   // 5일, 2부(회차[1]), 예약 팀 수 8개
    { x: 7, y: 회차[2], r: 1 },   // 7일, 3부(회차[2]), 예약 팀 수 1개
    { x: 10, y: 회차[0], r: 3 },  // 10일, 1부(회차[0]), 예약 팀 수 3개
    { x: 15, y: 회차[1], r: 9 },  // 15일, 2부(회차[1]), 예약 팀 수 9개
    { x: 20, y: 회차[2], r: 12 }, // 20일, 3부(회차[2]), 예약 팀 수 12개
    { x: 22, y: 회차[0], r: 6 },  // 22일, 1부(회차[0]), 예약 팀 수 6개
    { x: 25, y: 회차[1], r: 10 }, // 25일, 2부(회차[1]), 예약 팀 수 10개
    { x: 28, y: 회차[2], r: 8 },  // 28일, 3부(회차[2]), 예약 팀 수 8개
    { x: 30, y: 회차[0], r: 7 }   // 30일, 1부(회차[0]), 예약 팀 수 7개
];

      new Chart(ctx7, {
  type: 'bubble',  // 버블 차트 사용
  data: {
    datasets: [{
      label: '예약한 팀',
      data: dummy,
      backgroundColor: 'rgba(75, 192, 192, 0.6)',
      borderColor: 'rgba(75, 192, 192, 1)',
      borderWidth: 1
    }]
  },
  options: {
    scales: {
      x: {
        type: 'linear',  // x축은 날짜 (1~30일)
        position: 'bottom',
          min: 1,       // x축 최소값 1일
          max: 30,       // x축 최대값 30일
        ticks: {
          stepSize: 1,  // x축 값 간격을 1로 설정
        }
      },
      y: {
        type: 'category',  // y축은 회차
        labels: 회차 // y축 레이블에 회차 배열 사용
      }
    }
  }
});


    

  </script>
</body>
</html>