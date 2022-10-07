<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		#pw2, #btn2{display: none;}
	</style>
	<script type="text/javascript">
	function ready(){
		document.getElementById("btnDelete").addEventListener("click", btnDeleteClicked);
	}
	function btnDeleteClicked(){
		var check=confirm("정말로 회원탈퇴 하실래요?");//확인:true, 취소:false
		if(check){
			console.log("확인을 눌렀네요");
			location.href="delete"; //<a href="delete" /> 와 동일
		}
	}
	function btnPwEditClicked(){
		document.getElementById("pw1").style.display="none";
		document.getElementById("pw2").style.display="block";
		document.getElementById("btn1").style.display="none";
		document.getElementById("btn2").style.display="block";
	}
	function btnPwCancelClicked(){
		document.getElementById("pw1").style.display="block";
		document.getElementById("pw2").style.display="none";
		document.getElementById("btn1").style.display="block";
		document.getElementById("btn2").style.display="none";
	}
	function btnPwChangeClicked(){
		if(!nullCheck())return;//종료
		
		var form=document.getElementById("userForm");
		form.setAttribute("action", "update");
		
		form.submit(); //onsubmit 사용불가
		
	}
	function nullCheck(){
		var newPass=document.getElementById("newPass").value;
		if(newPass==""){
			alert("비밀번호가 입력되지 않았어요");
			return false;
		}
		return true;
	}
	</script>
</head>
<body onload="ready()">
	<a href="${root }">HOME</a>
	<hr>
	<h1>회원 상세페이지</h1>
	<hr>
	<form id="userForm"  method="post" >
		<table>
	
			<tr>
				<td>회원번호</td>
				<td>${requestScope.detail.mno }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${detail.email }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${detail.name }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<div id="pw1">&bull;&bull;&bull;&bull;</div>
					<div id="pw2">
						<input type="password" name="newPass" id="newPass"  placeholder="new Password">
					</div>
				</td>
			</tr>
			<tr>
				<td>가입일</td>
				<td>${detail.createdDate.toLocalDate() }</td>
			</tr>
			<tr>
				<td>최근정보수정일</td>
				<td>${detail.updatedDate.toLocalDate() }</td>
			</tr>
			<tr>
				<td colspan="2">
					
					<div id="btn1">
						<button type="button" onclick="btnPwEditClicked()">비밀번호수정</button>
						<button type="button" id="btnDelete">탈퇴</button>
						
					</div>
					<div id="btn2">
						<button type="button" onclick="btnPwChangeClicked()">비밀번호수정 완료</button>
						<button type="button" onclick="btnPwCancelClicked()">취소</button>
					</div>
				</td>
				
			</tr>
		</table>
	</form>
</body>

</html>