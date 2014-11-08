<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- using cTag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- using JavaScript -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

<title>Han's Bbs</title>
</head>
<body>

	<h1>List view Page</h1>

	<!-- new data -->
	<form action="create">
		<!-- submit 하면 create로 넘어감 -->
		<input id="careate_btn" type="submit" , value="Create">
	</form>
	<!-- end new data -->

	<!-- list -->
	<div id="list">
		<ul>
			<c:forEach items="${list}" var="list">
				<li>${list.bno}: ${list.title}: ${list.userid}</li>
			</c:forEach>
		</ul>
	</div>
	<!-- end list -->


	<!-- paging -->
	<div id="paging">

		<c:choose>
			<c:when test="${paging.preNum}"></c:when>
			<c:otherwise>
				<a href="listPage?page=${paging.preNum}">Prev</a>
			</c:otherwise>
		</c:choose>

		<c:forEach var="i" begin="${paging.first}" end="${paging.last}">
			<a href="listPage?page=${i}">${i}</a>
		</c:forEach>

		<c:choose>
			<c:when test="${paging.nextNum}"></c:when>
			<c:otherwise>
				<a href="listPage?page=${paging.nextNum}">Next</a>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- end paging -->

<!-- search -->
<div id = search>
<form action="listPage">

<input name="keyword" type ="text">
<input id="search_btn" type="submit" value="Search">

</form>
</div>
<!-- end search -->



</body>
</html>