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

//연령별 리뷰점수의 합 리스트
function getAgeReviewAvgList(reviewUserList){
	const reviewScoreList = new Array(ageList.length).fill(0);
	
	reviewUserList.filter((user,index)=>{
		if(user.age < 20) reviewScoreList[0]+= user.reviewScore;
		else if(user.age < 30) reviewScoreList[1]+=user.reviewScore;
		else if(user.age < 40) reviewScoreList[2]+=user.reviewScore;
		else if(user.age < 50) reviewScoreList[3]+=user.reviewScore;
		else if(user.age<60) reviewScoreList[4]+=user.reviewScore;
		else if(user.age<70) reviewScoreList[5]+=user.reviewScore;
		else reviewScoreList[6]+=user.reviewScore;
	});
	
	return reviewScoreList;
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
function genderReviewAvg (ctx,reviewUserList){
	//한 성별의 평균을 모두 더하고 한 성별의 숫자만큼 나누기
	const femaleList = reviewUserList.filter((user)=>user.gender ==="여성");
	const maleList = reviewUserList.filter((user)=>user.gender ==="남성");
	
	const femaleScoreAvg = femaleList.reduce((sum, female) => sum + female.reviewScore, 0) / femaleList.length;
	const maleScoreAvg = maleList.reduce((sum, male) => sum + male.reviewScore, 0) / maleList.length;
	
    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['남성','여성'],
        datasets: [{
          label: '평균 평점',
          data: [maleScoreAvg,femaleScoreAvg],
          backgroundColor:[maleColor,femaleColor]
        }]
      },
      options : {
		  plugins : {
			  legend : {
					display : false
				}
		  }
	  }
    });
}

//연령별 평균 평점
function ageReviewAvg (ctx,reviewUserList){
	//나이대별 점수의합 필요
	//getAgeCountList(reviewUserList)  0,1,0,0,0,1 -> 인원수
	
	new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ageList,
			datasets: [{
				label: '평균 평점',
				data: getAgeReviewAvgList(reviewUserList),
				backgroundColor: [
					'rgba(255, 99, 132, 1)', 
					'rgba(54, 162, 235, 1)', 
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)',
					'rgba(99, 255, 132, 1)'
				],
			}]
		},
		 options : {
		  plugins : {
			  legend : {
					display : false
				}
		  }
	  }
	});
}

