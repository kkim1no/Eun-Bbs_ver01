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
	${erroeMessage}
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
			<c:when test="${maker.preNum}"></c:when>
			<c:otherwise>
				<a href="list?page=${maker.preNum}&keyword=${maker.keyword}">Prev</a>
			</c:otherwise>
		</c:choose>

		<c:forEach var="i" begin="${maker.first}" end="${maker.last}">
			<a href="list?page=${i}&keyword=${maker.keyword}">${i}</a>
		</c:forEach>

		<c:choose>
			<c:when test="${maker.nextNum}"></c:when>
			<c:otherwise>
				<a href="list?page=${maker.nextNum}&keyword=${maker.keyword}">Next</a>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- end paging -->
	<br>


<!-- search -->
<div id = search>
<form action="list">

<input name="keyword" type ="text" value=${maker.keyword}>
<input id="search_btn" type="submit" value="Search">

</form>
</div>
<!-- end search -->



</body>
</html>