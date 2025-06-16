<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>

<html lang="ja">

<head>
	<c:set var="pageTitle" value="ログイン" />
	<c:set var="pageLink" value="LoginServlet" />
	
	<%@ include file="/WEB-INF/jspf/include/header.jspf"%>
</head>

<body class="bg-light">
	<%@ include file="/WEB-INF/jspf/include/signForm.jspf" %>
	
	<!-- スクリプト読み込み -->
	<%@ include file="/WEB-INF/jspf/include/readScript.jspf" %>
</body>

</html>