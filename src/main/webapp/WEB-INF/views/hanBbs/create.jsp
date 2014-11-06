<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>Create page</h1>
<P>  The time on the server is ${serverTime}. </P>

<form action ="insert"> <!-- 등록 후 insert로 넘어감 -->

<div calss="Create">
Title<input name="title" type ="text">
Userid<input name="userid" type ="text">
Cont<input name="cont" type ="text">
Contfile<input name="contfile" type ="text">

<input id="search_btn" type="submit" value="등록">
</div>

</form>

</body>
</html>