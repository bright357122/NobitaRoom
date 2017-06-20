<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>知識王解析</title>
	<style>
		body {font-family: '微軟正黑體', '標楷體';}
		h3 {color: darkred;}
	</style>
</head>
<body>
	<%
	String correct = (String)request.getAttribute("correct");
	if (correct.equals("yes")) {
	%>
	<h3>恭喜！您答對了！</h3>
	<%
	} else {
	%>
	<h3>抱歉，您答錯了！<br>正確解答是 <%= (String)request.getAttribute("answer")%> 。</h3>
	<%
	}
	%>
	<form  method="get" action="Quiz.do">
		<input type="submit" value="下一題">
	</form>
</body>
</html>