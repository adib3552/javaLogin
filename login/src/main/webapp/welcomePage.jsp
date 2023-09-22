<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<script>
    // Disable the back button on the browser
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
</script>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		login.User user=(login.User)session.getAttribute("user");
		out.println("Welcome"+user.getName());
		out.println(user.getEmail());
	%>
	<br>
	<a href="loginpage.html"><button>Logout</button></a>
</body>
</html>