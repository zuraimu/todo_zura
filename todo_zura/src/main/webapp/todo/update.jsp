<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<!-- BootStrap  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>update</title>
</head>

<body>
	<!-- ヘッダー -->
	<%@ include file="/todo/header.jsp" %>

	<!-- 本文 -->
	<div class="bg-body-tertiary">
		<div class="container py-2">
			<!-- 完了表示 -->
			<div class="alert alert-success alert-dismissible fade show mt-2 p-2"
				role="alert">
				<h3>完了しました！</h3>
				<ul>
					<li>No.27のToDoを更新しました。</li>
				</ul>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<!-- エラー表示 -->
			<div class="alert alert-danger alert-dismissible fade show mt-2 p-2"
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

			<!-- 更新フォーム -->
			<h5 class="mb-0">更新フォーム</h5>
			<hr class="mt-0">
			<div class="row">
				<div class="offset-1 col-sm-11">
					<form class="ms-5">

						<!-- 題名  -->
						<div class="row mb-3">
							<label for="inputEmail3" class="col-sm-1 col-form-label text-end">題名</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" id="inputEmail3"
									placeholder="題名">
							</div>
						</div>

						<!-- 詳細 -->
						<div class="row mb-3">
							<label for="inputPassword3"
								class="col-sm-1 col-form-label text-end">詳細</label>
							<div class="col-sm-11">
								<textarea rows="3" class="form-control" id="inputPassword3"
									placeholder="詳細"></textarea>
							</div>
						</div>

						<!-- 重要度 -->
						<fieldset class="row mb-3">
							<legend class="col-form-label col-sm-1 pt-0 text-end">重要度</legend>
							<div class="col-sm-10">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gridRadios"
										id="gridRadios1" value="option1" checked> <label
										class="form-check-label" for="gridRadios1"> ★★★ </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gridRadios"
										id="gridRadios2" value="option2"> <label
										class="form-check-label" for="gridRadios2"> ★★ </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gridRadios"
										id="gridRadios3" value="option3"> <label
										class="form-check-label" for="gridRadios3"> ★ </label>
								</div>
							</div>

							<!-- 期限 -->
						</fieldset>
						<div class="row mb-3">
							<label for="inputEmail6" class="col-sm-1 col-form-label text-end">期限</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" id="inputEmail6"
									placeholder="期限">
							</div>
						</div>

						<!-- キャンセル・追加 -->
						<div class="d-flex gap-2 offset-1 col-sm-11">
							<button type="submit" class="btn border"
								style="background-color: white;">キャンセル</button>
							<button type="submit" class="btn btn-primary">更新</button>
							<div class="ms-auto">
								<button class="btn btn-danger">削除</button>
							</div>
						</div>


					</form>
				</div>
			</div>

		</div>

	</div>


</body>

</html>