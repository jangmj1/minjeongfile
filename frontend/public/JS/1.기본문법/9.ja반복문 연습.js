//예)1부터 10이하 까지 1씩 증가 반복
for(let i=1; i<=10;i ++){
	console.log(i)
}
//예 2 i는 ㅣ부터 10까지 1씩 증가 반복[한줄에 모두 출력]
console.log('-------------예2-----------')

let output=''//빈깡통}
for(let i=1;i<=10;i++){//fors
	output +=i+"\t";
 }// vs output=output +i //누적기록
console.log(output)
//예 i는 1부터 10이하까지 2씩증가 반복[html 출력]
console.log('-----------예3-----------')
output='' 
for(let i =1;i<=10;i++){
	output +=i+"\t"
	
}                    
document.querySelector('body').innerHTML=output

//예4 i는 1부터 10이하 까지 1씩 증가 반복 누적 합계
let sum=0; //숫자변수
for(let i=1;i<=10;i++){
	sum+=i
	//확인용
	console.log( "i = " + i + "\t"+i+"<=10 " + (i<=10 ) +"\t"+ sum+"+="+i +"\t i++" ) 
	
	}
console.log(sum)

//예5 1부터 100까지 7배수 누적 합계
console.log('-----------------예4-----------------')
//i.[i+=7]
sum=0;
for(let i=7;i<=100;i+=7){sum +=i}
//2.if(i%7==0)
console.log(sum)
for(let i=1;i<=100;i++){ //for s
	if(i%7==0){//if s
		sum+=i}//if e
		}//for e
console.log('-----------------예5(2단)-----------------')
output=''
for(let 곱=1;곱<=9;곱++){// for s
//곱은 1부터 9까지 1씩 증가 하면서 반복처리
	console.log('2*'+곱+' = '+(2*곱)) //변수는 문자 처리 안됨
	output+='2*'+곱+' = '+(2*곱)+'<br>'
	//for e
	document.querySelector('body').innerHTML=output

}
console.log('-----------------예5(구구단)-----------------')
//단:2~9 변수 곱:1~9 변수
//1.단 만들기
	for(let 단=2;단<=9;단++){
		//단 2부터 9까지 1씩 증가 반복처리
		console.log(단)
	}
//2.곱 만들기	
	for(let 곱=1;곱<=9;곱++){곱//곱 1부터 9까지 1씩 증가 반복처리
		console.log(곱)
	}
//3.단안에 곱넣기 기
	for(let 단=2;단<=9;단++){
		//단 2부터 9까지 1씩 증가 반복처리
		console.log(단)
			for(let 곱=1;곱<=9;곱++){곱//곱 1부터 9까지 1씩 증가 반복처리
			console.log(곱)
	}
	}
//4.출력하기

	for(let 단=2;단<=9;단++){//1번째 포문의 시작
		//단 2부터 9까지 1씩 증가 반복처리
			for(let 곱=1;곱<=9;곱++){곱//곱 1부터 9까지 1씩 증가 반복처리 ,2번째 포문의 끝
			console.log(단+'*'+곱+'='+(단*곱))
		}//2번째 포문의 끝
	}//1번째 포문의 끝

