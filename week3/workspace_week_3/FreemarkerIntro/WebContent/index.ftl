<html>

<head>
	<title>Intro to Freemarker!</title>
</head>
<body>

	<form name="user" action="hello" method="post">
	firstname: <input type="text" name="firstname" /> <br>
	lastname: <input type="text" name="lastname" /> <br>
	<input type="submit" value="Save" />
	</form>
	
	<table class="datatable">
		<tr>
		<th>firstname</th>
		<th>lastname</th>
		</tr>
		</tr>
		<#list users as user>
			<tr>
				<td>${user.firstname}</td><td>${user.lastname}</td>
			</tr>
		</#list>
	</table>

</body>

</html>