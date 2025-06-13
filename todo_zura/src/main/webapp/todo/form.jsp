<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<!-- ※
		
		id, title, priority, limit
		が渡されているかどうかで動作が異なります。
	
	 ※　-->
	
	
<!-- ヘッダー -->
<%@include file="/todo/header.jsp"%>

<!-- 本文 -->
<div class="bg-body-tertiary">
	<div class="container py-2">
	
		<!-- エラー表示 -->
		<%@include file="/todo/alertError.jsp"%>
	
		<!-- 更新フォーム -->
		<c:choose>
			<c:when test='${mode eq "update"}'>
				<h5 class="mb-0">更新フォーム</h5>
			</c:when>
			<c:otherwise>
				<h5 class="mb-0">登録フォーム</h5>
			</c:otherwise>
		</c:choose>
		
		<hr class="mt-0">
		
		<!-- フォーム -->
		<div class="row">
			<div class="offset-1 col-sm-11">
				<form method="post" 
						action="<c:choose>
									<c:when test='${mode eq "update"}'>UpdateServlet</c:when>
									<c:otherwise>EntryServlet</c:otherwise>
								</c:choose>">
				
					<!-- 題名  -->
					<div class="row mb-3">
						<label for="title" class="col-sm-1 col-form-label text-end">題名</label>
						<div class="col-sm-11">
							<input type="text" class="form-control" name="title" id="title" placeholder="題名" value="${empty title ? '' : title }">
						</div>
					</div>
					
					<!-- 詳細 -->
					<div class="row mb-3">
						<label for="inputPassword3" class="col-sm-1 col-form-label text-end">詳細</label>
						<div class="col-sm-11">
							<textarea rows="3" class="form-control" id="inputPassword3" placeholder="詳細"></textarea>
						</div>
					</div>
					
					<!-- 重要度 -->
					<fieldset class="row mb-3">
						<legend class="col-form-label col-sm-1 pt-0 text-end">重要度</legend>
						<div class="col-sm-10">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="priority" id="pr1" value="★★★" ${priority eq '★★★' ? 'checked' : ''}>
								<label class="form-check-label" for="pr1"> ★★★ </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="priority" id="pr2" value="★★" ${priority eq '★★' ? 'checked' : ''}>
								<label class="form-check-label" for="pr2"> ★★ </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="priority" id="pr3" value="★" ${priority eq '★' ? 'checked' : ''}> 
								<label class="form-check-label" for="pr3"> ★ </label>
							</div>
						</div>
					</fieldset>
					
					<!-- 期限  -->
					<div class="row mb-3">
						<label for="limit" class="col-sm-1 col-form-label text-end">期限</label>
						<div class="col-sm-11">
							<input type="text" class="form-control" name="limit" id="limit" placeholder="期限" value="${empty limit ? '' : limit}">
						</div>
					</div>
					
					<!-- ボタン -->
					<div class="d-flex gap-2 offset-1 col-sm-11">
					    <a href="IndexServlet" class="btn border" style="background-color: white;">キャンセル</a>
					
					    <c:choose>
					        <c:when test="${mode eq 'update'}">
					            <button type="submit" class="btn btn-primary">更新</button>
					            <div class="ms-auto">
					                <a href="DeleteServlet" class="btn border btn-danger">削除</a>
					            </div>
					        </c:when>
					        <c:when test="${mode eq 'entry'}">
					            <button type="submit" class="btn btn-primary">追加</button>
					        </c:when>
					    </c:choose>
					</div>
				</form>
		     </div>
		</div>
	</div>
</div>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>










