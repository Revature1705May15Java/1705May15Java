<html>
<head>
<title>Intro to Freemanrker</title>
<head>

<body>
<form name = "user" action="hello" method="post">
Fristname: <input type="text" name="firstname" /><br>
Lastname: <input type="text" name="lastname" /><br>
<input type="submit" value="Save" />
</from>
<table class="datatable">
<tr>
<th>Firstname</th>
<th>Lastname</th>
</tr>

<#list users as user>
<tr>
<td>${user.firstname}</td> <td>${user.lastname}</td>
</tr>
</#list>
</table>


</body>
</html>