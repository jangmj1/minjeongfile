/*
	-출력
		콘솔출력:console.log()
		알람메시지 출력:alert()
		html출력:
			1.document.write()
			2.document.querySelector().innerHTML
	-입력
		1.알람메세지이비력:prompt()
		2.html입력:document.querySelector().value
		
	
*/
//예시1) 입력받은 수 만큼 * 출력
let output=''  //출력을 하기위한 출력 변수
let s1=Number(prompt('예시1 별개수'))

for(let i=1;i<=s1;i++){ //i는 1부터 입력받은 수 까지 1씩 증가반복 for s
	output+='*' // =는을 쓰면 대입[기존 데이터는 사라짐], += 누적대입[기존 데이터에 추가]
	
}//for e

console.log(output)

/*	만약에 5를 입력했을때 s1=5
	for(let i=1;i<=s1;i++)
		i		조건[i<=s2]				실행문			[output]		증감식
	i=1일때 		 1<=5		true	output += '*'	output += '*'		i++
	i=2일때 		 2<=5		true	output += '*'	output += '**'		i++
	i=3일때 		 3<=5		true	output += '*'	output += '***'		i++
	i=4일때 		 4<=5		true	output += '*'	output += '****'	i++
	i=5일때 		 5<=5		true	output += '*'	output += '*****'	i++
	i=6일때 		 6<=5		false	


*/

//예시2) 입력 받은 수 만큼 *출력[3줄(3배수)마다 줄바꿈)]
output='' //앞전에서 사용한 아웃풋을 초기화시킨다 다시''[공백]이 된다 let 쓰지않는 이유는 위에서 썼기때문
let s2=Number(prompt('예시 2 별개수'))
for(let i=1;i<=s2;i++){
	//1.별 출력
	output+='*'
	if(i%3==0){
		output+='\n'
	}
}
console.log(output)
/*
만약에 5를 입력했을때 s2=5
for(let i=1;i<=s2;i++)

		i		조건[i<=s2]	참/거짓		실행문		조건1[i%3==0]		[output]			증감식
	i=1일때 		 1<=5		true	output += '*'		1%3==1		output += '*'		i++
	i=2일때 		 2<=5		true	output += '*'		2%3==2		output += '**'		i++
	i=3일때 		 3<=5		true	output += '*'		3%3==0		output += '***\n'	i++
	i=4일때 		 4<=5		true	output += '*'		4%3==1		output += '***\n*'	i++
	i=5일때 		 5<=5		true	output += '*'		5%3==2		output += '***\n**'	i++
	i=6일때 		 6<=5		false	


*/


/*
1.입력받은 줄수[line]만큼 출력 예시 5
				i[line]				s[star]
*				i=1					s=1
**				i=2					s=1 2
***				i=3					s=1 2 3
****			i=4					s=1 2 3 4
*****			i=5					s=1 2 3 4 5
	i는 1부터 입력받은 수 까지 1씩증가 =for (let i=1;i<=line;i++)
	-s는 1부터 1까지
	-s는 1부터 2까지
	-s는 1부터 3까지
	-s는 1부터 4까지
	-s는 1부터 5까지
*/


output=''
let line1=Number(prompt('과제1 줄수'))
for(let i=1;i<=line1;i++){
	for(let s=1;s<=i;s++){
		output+='*'
	}
	output +='\n'
	
}
console.log(output)

output=''

let line2=Number(prompt('과제2 줄수'))
for(let i=1;i<=line2;i++){
	for(let s=line2;s>=i;s--){
		output+='*'
	}
	output +='\n'
	
}
console.log(output)

/*
let line2=Number(prompt('과제2 줄수'))
for(let i=1;i<=line2;i++){
 for(let s=1; s<=line2-i+1;s++){
	 output += '*';
	 }	
	 output +='\n'
}	
	
console.log(output)	
	*/


output=''
let line3=Number(prompt('과제3 줄수'))
for(let i=1;i<=line3;i++){
	
	for(let a=line3-i;a>=1;a--){
			output+=' '
	}
	/*
			5-1		4>=1	
					3>=1
					2>=1
					1>=1
			5-2		3>=1
					2>=1
					1>=1
			5-3
					2>=3
					
					
	*/
	
	for(let s=1;s<=i;s++){
		output+='*'
	}
	
	output +='\n'
	
}
console.log(output)


/*output=''
let line3=Number(prompt('과제3 줄수'))
for(let i=1;i<=line3;i++){
	for(let b=1;b<=line3-i;b++){
			output+=' '
	}
	for(let s=1;s<=i;s++){
		output+='*'
	}
	output +='\n'
}
console.log(output)
*/


