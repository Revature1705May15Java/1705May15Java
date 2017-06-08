<!DOCTYPE html>
<html>
<head>
	<title>Manager Home</title>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<form name="viewAll" action="viewEmployees" method="POST" id="form1"></form>
	<form name="registerNew" action="register" method="GET" id="form2"></form>
	<form name="viewPending" action="viewPending" method="GET" id="form3"></form>
	
	<button type="submit" formmethod="POST" formaction="">Logout</button>
	<button type="submit" form="form3">View Pending Requests</button>
	<button type="submit" formmethod="POST" formaction="">View Resolved Requests</button>
	<button type="submit" formmethod="POST" formaction="">View All Requests</button>
	<button type="submit" form="form1">View All Employees</button>
	<button type="submit" form="form2">Register Employee</button>
</body>
</html>