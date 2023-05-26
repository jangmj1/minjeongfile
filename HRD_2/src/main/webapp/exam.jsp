<%@page import="java.text.DecimalFormat"%>
<%@page import="controller.Dto"%>
<%@page import="java.util.List"%>
<%@page import="controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<center>
		<h3>학생성적</h3>
		<table border="1" style="border-collapse: collapse; text-align: center; width: 700px;">
			<tr>
				<th>학년</th><th>반</th><th>번호</th>
				<th>이름</th><th>국어</th><th>수학</th>
				<th>영어</th><th>역사</th><th>합계</th>
				<th>평균</th><th>순위</th>
			</tr>
			
			<%
			Dao dao=new Dao();
			List<Dto>list=dao.getExamList();
			
			int[] sumarray={0,0,0,0,0,0};
			double count=0;
			
			for(int i=0;i<list.size();i++){
				Dto dto=list.get(i);
				sumarray[0]+= dto.getEkor();
				sumarray[1]+= dto.getEmath();
				sumarray[2]+= dto.getEeng();
				sumarray[3]+= dto.getEhist();
				sumarray[4]+= dto.getSum();
				sumarray[5]+= dto.getAvg();
				
				if(dto.getEkor()!=0)count++;
				if(dto.getEkor()!=0){%>
					<tr>
					<td><%=dto.getSno1() %></td><td><%=dto.getSno2() %></td><td><%=dto.getSno3() %></td>
					<td><%=dto.getSname() %></td><td><%=dto.getEkor() %></td><td><%=dto.getEmath() %></td>
					<td><%=dto.getEeng() %></td><td><%=dto.getEhist() %></td><td><%=dto.getSum() %></td>
					<td><%=dto.getAvg() %></td><td><%=dto.getRank() %></td>
				</tr>
					
				<%}else{%>
					<tr>
					<td><%=dto.getSno1() %></td><td><%=dto.getSno2() %></td><td><%=dto.getSno3() %></td>
					<td><%=dto.getSname() %></td><td></td><td></td><td></td><td></td>
					<td></td><td></td><td></td>
				</tr>
				<%}
				%>
			<%
			}
			 %>
			
			<tr>
				<td colspan="4">총 합</td>
					
				<%for(int i=0;i<6;i++){ %>
					<td><%=sumarray[i] %></td>
					
				<%}%>
				<td></td>
				
			</tr>
			
			<tr >
				<% DecimalFormat df=new DecimalFormat("#.#"); %>
				<td colspan="4">총평합</td>
				<%for(int i=0;i<6;i++){ %>
					<td><%=df.format(sumarray[i]/count) %></td>
					
				<%}%>
				<td></td>
			</tr>
			
		</table>
	</center>
	<%@ include file="footer.jsp" %>
</body>
</html>