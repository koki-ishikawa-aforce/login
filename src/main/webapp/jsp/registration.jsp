<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function validateForm() {
		let password = document.getElementById("password").value;
		let confirmPassword = document.getElementById("confirmPassword").value;

		if (password !== confirmPassword) {
			alert("パスワードが一致しません。もう一度入力してください。")
			return false;
		}
		return true
	}
</script>
</head>
<body>
	<%@taglib prefix="c" uri="jakarta.tags.core"%>
	<div class="container">
		<h1>新規会員登録</h1>
		<c:if test="${not empty registerMessage}">
			<p>${registerMessage}</p>
		</c:if>
		<p>下記項目を入力してください。</p>
		<form action="registration" method="post"
			onsubmit="return validateForm()">
			<p>ユーザーID(半角英数)</p>
			<p>
				<input type="text" name="user_id" pattern="^[a-zA-Z0-9]+$" required>
			</p>
			<p>パスワード(半角英数8-16文字)</p>
			<p>
				<input type="text" id="password" name="password" minlength="8"
					maxlength="16" pattern="^[a-zA-Z0-9]+$" required>
			</p>
			<p>確認のためもう一度パスワードを入力</p>
			<p>
				<input type="text" id="confirmPassword" name="password" required>
			</p>
			<p>
				<input type="submit" value="登録">
			</p>
		</form>
	</div>
</body>
</html>