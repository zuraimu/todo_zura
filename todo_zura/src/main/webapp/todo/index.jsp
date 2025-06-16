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
			<div class="row">
				<div class="col-lg-4">
					<!-- Priorityのカウントをしゅとくし、重要度の円グラフを作成 -->
					<%@ include file="/WEB-INF/jspf/include/getPriorityMap.jspf" %>
					<canvas id="chart" width="300" height="300" style="max-width: 100%;"></canvas>
				</div>
			
				<div class="col-lg-8">
					<!-- 完了表示 -->
					<%@ include file="/WEB-INF/jspf/include/success.jspf" %>
			
					<!-- リスト表示 -->
					<%@ include file="/WEB-INF/jspf/include/list.jspf" %>

					<!-- 追加フォーム遷移 -->
					<a href="EntryServlet" class="btn btn-primary">追加</a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- スクリプト読み込み -->
	<%@ include file="/WEB-INF/jspf/include/readScript.jspf" %>
	
</body>

</html>