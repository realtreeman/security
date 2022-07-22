<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jspf" %>

<div class="container">
	<sec:authentication property="principal.memberVO.userId" var="userId"/>
	<h2>회원 페이지</h2>
	<a href="${contextPath}/customLogout" class="btn btn-primary">로그아웃하러 가자</a>
	<a href="${contextPath}/anno/myPage/${userId}" class="btn btn-primary">마이페이지</a>
</div>
<%@ include file="../layout/footer.jspf" %>

