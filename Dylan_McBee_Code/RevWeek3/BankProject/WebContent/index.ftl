<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank App Login</title>
</head>
<body>
<h1>Welcome to Doggo Bank!</h1>
<h3>Please Log in</h3>

<form name="loginform" action="login" method="POST">
Username: <input type="text" name="userName"/><br>
Password: <input type="password" name="password"/><br>
<input type="submit" value="login"/>
</form>

<#if login! =="fail">
	<h3 style="color:red">Your login information is incorrect </h3>
	
</#if>

</body>
</html>