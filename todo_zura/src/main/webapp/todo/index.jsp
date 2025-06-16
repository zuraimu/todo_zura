<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<c:set var="pageTitle" value="ホームページ" />
	<%@ include file="/WEB-INF/jspf/include/header.jspf" %>
</head>

<body>

	<!-- ヘッダー -->
	<%@ include file="/WEB-INF/jspf/include/nav.jspf" %>

	<!-- 本文  -->
	<div class="bg-body-tertiary">
		<div class="container py-2 mt-2">
		
			<!-- 完了表示 -->
			<%@ include file="/WEB-INF/jspf/include/success.jspf" %>
			
			<!-- リスト表示 -->
			<%@ include file="/WEB-INF/jspf/include/list.jspf" %>

			<!-- 追加フォーム遷移 -->
			<a href="EntryServlet" class="btn btn-primary">追加</a>
			
		</div>
	</div>
	
	<!-- スクリプト読み込み -->
	<%@ include file="/WEB-INF/jspf/include/script.jspf" %>
	
</body>

</html>