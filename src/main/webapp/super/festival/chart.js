/*문화 행사 차트========================================================= */

const ageList=['10대 이하', '20대', '30대', '40대', '50대', '60대', '70대 이상'];
const maleColor ='rgba(54, 162, 235, 0.5)';
const femaleColor = 'rgba(255, 99, 132, 0.5)';

// 연령, 성별 별
function ageGender(ctx,userList) {
	console.log(userList);
	let femaleList= new Array(ageList.length).fill(0);
	 femaleList = userList.filter((user)=>user.gender ==="여성");
	 maleList = userList.filter((user)=>user.gender ==="남성");
	console.log(femaleList);
	
    new Chart(ctx, {
        type: 'bar',
        data: {
        labels: ageList,
        datasets: [
            {
                label: '여',
                data: [1,5,4,0,3,7,10],
                //borderColor: 'rgba(255, 99, 132, 1)',
                backgroundColor: femaleColor,
            },
            {
                label: '남',
                data: [10,10,10,10,10,10,10],
                //borderColor: 'rgba(54, 162, 235, 1)',
                backgroundColor: maleColor,
            }
        ]},
        options: {
            responsive: true,
            maintainAspectRatio: false
        }
    });
}

// 남녀 비율
function genderRatio(ctx,userList) {
    new Chart(ctx, {
      type: 'pie',
      data: {
        labels: ['남', '여'],
        datasets: [{
          label: '예약 수',
          data: [10, 3],
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false
      }
    });
}

//연령별 비율
function ageRatio (ctx,userList){
	new Chart(ctx, {
      type: 'pie',
      data: {
        labels: ['영유아','10대 이하', '20대','30대','40대', '50대', '60대 이상'],
        datasets: [{
          label: '예약 수',
          data: [10,3,6,1,3,6,1],
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false
      }
    });
}