output = ''
let line4 = Number( prompt('문제4 줄수 ') )
for( let i = 1 ; i<=line4 ; i++ ){ // for s 
	//1. 
	for( let b = 1 ; b<=i-1 ; b++ ){ // for s 
		output += ' '
	} // for e 
	//2.
	for( let s = 1 ; s<=line4-i+1 ; s++  ){
		output += '*'
	}
	//3.
	output += '\n'
} // for e 
console.log( output )

/*
	만약에 줄수가 3을 입력했으면 line4=3
	i=1일때
	
		b=1일때		b<=i-1			1<=1-1			f
		s=1일때		s<=line4-i+1	1<=3-1+1		t	output='*'
		s=2일때		s<=line4-i+1	2<=3-1+1		t	output='**'
		s=3일때		s<=line4-i+1	2<=3-1+1		t	output='***'
		
		output += '\n'									output='***\n'
		
	i=2일때
	
		b=1일때		b<=i-1			1<=2-1			t	output='***'\n ' 공백 하나 들어간다 
		b=2일때		b<=i-1			2<=2-1			f
		
		s=1일때		s<=line4-i+1	1<=3-2+1		t	output='***'\n '*'
		s=2일때		s<=line4-i+1	2<=3-2+1		t	output='***'\n '**'
		s=3일때		s<=line4-i+1	2<=3-2+1		f	
		
		output += '\n'									output='***'\n '**'\n'

		
	i=3일때
	
		b=1일때		b<=i-1			1<=3-1			t	output='***\n **\n '  
		b=2일때		b<=i-1			2<=3-1			t	output='***\n **\n  '  
		b=3일때		b<=i-1			3<=3-1			f
		
		s=1일때		s<=line4-i+1	1<=3-3+1		t	output='***\n **\n  *'
		s=2일때		s<=line4-i+1	2<=3-3+1		f	output=
		
		output += '\n'									output='***\n **\n  *\n'

*/

/*
5.입력받은 줄수 만큼 출력 예시)5
					i		b왼쪽공백			s별
	 *		       i=1  	b=1234		s=1
	***			   i=2  	b=123		s=123
   *****		   i=3  	b=12		s=12345
  *******		   i=4  	b=1			s=1234567
 *********		   i=5  	b=			s=123456789

즉 i는 1부터 입력받은 줄수 까지 1씩증가 		=for(let i=1;i<=line5;i++)
b는 1부터(입력받은줄수-현재줄수)까지 1씩 증가   =for(let b=1;b<=line5-i;i++)
s는 1부터(현재줄수*2-1)					=for(let s=1;s<=i*2-1;s++)
						1부터 i까지	1부터 i*2까지		i부터	 i*2-1까지
						1부터 1까지	1부터	 2까지		1부터 1까지
						1부터 2까지	1부터 4까지		1부터 3까지
						1부터 3까지	1부터 6까지		1부터 5까지
						1부터 4까지	1부터 8까지 		1부터 7까지
						1부터 5까지	1부터 10까지		1부터 9까지


*/
output=''
let line5=Number(prompt('과제 5 줄수:'))
for(let i=1;i<line5;i++){
	//1.공백
	for(let b=1;b<=line5-i;b++){
		output+=' '
	}
	for(let s=1;s<=i*2-1;s++){
		output+='*'
	}
	output+='\n'
}
	console.log(output)


output=''
let line6=Number(prompt('과제 8 줄수:'))
for(let i=1;i<=line6;i++){
	//1.공백
	for(let b=1;b<=line6-i;b++){       
		output+=' '
	}
	for(let s=1;s<=i*2-1;s++){     
		output+='*'
	}
	output+='\n'
}



for(let i=1;i<=line6;i++){             
	//1.공백
	for(let b=1;b<=i-1;b++){        
		output+=' '
	}
	for(let s=1;s<=(line6-i)*2+1;s++){		   
		output+='*'
	}
	output+='\n'
}

console.log(output)

/*
					i		b왼쪽공백			s별
 *********	 	   i=1  	b=0	  			s=123456789 
  *******		   i=2  	b=1				s=1234567
   *****		   i=3  	b=12			s=12345
    ***		       i=4  	b=123			s=123
     *		       i=5  	b=1234			s=1

즉 i는 1부터 입력받은 줄수 까지 1씩증가 		=for(let i=1;i<=line5;i++)
b는 1부터(입력받은줄수+현재줄수)까지 1씩 감소   =for(let b=1;b<=i-1;i++)
s는 1부터(현재줄수-i*2+1)					=for(let s=1;s<=(line6-i)*2+1;s++)*/
															

