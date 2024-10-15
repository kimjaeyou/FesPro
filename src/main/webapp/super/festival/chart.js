/*문화 행사 차트========================================================= */
// 전역 옵션
Chart.defaults.responsive = true; // 모든 차트에 대해 반응형 설정
Chart.defaults.maintainAspectRatio = false; // 모든 차트에서 비율 유지하지 않음

const ageList=['10대 이하', '20대', '30대', '40대', '50대', '60대', '70대 이상'];
const maleColor ='rgba(54, 162, 235, 0.5)';
const femaleColor = 'rgba(255, 99, 132, 0.5)';

//연령별 리스트 반환
function getAgeCountList(userList){
	const ageCountList = new Array(ageList.length).fill(0);
	
	userList.filter((user,index)=>{
		if(user.age < 20) ageCountList[0]++;
		else if(user.age < 30) ageCountList[1]++;
		else if(user.age < 40) ageCountList[2]++;
		else if(user.age < 50) ageCountList[3]++;
		else if(user.age<60) ageCountList[4]++;
		else if(user.age<70) ageCountList[5]++;
		else ageCountList[6]++;
	});
	
	return ageCountList;
};

// 연령, 성별 별 차트
function ageGender(ctx,userList) {
	//console.log(userList);
	
	const femaleList = userList.filter((user)=>user.gender ==="여성");
	const maleList = userList.filter((user)=>user.gender ==="남성");
	
    new Chart(ctx, {
        type: 'bar',
        data: {
        labels: ageList,
        datasets: [
			{
                label: '남',
                data: getAgeCountList(maleList),
                //borderColor: 'rgba(54, 162, 235, 1)',
                backgroundColor: maleColor,
            },
            {
                label: '여',
                data: getAgeCountList(femaleList),
                //borderColor: 'rgba(255, 99, 132, 1)',
                backgroundColor: femaleColor,
            },
            
        ]},
        options: {
            scales: {
            y: {
                beginAtZero: true, // Y축이 0부터 시작
                ticks: {
                    stepSize: 1 // Y축 단계를 1로 설정 (정수값만 표시)
                }
            }
        }
        }
    });
}

// 남녀 비율 차트
function genderRatio(ctx,userList) {
	const femaleCount = userList.filter((user)=>user.gender ==="여성").length;
	const maleCount = userList.filter((user)=>user.gender ==="남성").length;
	
    new Chart(ctx, {
      type: 'pie',
      data: {
        labels: ['남', '여'],
        datasets: [{
          label: '예약 수',
          data: [maleCount,femaleCount],
    //      backgroundColor: [maleColor,femaleColor],
        }]
      },
    });
}

//연령별 비율
function ageRatio (ctx,userList){
	new Chart(ctx, {
      type: 'pie',
      data: {
        labels: ageList,
        datasets: [{
          label: '예약 수',
          data: getAgeCountList(userList),
        }]
      },
    });
}

//성별별 평균 평점
function genderReviewAvg (ctx,reviewList){
	
	
    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['남성','여성'],
        datasets: [{
          label: '평균 평점',
          data: [],
          backgroundColor:[maleColor,femaleColor]
        }]
      },
    });
}

//연령별 평균 평점
