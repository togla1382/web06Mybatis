<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		li{list-style: none;}
		i{margin-right: 20px; color: rgb(0,0,255);}
		div{border:1px solid rgba(0,0,0, 0.2);}
		button:hover{cursor: pointer;}
		input:read-only {border: none;}
		input:read-only:focus{outline: none;}
		#fmt{display: none;}
	</style>
</head>

<body>
	<h1>디데일페이지</h1>
	<ul id="def">
		<li>
			<i>글번호</i>
			<span>${detail.bno }</span>
		</li>
		
		<li>
			<i>작성자</i>
			<span>${detail.writer }</span>
		</li>
		<li>
			<i>조회수</i>
			<span>${detail.readCount }</span>
		</li>
		<li>
			<i>최초작성일</i>
			<span>${detail.createdDate }</span>
			<i>최종수정일</i>
			<span>${detail.updatedDate }</span>
		</li>
		<li>
			<i>제목</i>
			<span>${detail.title }</span>
		</li>
		<li>
			<i>내용</i>
			<div>${detail.content }</div>
		</li>
		<li>
			<button type="button" onclick="btbEditClicked();">수정</button>
		</li>
	</ul>
	<!-- //////////////////////////////// -->
	<script type="text/javascript">
		function btbEditClicked(){
			//document.getElementsByTagName("ul");
			document.getElementById("def").style.display="none";
			document.getElementById("fmt").style.display="block";
		}
	</script>
	<!-- //////////////////////////////// -->
	<form id="fmt">
		<ul>
			<li>
				<i>글번호</i>
				<input type="text" value="${detail.bno }" readonly="readonly">
			</li>
			
			<li>
				<i>작성자</i>
				<span>${detail.writer }</span>
			</li>
			<li>
				<i>조회수</i>
				<span>${detail.readCount }</span>
			</li>
			<li>
				<i>최초작성일</i>
				<span>${detail.createdDate }</span>
				<i>최종수정일</i>
				<span>${detail.updatedDate }</span>
			</li>
			<li>
				<i>제목</i>
				<input type="text" value="${detail.title }">
			</li>
			<li>
				<i>내용</i>
				<textarea style="width: 100%; height: 5em;" >${detail.content }</textarea>
			</li>
			<li>
				<button type="button">취소</button>
			</li>
		</ul>
	</form>
</body>
</html>