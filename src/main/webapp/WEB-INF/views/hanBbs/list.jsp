<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>

<!-- c(for문 등)태그를 쓰기위해 아래와 같이 선언해 주어야 합니다. -->    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- JavaScript 선언문 -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

<title>Insert title here</title>
</head>
<body>

List 보여주는 페이지입니다. 
<div id ="list">
	<ul>
		<c:forEach items="${list}" var="list">
			<li>${list.bno} : ${list.title}</li>
		</c:forEach>
	</ul>
</div>	


<!-- 페이징 처리 -->
<div id ="paging">

<c:choose>
<c:when test="${paging.preNum}"></c:when>
<c:otherwise>
<a href="listPage?page=${paging.preNum}" >이전</a>
</c:otherwise>
</c:choose>

<c:forEach var="i" begin="${paging.first}" end="${paging.last}">
 <a href="listPage?page=${i}" >${i}</a>
</c:forEach>

<c:choose>
<c:when test="${paging.nextNum}"></c:when>
<c:otherwise>
<a href="listPage?page=${paging.nextNum}" >다음</a>
</c:otherwise>
</c:choose>

</div>


<form action ="create"> <!-- submit 하면 create로 넘어감 -->
<input id="careate_btn" type="submit", value="Create">
</form>

</body>
</html>