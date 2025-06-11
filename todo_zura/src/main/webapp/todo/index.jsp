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
	<%@ include file="/todo/header.jsp" %>

	<div class="bg-body-tertiary">
		<div class="container py-2 mt-2">
			<!-- 完了表示 -->
			<div class="alert alert-success alert-dismissible fade show mt-4"
				role="alert">
				<h3>完了しました！</h3>
				<ul>
					<li>No.27のToDoを更新しました。</li>
				</ul>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<!-- エラー表示 -->
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<h3>エラーが発生しました！</h3>
				<ul>
					<li>題名は必須入力です。</li>
					<li>題名は100文字以内にしてください。</li>
					<li>期限は「YYYY/MM/DD」形式で入力してください。</li>
				</ul>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<!-- リスト表示 -->
			<table class="table table-light">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">題名</th>
						<th scope="col">重要度</th>
						<th scope="col">期限</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td class="text-primary"><a href="UpdateServlet">テストテキスト</a></td>
						<td>★★</td>
						<td>2015/06/20</td>
					</tr>
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