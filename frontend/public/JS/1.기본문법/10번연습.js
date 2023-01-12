output=''
let line6=Number(prompt('입력하세요'))

for(let i=1;i<=line6;i++){
	for(let d=1;d<=i-1;i++){
		output+=' '
	}
	for(let s=1;s<=(line6-i)*2+1;s++){
		output+='*'
	}
	output+='\n'
}
console.log(output)