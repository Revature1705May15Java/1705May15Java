
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Employee Home Page</title>

<!-- Bootstrap Core CSS -->
<link href="CSS/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="CSS/freelancer.min.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

</head>

<body id="page-top" class="index">
	<div id="skipnav">
		<a href="#maincontent">Skip to main content</a>
	</div>

	<!-- Navigation -->
	<nav id="mainNav"
		class="navbar navbar-default navbar-fixed-top navbar-custom" style="background-color:#2A3132;">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="#page-top">My Info</a>
				
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#updateInfo">Update My
							Information</a></li>
					<li class="page-scroll"><a href="#viewRequest">View Requests</a></li>
					<li class="page-scroll"><a href="#newRequest">Submit New
							Request</a></li>
					<li><form name="Logout" action="login" method="GET">
					<button type="submit" class="btn btn-success btn-lg">Log out</button>
					</form>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header>
		<div class="container" id="maincontent" tabindex="-1">
			<div class="row">
				<div class="col-lg-12">
						<#if update ??>
						<h3 style="color:red"> Your Update failed, because username already taken! <h3>
						</#if>
					<img class="img-responsive"
						src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/220px-User_icon_2.svg.png"
						alt="">
					<div class="intro-text">
						<h1 class="name">Welcome back Employee ${firstname}
							${lastname}</h1>

						<hr class="star-light">
						<h2>Username: ${uname}</h2>

					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Update information Section -->
	<section id="updateInfo">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Update My Info</h2>
					<hr class="star-primary">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
					<!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
					<form name="updateInfo" action="updateInfo" method="POST">
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="firstName">First Name</label> <input type="text"
									class="form-control" placeholder="First Name" name = "firstName"
									required
									data-validation-required-message="Please enter your first name.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="lastName">Last Name</label> <input type="text"
									class="form-control" placeholder="Last Name" name ="lastName"
									required
									data-validation-required-message="Please enter your last name.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="username">Username</label> <input type="text"
									class="form-control" placeholder="Username" name ="username"
									required
									data-validation-required-message="Please enter your Username.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="password">Password</label> <input type ="password"
									class="form-control" placeholder="Password" name = "password"
									required
									
									data-validation-required-message="Please enter your password."
									onchange="form.password1.pattern = this.value;">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="password">Confirm Password</label> <input type ="password"
									class="form-control" placeholder="Confirm Password" name = "password1"
									required
									
									data-validation-required-message="Please confirm your password.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<br>
						<div id="success"></div>
						<div class="row">
							<div class="form-group col-xs-12">
								<button type="submit" class="btn btn-success btn-lg">Update</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</section>

	<!-- My Requests Section -->
	<section class="success" id="viewRequest">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 style= "color: white;">My Requests</h2>
					<hr class="star-light">
				</div>
			</div>
			<table id = "req">
			<thead>
				<tr>
					<th>Request Id &nbsp;</th>

					<th>Resolver Id &nbsp;</th>
					<th>Note &nbsp;</th>
					<th>Purpose &nbsp;</th>
					<th>Amount &nbsp;</th>
					<th>Status &nbsp;</th>
					<th>Open Date &nbsp;</th>
					<th>Close Date</th>


				</tr>
			</thead>
			 <tbody>
				<#list requests as request>
				<tr>
					<td>&#9731 ${request.request_id} &nbsp;</td>

					<#if request.resolver_id??>
					<td>&#9731 ${request.resolver_id} &nbsp;</td>
					<#else>
					<td>&#9731 N/A &nbsp;</td>
					</#if> <#if request.note??>
					<td> ${request.note} &nbsp;</td>
					<#else>
					<td>N/A &nbsp;</td>
					</#if> <#if request.purpose??>
									<td>${request.purpose} &nbsp;</td>
									<#else>
									<td>N/A &nbsp;</td>
									</#if>
									<td>&dollar; ${request.amount} &nbsp;</td>
									<td> ${request.state.name} &nbsp;</td>
									<td> ${request.opened} &nbsp;</td>
									<#if request.closed??>
									<td> ${request.closed} &nbsp;</td>
									<#else>
									<td> N/A &nbsp;</td>
									</#if>

				</tr>
				</#list>
				 </tbody>
			</table>
		</div>
	</section>

	<!-- New Request Section -->
	<section id="newRequest">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Submit a new request</h2>
					<hr class="star-primary">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
					<!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
					<form name="newReq" action="newReq" method="POST">
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="purpose">Purpose</label> <input type="text"
									class="form-control" placeholder="Purpose" name="purpose">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="Amount">&dollar; Amount</label> <input type="number"
									min="0.01" step="0.01" max="9999999.99" class="form-control"
									placeholder="Amount" name="amount" required
									data-validation-required-message="Please enter the amount.">
								<p class="help-block text-danger"></p>
							</div>
						</div>

						<br>
						<div id="success"></div>
						<div class="row">
							<div class="form-group col-xs-12">
								<button type="submit" class="btn btn-success btn-lg">Submit</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="text-center">

		<div class="footer-below" style="background-color:#2A3132;">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">Copyright &copy; Liqun Zheng's Website 2017</div>
				</div>
			</div>
		</div>
	</footer>



	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	

	<!-- Theme JavaScript -->
	<script src="js/freelancer.min.js"></script>
	
	 <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <script>
  $(function(){
    $("#req").dataTable();
  })
  </script>

</body>

</html>