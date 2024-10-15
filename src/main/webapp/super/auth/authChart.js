// 전역 옵션
Chart.defaults.responsive = true; // 모든 차트에 대해 반응형 설정
Chart.defaults.maintainAspectRatio = false; // 모든 차트에서 비율 유지하지 않음

// 서울 25개 구 리스트
const seoulDistricts = [
  '강남구', '강동구', '강북구', '강서구', '관악구', '광진구', '구로구', '금천구', '노원구', 
  '도봉구', '동대문구', '동작구', '마포구', '서대문구', '서초구', '성동구', '성북구', '송파구', 
  '양천구', '영등포구', '용산구', '은평구', '종로구', '중구', '중랑구'
];

// 남녀 비율 차트를 서울의 25개 구별로 막대그래프로 변경
function createDistrictChart(ctx, FesList) {
  // 서울 25개 구별로 행사 개수 세기
  const districtCounts = seoulDistricts.map(district => {
    return FesList.filter(fes => fes.AREANM === district).length;
  });

  new Chart(ctx, {
    type: 'bar', // 막대 그래프
    data: {
      labels: seoulDistricts, // 서울의 25개 구 이름
      datasets: [{
        label: '서울 25개 구별 행사 수',
        data: districtCounts, // 각 구별로 행사의 개수
        backgroundColor: 'rgba(54, 162, 235, 0.5)', // 막대 색상
        borderColor: 'rgba(54, 162, 235, 1)', // 테두리 색상
        borderWidth: 1 // 테두리 두께
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true, // y축이 0부터 시작
          title: {
            display: true,
            text: '행사 수'
          }
        },
        x: {
          title: {
            display: true,
            text: '구 이름'
          }
        }
      }
    }
  });
}

// 차트 생성 함수 호출 예시
// FesList는 서버에서 가져온 행사 데이터 리스트
const ctx = document.getElementById('myBarChart').getContext('2d');
createDistrictChart(ctx, FesList); // FesList는 request로 받아온 데이터