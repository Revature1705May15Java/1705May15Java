<html>
<head>
	<title>Login</title>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

</body>
	<div class="jumbotron">
		<#if noEmployee! == "true">
			<div class="alert alert-danger" role="alert">No such user exists.</div>
		<#elseif wrongPassword! == "true">
			<div class="alert alert-danger" role="alert">Invalid password.</div>
		</#if>
		<form method="POST" action="login">
			<div class="input_group">
			<table>
				<tr>
					<td>User Name:</td> 
					<td><input class="form-control" type="email" name="email" required></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td> <input class="form-control" type="password" name="password" required></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input class="btn btn-default" type="submit" value="Login"></td>
				</tr>
			</table>
			</div>
		</form>
	</div>
</html>