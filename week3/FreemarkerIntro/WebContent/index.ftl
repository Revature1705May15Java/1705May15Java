<html>
<head>
<title>Banking with Freemarker</title>
</head>

<body>
<form name="user" action="hello" method="post">
Firstname: <input type="text" name="firstname" /> <br>
Lastname: <input type="text" name="lastname" /> <br>
<input type="submit" value="Save" />
</form>

<table class="datatable">
<tr>
<th>Username</th>
<th>Password</th>
</tr>

<#list users as user>
<tr>
<td>${user.firstname}</td> <td>${user.lastname}</td>
</tr>
</#list>
</table>

</body>
</html>