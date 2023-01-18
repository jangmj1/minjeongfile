//학생들의 점수객체를 여러개 저장하는 배열
let studentArray=[]

//onclick 으로 버튼 함수를 이벤트 줘도되지만 ..  배운걸로 실행
//1.js열렸을때!! 버튼 객체 가져오기
let addbtn=document.querySelector('.addbtn')

//2.해당 버튼에 클릭 이벤트
addbtn.addEventListener('click',()=>{ //온클릭 한거랑 같은거임
	//입력받은 데이터를 가져오기ㅣ 인풋들
	let inputArray=document.querySelectorAll('input') 	//여러개를 한번에 가져오기 위해서 ALL
		console.log(inputArray)
		//1.입력받은 데이터를 하나씩 자겨와서 객체화
		let info={ //inpug에 숫자를 입력해도 value는 무조건 문자열로 가져온다 형변환 필요!!!!!
			name: document.querySelector('.name').value,
			kor:  parseInt(document.querySelector('.kor').value),  // parseInt를 사용하여 문자를 실수로 변경
			eng:  parseInt(document.querySelector('.eng').value),
			mat:  parseInt(document.querySelector('.mat').value)
		}
	console.log(info)
	
	//유효성 검사[데이터 체크]
		//1.이름 중복이 있냐없냐 찾기
		/*studentArray.forEach( (Obj)=>{ //foreach s
			if(Obj.name==info.name){ //if s
				alert('현재 등록된 학생명 입니다.');
			}//if s
		})//foreach e
		//2. 타입 확인
		console.log(typeof ( info.name))
		console.log(typeof (info.kor))
		*typeof(데이터)=해당 데이터형 확인[object,array,function  등등]
	*/
	
	
	
	//2.유효성 검사
	let check=true;//유효성 검사 상태 저장하는 변수 [아래 4개중 하나라도 충족하면 저장 실패]
	
	for(let i=0;i<studentArray.length;i++){
		if(studentArray[i].name==info.name){
			alert('현재 등록된 학생명 입니다.');check=false;
			
		}
	} //이거랑 위에꺼랑 같은거임
	
	// 0~100 사이만 입력 가능
	if( (info.kor<0||info.kor>100) ||
	  (info.eng<0||info.eng>100) ||
	  (info.mat<0||info.mat>100) ){
		  alert('입력할수 없는 점수 범위입니다.');check=false;
		  
	  }
	if (info.name.length<3||info.name.length>5){
		alert('세글자에서 다섯글자 사이로 작성해주세요.');check=false;
	}
	//4. 숫자 아.닐.걸 찾고싶을때 [isNaN() : 숫자형 체크  [문자이면 true or 숫자이면 false]
	if( isNaN(info.kor)||isNaN(info.eng)||isNaN(info.mat) ){
		alert('숫자형식으로 입력해주세요');check=false;
		}
	//3.저장[위 유효성 검사에서 하나라도 충족하지 않았을때]
	if(check){
		studentArray.push(info);alert('학생 정보를 입력하였습니다.')
		printTable();
	}
	
		console.log('학생'+studentArray)


//출력하기

})

printTable();//만든 함수를 아무런 조건없이 쓰기위해 호출[1.js열렸을때,2.등록하거나 삭제할때 /업데이트 (어떤변화가있을때)]
function printTable(){ // 함수를 만드는것뿐 쓴게아니다
	
	
	let html=`<tr>
		 <th>번호</th> <th>이름</th> <th>국어</th> 
		 <th>영어</th> <th>수학</th> <th>총점</th> 
		 <th>평균</th> <th>순위</th> <th>비고</th> </tr>`
		
		studentArray.forEach( (o,i)=>{
			
			
			let total=o.kor+o.eng+o.mat;
			
			let rank=1;
			
			studentArray.forEach( (o2)=>{
			//1.비교할총점
			let total2=o2.kor+o2.eng+o2.mat;
			//2. 만약에 총점이 비교할총점 보다 작으면 순위 하락
			if(total<total2){rank++;}
			})	
			
		
			html+=`<tr>
			 <td>${i+1}</td> 	<td>${o.name}</td> 	<td>${o.kor}</td> 
			 <td>${o.eng}</td> 	<td>${o.mat}</td>   <td>${o.kor+o.eng+o.mat}</td> 
			 <td>${parseInt(total/3)}</td> <td>${rank}</td>
			 <td><button onclick="del(${i})">삭제</button><button onclick="onUpdate(${i})">수정</button></td> </tr>`
		})	
	
	document.querySelector('.listtable').innerHTML=html;
}

	function del(i){
		studentArray.splice(i,1) //삭제
		printTable()
		}

	let upindex=-1;// 수정할 인덱스// 여러개의{}에서 동일한 변수를사용하기위해 전역변수로 만든거임 
		// -1을 넣는 이유 : 인덱스 없다는 표시

	function onUpdate(i){//수정 버튼 클릭했을때 실행해라
	upindex=i // 여기서는 -1이 아니라 내가 클릭한 인덱스가 된다
	//1.숨겨져 있는 수정 페이지를 다시 보여주기 
	document.querySelector('.updatebox').style.display='block'
	
	//2.선택한 i번째 객체의 속성 대이터를 대입	 ->기존의 값을 가져온다
	document.querySelector('.upname').value=studentArray[upindex].name
	document.querySelector('.upkor').value=studentArray[upindex].kor
	document.querySelector('.upeng').value=studentArray[upindex].eng
	document.querySelector('.upmat').value=studentArray[upindex].mat
	}
	
	//5. 수정완료 버튼을 클릭 했을때 
		
	let updatebtn=document.querySelector('.updatebtn')
	updatebtn.addEventListener('click',()=>{
			
			//1.수정처리
				//1-1 해당 객체의 속성값 변경
			studentArray[upindex].kor=parseInt (document.querySelector('.upkor').value)
			studentArray[upindex].eng=parseInt (document.querySelector('.upeng').value)
			studentArray[upindex].mat=parseInt (document.querySelector('.upmat').value)
			
			// 2.다시 안보이게 만들기
		document.querySelector('.updatebox').style.display='none'	
		printTable();
		
	})
       
       
       
       
         
       /*
	- 배열내 순위 
	예시)
		for1 : 80	90	75	100
		for2 : 80	90	75	100
		
	1.
		80 일때	rank = 1
			80일때	80 < 80		f
			90일때	80 < 90		t rank++	rank = 2
			75일때	80 < 75		f
			100일때	80 < 100	t rank++	rank = 3 
		90 일때	rank = 1
			80일때	90 < 80		f
			90일때	90 < 90		f
			75일때	90 < 75		f
			100일때	90 < 100	t rank++	rank = 2
		75 일때	rank = 1
			80일때	75 < 80		t rank++	rank = 2
			90일때	75 < 90		t rank++	rank = 3 
			75일때	75 < 75		f
			100일때	755 < 100	t rank++	rank = 4
		100 일때	rank = 1
			80일때	100 < 80	f
			90일때	100 < 90 	f
			75일때	100 < 75	f
			100일때	100 < 100	f			rank = 1

*/
       
       
       
       



