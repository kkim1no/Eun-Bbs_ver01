<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- c(for��)�±׸� �������� �Ʒ��� ���� ������ �־�� �մϴ�. -->    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

List �����ִ� �������Դϴ�. 
<div id ="list">
	<ul>
		<c:forEach items="${list}" var="list">
			<li>${list.title}</li>
		</c:forEach>
	</ul>
</div>	


<!-- ����¡ ó�� -->
<div id ="pageing">

<a href="listPage?page=0" ><<</a>
<a href="listPage?page=1" >1</a>
<a href="listPage?page=2" >2</a>
<a href="listPage?page=3" >3</a>
<a href="listPage?page=4" >4</a>
<a href="listPage?page=5" >5</a>
<a href="listPage?page=6" >>></a>

</div>


<form action ="create"> <!-- submit �ϸ� create�� �Ѿ -->
<input id="careate_btn" type="submit", value="Create">
</form>

</body>
</html>