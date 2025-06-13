<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<c:set var="title" value="登録ページ" />
	<%@ include file="/WEB-INF/jspf/include/header.jspf" %>
</head>

<body>

	<!-- ヘッダー -->
	<%@ include file="/WEB-INF/jspf/include/nav.jspf" %>

	<!-- フォーム入力画面 -->
	<c:set var="mode" value="entry" />
	<%@include file="/todo/form.jsp"%>
	
	<!-- スクリプト読み込み -->
	<%@ include file="/WEB-INFO/jspf/include/script.jspf" %>

</body>

</html>