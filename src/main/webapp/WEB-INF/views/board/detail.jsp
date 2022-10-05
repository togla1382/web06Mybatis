<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>디데일페이지</h1>
	<ul>
		<li>
			<span>글번호</span>
			<span>${detail.bno }</span>
		</li>
		
		<li>
			<span>작성자</span>
			<span>${detail.writer }</span>
		</li>
		<li>
			<span>조회수</span>
			<span>${detail.readCount }</span>
		</li>
		<li>
			<span>최초작성일</span>
			<span>${detail.createdDate }</span>
			<span>최종수정일</span>
			<span>${detail.updatedDate }</span>
		</li>
		<li>
			<span>제목</span>
			<span>${detail.title }</span>
		</li>
		<li>
			<span>내용</span>
			<div>${detail.content }</div>
		</li>
	</ul>
</body>
</html>