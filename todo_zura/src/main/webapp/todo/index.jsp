<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<!-- BootStrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>index</title>
</head>

<body>

	<!-- ヘッダー -->
	<%@ include file="/todo/header.jsp"%>


	<!-- 本文  -->
	<div class="bg-body-tertiary">
		<div class="container py-2 mt-2">
		
			<!-- 完了表示 -->
			<c:if test="${success}">
				<div class="alert alert-success alert-dismissible fade show mt-4" role="alert">
					<h3>完了しました！</h3>
					<ul><li>${successMsg}</li></ul>
					<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
			<!-- session = false -->
			<%
    			session.removeAttribute("success");
    			session.removeAttribute("successMsg");
  			%>
			
			<!-- リスト表示 -->
			<table class="table table-light">
				
				<!-- カラム設定 -->
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">題名</th>
						<th scope="col">重要度</th>
						<th scope="col">期限</th>
					</tr>
				</thead>
				
				<!-- レコード表示 -->
				<tbody>
					<c:forEach var="form" items="${list}" varStatus="status">
						<tr>
							<th scope="row">${status.count}</th>
							<td>
								<a href="UpdateServlet?index=${status.count}&title=${form.title}&priority=${form.priority}&limit=${form.limit}">${form.title}</a>
							</td>
							<td>${form.priority}</td>
							<td>${form.limit}</td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>

			<!-- 追加ボタン -->
			<a href="EntryServlet" class="btn btn-primary">追加</a>
		</div>
	</div>

	<!-- BootStrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>

</html>