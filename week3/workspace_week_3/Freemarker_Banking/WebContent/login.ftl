<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank App Login</title>
</head>
<body>

	<h1>Welcome to A+ Bank</h1>
	<h3>Please log in</h3>
	
	<form name="loginform" action="login" method="POST">
		Username: <input type="text" name="username" /><br> 
		Password: <input type="password" name="password" /><br>
		<input type="submit" value="login" />

	</form>
	
	<#if login! == "fail">
		<h3 style="color:red">Login username or password incorrect. Please try again.</h3>
	</#if>

</body>
</html>