<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- エラー表示 -->
<c:if test="${error}">
	<div class="alert alert-danger alert-dismissible fade show" role="alert">
		<h3>エラーが発生しました！</h3>
		<ul>
			<c:forEach var="errorMsg" items="${errorAry}">
				<li>${errorMsg}</li>
			</c:forEach>
		</ul>
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>

<!-- session = false -->
<%
session.removeAttribute("error");
session.removeAttribute("errorAry");
%>