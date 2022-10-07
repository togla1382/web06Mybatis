<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%
	Iterator<String> it=request.getParameterNames().asIterator();
	while(it.hasNext()){
		String paramName=it.next();
		System.out.println("파라미터 이름 : "+paramName);
		if(paramName.equals("logout")){
			pageContext.setAttribute("logerror", "장시간 사용하지 않아 자동 로그아웃 하였습니다. 로그인 후 이용하세요.");
		}else if(paramName.equals("retry")){
			pageContext.setAttribute("logerror", "비밀번호가 변경되었습니다. 로그인 후 이용하세요.");
		}
	}
%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	.error{color : #ff0000;color: rgb(255,0,0); color: rgba(255,0,0,1); color: red;}
	</style>
</head>
<body>
<%
	pageContext.getAttribute("name");/* ${pageScope.name} */
	request.getAttribute("name");    /* ${requestScope.name} */
	session.getAttribute("name");    /* ${sessionScope.name} */
	application.getAttribute("name");/* ${applicationScope.name} */
	/* ${name } */
%>
	<a href="${root }">HOME</a>
	<a href="${root }/signup">회원가입</a>	
	<hr>
	<h1>로그인</h1>
	<hr>
	
	<div class="error" >
		<!-- /signin?error -->
		<%-- 
		<div>header : ${header.Referer }</div>
		<div>쿠키정보 : ${cookie.JSESSIONID.value }</div>
		<div>Query String Parameter : ${param.opt }</div>
		<div>Query String Parameter : <%=request.getParameter("opt") %> </div>
		 --%>
		<c:if test="${param.opt eq 'error' }">
			로그인 실패!
		</c:if>
		<div>
			${logerror }
		</div>
	</div>
	<form action="member/login" method="post" onclick="">
		<p>
			<input type="text" name="email" placeholder="이메일">
		</p>
		<p>
			<input type="password" name="pass" placeholder="비밀번호">
		</p>
		<p>
			<button>로그인</button>
		</p>
	</form>

</body>
</html>