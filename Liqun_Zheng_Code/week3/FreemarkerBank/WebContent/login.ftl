<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Bank App Login</title>
<link
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">

<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>

<body>

	<form name="loginform" action="login" method="POST">

		<div class="container">
			<div class="row">
				<div class="col-md-offset-5 col-md-3">
					<div class="form-login">
						
						<h4>Welcome to Revature Bank</h4>
						<input type="text" id="userName"
							class="form-control input-sm chat-input" placeholder="username" name = "username"/>
						</br> <input type="text" id="userPassword"
							class="form-control input-sm chat-input" placeholder="password" name = "password"/>
						</br>
							<button class="btn btn-lg btn-primary" type="submit">Login</button>
					</div>

				</div>
			</div>
		</div>

	</form>

<#if login=="fail">

<h3 style="color:red"> Your login information is incorrect <h3>
</#if>

</body>
</html>