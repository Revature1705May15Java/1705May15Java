<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<style>
.button {
  display: inline-block;
  padding: 10px 50px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: 00004d;
  border: none;
  border-radius: 20px;
  -webkit-user-select:none;
  -moz-user-select:none;
  -ms-user-select:none;
  user-select:none;
}

.button:hover {background-color: #000033;}

.button:active {
  background-color: #000033;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
  
  
}

table {
    border-collapse: collapse;
    background-color: #afaeae;
    border: 1px solid black;
    margin: 5%;
}

th,td 
{
	padding-bottom: 15px;
	padding-left: 10px;
}


</style>

</head>
<body>

<table>

<tr style = "background-color:00004d; border: 1px solid black;"><td style = "padding-bottom: 5px;"><h5 style = "color:white">Login<h5><td></tr>


<form name = "loginform" action="login" method="post">
<tr>
<td></td> <td style = "padding-right: 30px"></td>
</tr>

<tr>
<td>Username </td> <td style = "padding-right: 30px"><input type = "text" name = "username" required = required/></td>
</tr>

<tr>
<td>Password</td> <td style = "padding-right: 30px"><input type = "password" name = "password" required = required/></td>
</tr>

<tr>
<td></td> <td style = "padding-right: 30px"><button class = "button" type="submit"> Login </button></td>
</tr>
</form>

<tr>
<td style = "padding-left: 0px"></td>
<td style = "padding-left: 0px"><#if login! == "fail">
<h5 style="color:red"> Your login information is incorrect</h5>
</#if></td>
</tr>

</table>




</body>
</head>