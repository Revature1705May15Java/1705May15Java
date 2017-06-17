<html>
<head>
<title>Manager Page</title>
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
	<script src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	
	<script>
	$(document).ready(function(){
	    $('#reqTable').DataTable({
	    	  "columnDefs": [{ "width": "30%", "targets": 2 }]
	    });
	});
	</script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style>

table{
  margin: 0 auto;
  clear: both;
  table-layout: fixed;
}

div#newuser{
    float: left;
    margin-right: 10px;
    height: 250px;
    width: 350px;
    color: black;
}

div#requesttable{
	text-align: center; 
	position: fixed;
	height: 300px;
    width: 750px;
    x: 200px;
}

div#requestdiv{
    height: 900px;
    width: 900px;
    overflow-y: scroll;
    color: black;
    background-color: white;
}

div#editInfo{
	margin-top: -650px;
    height: 250px;
    width: 350px;
    overflow-y: scroll;
    color: black;
    background-color: white;
}

</style>

<title>Welcome Page</title>
</head>
<body style="background-color: aquamarine;">

	<div class="jumbotron" style="background-color: skyblue; color: purple; text-align: center;">
		<h3>Welcome ${user.getFn()} ${user.getLn()}!!</h3>
		<form method="POST" action="logout">
			<input class="btn-primary" type="submit" name="logout" value="Log Out" />
		</form>

		
		<div id="newuser" class="jumbotron">
			<#if createuser! == "success">
			<h3 style="color:green">Employee Created.</h3>
			</#if>
			<#if createuser! == "fail">
			<h3 style="color:red">Username is unavailable. Please try again.</h3>
			</#if>
			<h4 style="margin-top: -15px">Create a New Employee login</h3>
			<form method="POST" action="create">
			<input class="form-control" type="text" name="username" placeholder="Username" required="required" />
			<input class="form-control" type="password" name="password" placeholder="Password"  required="required" />
			<input class="form-control" type="text" name="firstname" placeholder="First name" required="required" />
			<input class="form-control" type="text" name="lastname" placeholder="Last name" required="required" style="margin-bottom: 10px"/>
			Rank:<select name="rank">
			    <option value="employee" selected="selected">Employee</option>
    			<option value="manager">Manager</option>
  			</select>
			<input class="btn-primary" type="submit" value="Create Employee"/>
			</form>
		</div>
		
		<div id="requestdiv" class="jumbotron">
				<table id="reqTable" class="display" cellspacing="0" width="98%">
					<thead>
						<tr >
							<th style="text-align:center;">Request ID</th>
							<th style="text-align:center;">Amount</th>
							<th style="text-align:center;">Purpose</th>
							<th style="text-align:center;">Status</th>
							<th style="text-align:center;">Date Opened</th>
							<th style="text-align:center;">Date Closed</th>
							<th style="text-align:center;">Admin Note</th>
							<th style="text-align:center;">Admin ID</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Request ID</th>
							<th>Amount</th>
							<th>Purpose</th>
							<th>Status</th>
							<th>Date Opened</th>
							<th>Date Closed</th>
							<th>Admin Note</th>
							<th>Admin ID</th>
						</tr>
				   </tfoot>
					<tbody>
						<#list Requests as req>
							<tr>
								<td>${req.getId()}</td>
								<td>${req.getBalance()}</td>
								<td>${req.getPurpose()}</td>
								<td>${req.getType()}</td>
								<td>${req.getDateOpened()}</td>
								<td>${req.getDateClosed()!"N/A"}</td>
								<td>${req.getAdminNote()!"N/A"}</td>
								<td>${req.getAdminId()!"N/A"}</td>
							</tr>
						</#list>
					</tbody>
				</table>
		</div>
		
		<div id="editInfo">
			<#if editing! == "success">
			<h3 style="color:green">Edit Successful.</h3>

			<#elseif editing! == "fail">
			<h3 style="color:red">Invalid Edit, please try again.</h3>
			
			<#elseif editing! == "pwfail">
			<h3 style="color:red">Password mismatch, please try again.</h3>
			
			</#if>
			
			<h3>Edit Personal Information</h3>
			<h5>If you do not wish to edit a value, leave it blank.</h5>
			<form method="POST" action="editInfo">
			<p>Username: ${user.getUsername()}</p>
			<input class="form-control" type="text" name="newusername" placeholder="New Username" maxlength="20" style="margin-top: -15px; margin-bottom:25px"/>
			
			<p>Password</p>
			<input class="form-control" type="text" name="oldpw" placeholder="Enter Current Password" maxlength="30" style="margin-top: -15px"/>
			<input class="form-control" type="text" name="newpw" placeholder="New Password" maxlength="30" />
			<input class="form-control" type="text" name="newpw2" placeholder="Re-enter New Password" maxlength="30" style="margin-bottom: 25px;">
			
			<p>Name: ${user.getFn()} ${user.getLn()}</p>
			<input class="form-control" type="text" name="newfn" placeholder="first name" maxlength="50" style="margin-top: -15px"/>
			<input class="form-control" type="text" name="newln" placeholder="last name" maxlength="50" style="margin-bottom: 25px"/>
			
			<input class="btn-primary" type="submit" value="Submit Edits"/>
			</form>
		</div>
		
	</div>

</body>

</html>