<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{
background-image: url("img/emp page background.jpg");
background-repeat: no-repeat;
background-position: 50% 0%;
}
.results2 tr[visible='false'], .no-result {
	display: none;
}

.results2 tr[visible='true'] {
	display: table-row;
}

.counter2 {
	padding: 8px;
	color: #ccc;
}
.results tr[visible='false'], .no-result {
	display: none;
}

.results tr[visible='true'] {
	display: table-row;
}

.counter {
	padding: 8px;
	color: #ccc;
}
.results1 tr[visible='false'], .no-result {
	display: none;
}

.results1 tr[visible='true'] {
	display: table-row;
}

.counter1 {
	padding: 8px;
	color: #ccc;
}
.logout{
	float:right;
    padding: 10px;
    position: relative;
    width: 200px;
    height: 200px;
    z-index: 15;


}
 .card {
    margin-top: 20px;
    padding: 30px;
    background-color: rgba(214, 224, 226, 0.2);
    -webkit-border-top-left-radius:5px;
    -moz-border-top-left-radius:5px;
    border-top-left-radius:5px;
    -webkit-border-top-right-radius:5px;
    -moz-border-top-right-radius:5px;
    border-top-right-radius:5px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.card.hovercard {
    position: relative;
    padding-top: 0;
    overflow: hidden;
    text-align: center;
    background-color: #fff;
    background-color: rgba(255, 255, 255, 1);
}
.card.hovercard .card-background {
    height: 130px;
}
.card-background img {
    -webkit-filter: blur(25px);
    -moz-filter: blur(25px);
    -o-filter: blur(25px);
    -ms-filter: blur(25px);
    filter: blur(25px);
    margin-left: -100px;
    margin-top: -200px;
    min-width: 130%;
}
.card.hovercard .useravatar {
    position: absolute;
    top: 15px;
    left: 0;
    right: 0;
}
.card.hovercard .useravatar img {
    width: 100px;
    height: 100px;
    max-width: 100px;
    max-height: 100px;
    -webkit-border-radius: 50%;
    -moz-border-radius: 50%;
    border-radius: 50%;
    border: 5px solid rgba(255, 255, 255, 0.5);
}
.card.hovercard .card-info {
    position: absolute;
    bottom: 14px;
    left: 0;
    right: 0;
}
.card.hovercard .card-info .card-title {
    padding:0 5px;
    font-size: 20px;
    line-height: 1;
    color: #262626;
    background-color: rgba(255, 255, 255, 0.1);
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
}
.card.hovercard .card-info {
    overflow: hidden;
    font-size: 12px;
    line-height: 20px;
    color: #737373;
    text-overflow: ellipsis;
}
.card.hovercard .bottom {
    padding: 0 20px;
    margin-bottom: 17px;
}
.btn-pref .btn {
    -webkit-border-radius:0 !important;
}


</style>

<title>test</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-lg-8 col-sm-8 col-lg-offset-2">
    <div class="card hovercard">
        <div class="card-background">
            <img class="card-bkimg" alt="" src="https://kbdevstorage1.blob.core.windows.net/asset-blobs/19177_en_1">
        </div>
        <div class="useravatar">
            <img alt="" src="http://arabiants.com/media/com_teamchart/2427df0a64e7663e36b6494529ffb80e.png">
        </div>
        <div class="card-info"> <span class="card-title">${fn} ${ln}</span>

        </div>
    </div>
    <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" id="reimbursements" class="btn btn-primary" href="#tab1" data-toggle="tab"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                <div class="hidden-xs">Pending Reimbursements</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="reimbursements" class="btn btn-default" href="#tab2" data-toggle="tab"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                <div class="hidden-xs">All Reimbursements</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="employees" class="btn btn-default" href="#tab3" data-toggle="tab"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                <div class="hidden-xs">All Employees</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" id="account" class="btn btn-default" href="#tab4" data-toggle="tab"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <div class="hidden-xs">Account Info & Logout</div>
            </button>
        </div>
    </div>

        <div class="well">
      <div class="tab-content">
        <div class="tab-pane fade in active" id="tab1">
          <div class="form-group pull-right">
						<input type="text" class="search form-control"
							placeholder="What you looking for?">
					</div>
					<span class="counter pull-right"></span>
					<table class="table table-hover table-bordered results" id="pendingRequests">
						<thead>
							<tr>
								<th>Request Id</th>
								<th class ="col-md-3 col-cs-3">Employee</th>
								<th class="col-md-3 col-xs-3">Amount</th>
								<th class="col-md-3 col-xs-3">Purpose</th>
								<th class="col-md-3 col-xs-3">Status</th>
								<th class="col-md-3 col-xs-3">Date Requested</th>
								
							</tr>
							
							<tr class="warning no-result">
								<td colspan="5"><i class="fa fa-warning"></i> No result</td>
							</tr>
							<#list pRequests as request>
							
						</thead>
						<tbody>
							<tr class = "rows">
								<td class = "pRequestId">${request.requestId}</td>
								<td class = "pRequestorId">${request.requestorId}</td>
								<td class = "pAmount">${request.amount?string.currency}</td>
								<td class = "pPurpose">${request.purpose}</td>
								<td class ="pState">${request.type}</td>
								<td class = "pOpen">${request.dateRequested}</td>




							</tr>

						</tbody>
						</#list>
					</table>
					<!-- Modal -->
			<div id="pendingModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
	
					<!--  Modal content -->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Request Information</h4>
						</div>
						<div class="modal-body">
							<p class="requestId"></p>
							<p class="requestorId"></p>
							<p class="state"></p>
							<p class="amount"></p>
							<p class="opendate"></p>
							<p class="purpose"></p>
							<form name="resolveform" action="resolve" method="POST">
								<input type="radio" name="choice" value="approve"/>Approve
								<input type="radio" name="choice" value="deny"/>Deny
								<input type="hidden" name="requestId" value="" id="hiddenRequestId"/>
								<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
          
        </div>
        <div class="tab-pane fade in" id="tab2">
          <div class="form-group pull-right">
						<input type="text" class="search2 form-control"
							placeholder="What you looking for?">
					</div>
					<span class="counter2 pull-right"></span>
					<table class="table table-hover table-bordered results2" id = "allRequests">
						<thead>
							<tr>
								<th class="col-md-3 col-xs-3">Requestor</th>
								<th class="col-md-4 col-xs-4">Request Status</th>
								<th class="col-md-3 col-xs-3">Amount</th>
								<th class="col-md-2 col-xs-2">Purpose</th>
								<th class="col-md-2 col-xs-2">Requested</th>
								<th class="col-md-2 col-xs-2">Resolved</th>
								<th class="col-md-1 col-xs-1">Manager Name</th>
							</tr>
							<tr class="warning no-result">
								<td colspan="7"><i class="fa fa-warning"></i> No result</td>
							</tr>
							<#list aRequests as request>
						
						</thead>
						<tbody>
							<tr>
								<td>${request.eLastName}</td>
								<td>${request.type}</td>
								<td>${request.amount?string.currency}</td>
								<td>${request.purpose}</td>
								<td>${request.dateRequested}</td>
								<#if request.dateResolved??>
								<td>${request.dateResolved}</td>
								<#else><td>-</td>
								</#if>
								<td>${request.lastName}</td>



							</tr>

						</tbody>
						</#list>

					</table>
          
        </div>
        <div class="tab-pane fade in" id="tab3">
          <h3>List of Employees</h3>
          <div class="form-group pull-right">
						<input type="text" class="search1 form-control"
							placeholder="What you looking for?">
					</div>
					<span class="counter1 pull-right"></span>
					<table class="table table-hover table-bordered results1" id="allEmployees">
						<thead>
							<tr>
								<th>Employee Id</th>
								<th class="col-md-4 col-xs-4">First Name</th>
								<th class="col-md-3 col-xs-3">Last Name</th>
								<th class="col-md-2 col-xs-2">Manager</th>
								
							</tr>
							
							<tr class="warning no-result">
								<td colspan="4"><i class="fa fa-warning"></i> No result</td>
							</tr>
							<#list employees as employee>
							
						</thead>
						<tbody>
							<tr>
								<td class = "employeeId">${employee.id}</td>
								<td class = "fn">${employee.firstName}</td>
								<td class = "ln">${employee.lastName}</td>

								<#if employee.isManager! ==1>
								<td class = "man">Yes</td>
								<#else>
								<td class = "man">No</td>
								</#if>



							</tr>

						</tbody>
						</#list>
					</table>
        </div>
        <div class="tab-pane fade in" id="tab4">
        
          <h3>Account Info</h3>
					<div class="logout">
						<form action="logout" method="POST" name="Logout_Form">
							<button class="btn btn-lg btn-primary btn-block" name="Submit"
								value="Logout" type="Submit">Logout</button>
						</form>
					</div>
					ID number: ${id}<br>First Name: ${fn}<br>Last Name: ${ln}<br>Email
					Address: ${email}<br>
					<!-- Trigger the modal with a button -->

					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#myModal">Update
						Information</button>


					<!-- Modal -->
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Modal Header</h4>
								</div>
								<div class="modal-body">
									<form action="update" method="POST" name="update_form">
										First Name: <input type="text" name="firstname" value="${fn}" /><br>
										Last Name: <input type="text" name="lastname" value="${ln}" /><br>
										Email: <input type="text" name="email" value="${email}" /><br>
										<button class="btn btn-lg btn-primary btn-block" name="Submit"
											value="Update" type="Submit">Update Info</button>
									</form>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>
    
    </div>
</div>
</div>
	<script type= "text/javascript" src="js/manpage.js"></script>
</body>
</html>