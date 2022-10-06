<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<a href="<%=request.getContextPath() %>/board/list">게시글1</a>
	<a href="${root }/board/list">게시글2</a>
	<a href="board/list">게시글3</a>
	<c:if test="${empty logData }">
		<a href="${root }/signup">회원가입</a>
		<a href="${root }/signin">로그인</a>
	</c:if>
	<c:if test="${not empty logData }">
		<span>${logData.email }</span>
		<span>${logData.name }</span>
		<a href="${root }/signout">로그아웃</a>
	</c:if>
</div>
<div>
	<a href="<%=request.getContextPath() %>/board/list">게시글1</a>
	<a href="${root }/board/list">게시글2</a>
	<a href="board/list">게시글3</a>
	<c:choose>
		<c:when test="${empty logData }">
			<a href="${root }/signup">회원가입</a>
			<a href="${root }/signin">로그인</a>
		</c:when>
		<c:otherwise>
			<span>${logData.email }</span>
			<span>${logData.name }</span>
			<a href="${root }/signout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</div>

<h1>인덱스페이지</h1>

<div>
	세션 유지 시간 : <%=session.getMaxInactiveInterval() %>
</div>
<div>
	최초 요청 시간 : 
	<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="<%=new Date(session.getCreationTime()) %>"/>
	<%=session.getCreationTime() %>
</div>
<div>
	마지막 요청 시간 :
	<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="<%=new Date(session.getLastAccessedTime()) %>"/>
	<%=session.getLastAccessedTime() %>
</div>
<div>logData scope들중에서 존재하니? : ${!empty logData }</div>
<div>logData scope들중에서 비었냐? : ${empty logData }</div>
<div>sessionScope data : ${sessionScope.aaa }</div>
<div>sessionScope 생략 data : ${aaa }</div>
<div>requestScope data : ${requestScope.bbb }</div>
<div>requestScope 생략 data : ${bbb }</div>
</body>
</html>