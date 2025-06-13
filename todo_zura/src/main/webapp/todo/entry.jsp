<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<c:set var="pageTitle" value="登録" />
	<%@ include file="/WEB-INF/jspf/include/header.jspf" %>
</head>

<body>

	<!-- ヘッダー -->
	<%@ include file="/WEB-INF/jspf/include/nav.jspf" %>
	
	
	<!-- 本文 -->
	<div class="bg-body-tertiary">
		<div class="container py-2 bg-body-tertiary">
		
			<!-- エラー表示 -->
			<%@include file="/WEB-INF/jspf/include/alertError.jspf"%>
		
			<!-- フォームタイトル -->
			<%@ include file="/WEB-INF/jspf/include/formTitle.jspf" %>
			
			<!-- フォーム入力画面 -->
			<div class="row">
				<div class="offset-1 col-sm-11">
					<form method="post" action="EntryServlet">
					
						<!-- 入力フォーム -->
						<%@ include file="/WEB-INF/jspf/include/formFeilds.jspf" %>
						
						<!-- ボタン -->
						<div class="d-flex gap-2 offset-1 col-sm-11">
							<a href="IndexServlet" class="btn border" style="background-color: white;">キャンセル</a>
							<button type="submit" class="btn btn-primary">追加</button>
						</div>
					</form>
				</div>
			</div>
			
			<!-- スクリプト読み込み -->
			<%@ include file="/WEB-INF/jspf/include/script.jspf" %>
			
		</div>
	</div>
	
</body>

</html>