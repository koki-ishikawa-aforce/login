<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>ようこそ、${sessionScope.userId }さん！</p>

<form action="logout" method="post">
    <input type="submit" value="ログアウト">
</form>
<a href="another.jsp">別ページへ</a>

</body>
</html>