<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank App Login</title>
</head>

<body>
<h1>Welcome to Bank</h1>
<h2>Please Login</h2>

<form name = "loginform" action="login" method="post">
Username <input type = "text" name = "username"/>
<br>
Password <input type = "password" name = "password"/>
<br>
<input type="submit" value="login"/>
</form>

<#if login! == "fail">
<h3 style="color:red"> Your login information is incorrect</h3>
</#if>

</body>
</html>