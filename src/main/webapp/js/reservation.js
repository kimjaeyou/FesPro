onload = () => {
				// 인원수 제어
                let plus = document.querySelector(".plus");
                let minus = document.querySelector(".minus");
                let result = document.getElementById("people-num");
                let i = 0;
                
                plus.addEventListener("click", ()=>{
                    i++;
                    result.innerHTML = i;
                })

                minus.addEventListener("click", () => {
                    if(i>0){
                        i--;
                        result.innerHTML = i;
                    } else {
                        i=0;
                        result.innerHTML = i;
                    }
                })
                
                // date picker 
                const getDatePickerTitle = elem => {
                    // From the label or the aria-label
                    const label = elem.nextElementSibling;
                    let titleText = '';
                    if (label && label.tagName === 'LABEL') {
                    titleText = label.textContent;
                    } else {
                    titleText = elem.getAttribute('aria-label') || '';
                    }
                    return titleText;
                }
                
                const elems = document.querySelectorAll('.datepicker_input');
                for (const elem of elems) {
                    const datepicker = new Datepicker(elem, {
                    // 'format': 'dd/mm/yyyy', // UK format
                    'format': 'yyyy년 mm월 dd일', // UK format
                    title: getDatePickerTitle(elem)
                    });
                }
            } // onload 끝
			
			document.querySelector("#chkAll").addEventListener("click", (e) => {
			    document.querySelectorAll("[name=agreement]").forEach((item, index)=>{
			        item.checked = e.target.checked;
			    })
			});

			// 등록버튼
			function sendInsert() {
			    let date = $("[data-form=date]").text();
			    let time = $(".selectTime").text();
			    let peopleNum = $("[data-form=peopleNum]").text();
			    let fee = $("[data-form=fee]").text();
			    console.log(date);
			    console.log(time);
			    console.log(peopleNum);
			    document.resvForm.date.value = date;
			    document.resvForm.time.value = time;
			    document.resvForm.peopleNum.value = peopleNum;
			    document.resvForm.fee.value = fee;
			    document.resvForm.submit();
			}
			
			// 사이드바에 선택한 값 입력
			$(document).on("click", ".rd-day-body", function() {
				let date = $("#result").val();
			       console.log(date);
				$("[data-form=date]").html(date);
			})

			   $(document).on("click", ".datepicker-cell", function() {
				let date = $("#datepicker1").val();
				$("[data-form=date]").html(date);
			})

			$(document).on("click", ".time", function() {
				let time = $(this).text();
				$("[data-form=time]").html(time);
			})

			   $(document).on("click", "#button-search", function(){
			       let peopleNum = $("#people-num").html();
			       $("[data-form=peopleNum]").html(peopleNum);
			})