<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="c" uri="jakarta.tags.core"%>
	<!-- 
	データベースに登録されているユーザ
		ユーザid:test1 パスワード:testtest
		ユーザid:test2 パスワード:testtest
		ユーザid:test3 パスワード:testtest
		ユーザid:test4 パスワード:test4test4	
	 -->
	<div class="container">
		<h1>ログイン画面</h1>
		<c:if test="${not empty sessionScope.message}">
			<p>${sessionScope.message}</p>
			<c:remove var="message" scope="session" />
		</c:if>

		<form action="login-trial" method="post">
			<div>
				<p>ユーザーID</p>
				<input type="text" name="user_id"
					value="${empty userId ? '' : userId}" required>

			</div>
			<p>パスワード</p>
			<input type="password" id="password" name="password" required>
			<input type="checkbox" id="togglePassword">パスワードを表示

			<p>
				<input type="submit" value="ログイン">
			</p>
		</form>
		<a href="registration.jsp">会員登録が済んでいない人はこちら</a>

	</div>
	<script src="../js/script.js"></script>
</body>
</html>