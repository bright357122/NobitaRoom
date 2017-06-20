<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="ntou.cs.wbse.Quiz, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>知識王</title>
	<style>
		body {font-family: '微軟正黑體', '標楷體';}
		h3 {color: darkblue;}
	</style>
</head>
<body>
	<% Quiz quiz = (Quiz)request.getAttribute("quiz");%>
	
	<form method="post" action="Solution.do">
		<input type="hidden" name="id" value="<%= quiz.getId() %>">
		<h3> 問題 <%= (int)request.getAttribute("quizNumber") %>: </h3>
		<h3> <%= quiz.getQuestion() %> </h3> <p>
		<%
		ArrayList<String> options = quiz.getOptions();
		for (int i=1; i<options.size()+1; i++) { 
		%>
			<input type="radio" name="ans" value="<%= i %>">
			[<%= i %>] <%= options.get(i-1) %> 
			<br>
		<% 
		}
		%>
		</p>
		<input type="submit" value="提交">
	</form>
</body>
</html>