
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Manager Home Page</title>

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
		class="navbar navbar-default navbar-fixed-top navbar-custom">
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
					<li class="page-scroll"><a href="#allEmployees">View All Employees</a></li>
					<li class="page-scroll"><a href="#allRequests">View All Requests</a></li>
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
						src="https://cdn2.iconfinder.com/data/icons/avatar1/131/Untitled-26-512.png"
						alt="">
					<div class="intro-text">
						<h1 class="name">Welcome back Manager ${firstname}
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
					<form name="updateManager" action="updateManager" method="POST">
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="firstName">First Name</label> <input type="text"
									class="form-control" placeholder="First Name" name="firstName"
									required
									data-validation-required-message="Please enter your first name.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="lastName">Last Name</label> <input type="text"
									class="form-control" placeholder="Last Name" name="lastName"
									required
									data-validation-required-message="Please enter your last name.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="username">Username</label> <input type="text"
									class="form-control" placeholder="Username" name="username"
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

	<!-- all Employees Section -->
	<section class="success" id="allEmployees">
		<div class="container">

					<div class="row">
				<div class="col-lg-12 text-center">
					<h2 style= "color: white;">All Employees</h2>
					<hr class="star-light">
				</div>
			</div>
			<table id = "emp">
			<thead>
				<tr>
					<th>Employee Id &nbsp;</th>
					<th>First Name &nbsp;</th>
					<th>Last Name &nbsp;</th>

				</tr>
			</thead>
			 <tbody>
				<#list employees as employee>
				<tr>
					<td> ${employee.employee_id} &nbsp;</td>
					<td> ${employee.fn} &nbsp;</td>
					<td> ${employee.ln} &nbsp;</td>

				</tr>
				</#list>
				 </tbody>
			</table>
		</div>
	</section>

	<!-- allRequests Section -->
	<section id="allRequests">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>All Requests</h2>
					<hr class="star-primary">
				</div>
			</div>
			<input type="hidden" name="hdnbt" />
			<table id = "req">
			<thead>
				<tr>
					<th>Request Id &nbsp;</th>
					<th>Requester Id &nbsp;</th>
					<th>Requester Name &nbsp;</th>
					<th>Resolver Id &nbsp;</th>
					<th>Note &nbsp;</th>
					<th>Purpose &nbsp;</th>
					<th>Amount &nbsp;</th>
					<th>Status &nbsp;</th>
					<th>Open Date &nbsp;</th>
					<th>Close Date</th>
					<th>Approve</th>
					<th>Deny</th>
				

				</tr>
			</thead>
			 <tbody>
				<#list requests as request>
				<tr>
					<td> ${request.request_id} &nbsp;</td>
					<th> ${request.requester_id} &nbsp;</th>
					<th> ${request.requester_name} &nbsp;</th>
					<#if request.resolver_id??>
					<td>${request.resolver_id} &nbsp;</td>
					<#else>
					<td> N/A &nbsp;</td>
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
									<td>${request.closed} &nbsp;</td>
									<#else>
									<td>N/A &nbsp;</td>
									</#if>
									<#if request.closed??>
									<td> </td>
									<#else>
									<td> <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#appReq${request.request_id}">Approve</button>
									<div class="modal fade" id="appReq${request.request_id}" role="dialog">
								    <div class="modal-dialog">
								    
								      <!-- Modal content-->
								      <div class="modal-content">
								     
								        <div class="modal-header">
								          
								          <h4>Are You Sure You Want To Approve This Request</h4>
								        </div>
								         <form name="managerApprove" action="managerApprove" method="POST">
								        <div class="modal-body">
								          	<p>Request Id: ${request.request_id}</p>
								          	<p>Requester Id: ${request.requester_id}</p>
								          	<p>Requester Name: ${request.requester_name}</p>
								          	<#if request.purpose??>
								          	<p>Purpose: ${request.purpose} </p>
											<#else>
											<p>Purpose: N/A &nbsp;</p>
											</#if>
											<p>Amount: &dollar;${request.amount}</p>
								    	  	<input type="hidden" name="approveId" value= "${request.request_id}" >
								    	  	<input type="text"
												class="form-control" placeholder="Note to requester: " id="lastName" name = "noteApprove"> 
								    	  
								        </div>
								        
								        
								        <div class="modal-footer">
								     
								        
										<button type="submit" class="btn btn-success btn-lg">Approve</button>
										
								          <button type="button" class="btn btn-success btn-lg" data-dismiss="modal">Cancel</button>
								        </div>
								        </form>
								      </div>
								      
								    </div>
								  </div>
								</td>
									
									</#if>
									
									<#if request.closed??>
									<td> </td>
									<#else>
									<td> <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#denyReq${request.request_id}">Deny</button>
									  <div class="modal fade" id="denyReq${request.request_id}" role="dialog">
								    <div class="modal-dialog">
								    
								      <!-- Modal content-->
								      <div class="modal-content">
								        <div class="modal-header">
								          
								          <h4>Are You Sure You Want To Deny This Request</h4>
								        </div>
								        <form name="managerDeny" action="managerDeny" method="POST">
								        <div class="modal-body">
								          	<p>Request Id: ${request.request_id}</p>
								          	<p>Requester Id: ${request.requester_id}</p>
								          	<p>Requester Name: ${request.requester_name}</p>
								          	<#if request.purpose??>
								          	<p>Purpose: ${request.purpose} </p>
											<#else>
											<p>Purpose: N/A &nbsp;</p>
											</#if>
											<p>Amount: &dollar;${request.amount}</p>
								    	  	<input type="hidden" name="denyId" value= "${request.request_id}" >
								    	  	<input type="text"
												class="form-control" placeholder="Note to requester: " name = "noteDeny"> 
								    	  
								        </div>
								        
								        
								        <div class="modal-footer">
								     
								        
										<button type="submit" class="btn btn-success btn-lg">Deny</button>
										
								          <button type="button" class="btn btn-success btn-lg" data-dismiss="modal">Cancel</button>
								        </div>
								       </form>
								      </div>
								    </div>
								  </div>
									
								</td>
								</#if>
				
				</tr>
				</#list>
				 </tbody>
			</table>
		</div>
	</section>


	


	<!-- Footer -->
	<footer class="text-center">
		<div class="footer-above">
			<div class="container">
				<div class="row">
					<div class="footer-col col-md-4">
						<h3>Location</h3>
						<p>Revature<p>
						<p>
							
							11730 Plaza America Dr #205, Reston, VA 20190
						</p>
					</div>
					<div class="footer-col col-md-4">
						<h3>In This Page</h3>
						<ul class="list-inline">
							<li><a href="#page-top" class="btn-social btn-outline"><span
									class="sr-only">Top Page</span></a>
							</li>
							<li><a href="#updateInfo" class="btn-social btn-outline"><span
									class="sr-only">Update Info</span><i
									class="fa fa-fw fa-google-plus"></i></a></li>
							<li><a href="#allEmployees" class="btn-social btn-outline"><span
									class="sr-only">All Employees</span></a>
							</li>
							<li><a href="#allRequests" class="btn-social btn-outline"><span
									class="sr-only">All Requests</span></a>
							</li>
						</ul>
					</div>
					<div class="footer-col col-md-4">
						<h3>About Reimbursement System</h3>
						<p>
							Employee can view/update their information, view/update their 
							requests. <a href="https://github.com/Revature1705May15Java/1705May15Java">My Github Branch</a>.
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-below">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">Copyright &copy; Liqun Zheng's Website 2017</div>
				</div>
			</div>
		</div>
	</footer>



	<!-- jQuery for slide motion-->
	<script src="js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript for bold topic on top -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript  for slide motion -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Contact Form JavaScript for validations -->
	<script src="js/jqBootstrapValidation.js"></script>
	

	<!-- Theme JavaScript for slide motion-->
	<script src="js/freelancer.min.js"></script>
	
	 <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <script>
  $(function(){
    $("#req").dataTable();
  })
    $(function(){
    $("#emp").dataTable();
  })
  </script>

</body>

</html>