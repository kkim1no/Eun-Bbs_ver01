<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Han's read</title>
</head>
<body>
<h1>읽기 페이지 입니다.........</h1>

<div id=bbs>
<ul>
<li>번호: ${bbs.bno}</li>
<li>제목: ${bbs.title}</li>
<li>내용: ${bbs.cont}</li>
<li>게시일: ${bbs.regdate}</li>
<li>조회수: ${bbs.vcount}</li>
<li>댓글수: ${bbs.rcount}</li>
<li>첨부파일: ${bbs.contfile}</li>
</ul>
</div>


<a href="list">목록으로 돌아가기</a>

<form action ="delete">
<input type="hidden" name="bno" value="${bbs.bno}">
<input id="delete_btn" type="submit" value=Delete ></a>
</form>

<form action ="modify">
<input type="hidden" name="bno" value="${bbs.bno}">
<input id="modify_btn" type="submit" value=Modify ></a>
</form>

</body>
</html>