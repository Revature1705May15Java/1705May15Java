<html>
<head>
<title>Employee Page</title>
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

/* The Modal (background) */
.modal {
	backdrop: 'static';
	display: none;
    position: fixed; /* Stay in place */
    padding-top: 50px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    data-backdrop: 'static';
    data-keyboard: false;
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

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
    height: 400px;
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
			<#if createrequest! == "success">
			<h3 style="color:green">Request submitted.</h3>
			</#if>
			<#if createrequest! == "fail">
			<h3 style="color:red">Invalid entry. Please try again.</h3>
			</#if>
			<h4>Create a New Reimbursement Request</h3>
			<form method="POST" action="createRequest">
			<input class="form-control" type="number" name="amount" min="1.00" step="0.01" required="required" placeholder="$0.00">
			<input class="form-control" type="text" name="purpose" placeholder="Purpose of spending" required="required" maxlength="255" style="margin-bottom: 10px"/>
			<input class="btn-primary" type="submit" value="Submit Request"/>
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




<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">EDIT</h4>
      </div>
      <div class="modal-body">
      	<form method="POST" action="editRequest">
        <pre style="float:left"> Request Id: <input class="form-control" type="text" class="input-sm" id="requestid" name="requestid"/></pre>
        <pre>     Status: <input class="form-control" type="text" class="input-sm" name="status" id="status" disabled="true" readonly/></pre>
        <pre style="float:left">     Amount: <input class="form-control" type="text" class="input-sm" required="required" placeholder="Enter an amount" id="amt" name="amt"/></pre>
        <pre>   Admin Id: <input class="form-control" type="text" class="input-sm" id="adminid" name="adminid" disabled="true" readonly/></pre>
        <pre>    Purpose: <input class="form-control" type="text" class="input-sm" required="required" placeholder="Enter a detailed purpose" id="purpose" name="purpose"/></pre>    
        <pre> Admin Note: <input class="form-control" type="text" class="input-sm" name="adminNote" id="adminNote" disabled="true" readonly/></pre>
        <pre style="float:left">Date Opened: <input class="form-control" type="text" class="input-sm" name="dateOpened" id="dateOpened" disabled="true" readonly/></pre>
        <pre>Date Closed: <input class="form-control" type="text" class="input-sm" name="dateClosed" id="dateClosed" disabled="true" readonly/></pre>
		<div class="modal-footer">
        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        	<input type="submit" name="submit" class="btn btn-primary" value="Save changes"/>
        </div>
        <input style="background-color: crimson; color: white;" name="delete" type="submit" class="btn" value="Delete Request"/>
        </form>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
	
	
	
<script>

// Get the modal
var modal = document.getElementById('myModal');

$('table tbody tr  td').on('click',function(){
    $('#myModal').modal({
  		backdrop: 'static'
	}); 
    $("#requestid").val($(this).closest('tr').children()[0].textContent);
    $("#amt").val($(this).closest('tr').children()[1].textContent);
    $("#purpose").val($(this).closest('tr').children()[2].textContent);
    $("#status").val($(this).closest('tr').children()[3].textContent);
    $("#dateOpened").val($(this).closest('tr').children()[4].textContent);
    $("#dateClosed").val($(this).closest('tr').children()[5].textContent);
    $("#adminNote").val($(this).closest('tr').children()[6].textContent);
    $("#adminid").val($(this).closest('tr').children()[7].textContent);
    
});


$(function(){
    /*
     * this swallows backspace keys on any non-input element.
     * stops backspace -> back
     */
    var rx = /INPUT|SELECT|TEXTAREA/i;

    $(document).bind("keydown keypress", function(e){
        if( e.which == 8 ){ // 8 == backspace
            if(!rx.test(e.target.tagName) || e.target.disabled || e.target.readOnly ){
                e.preventDefault();
            }
        }
    });
});

</script>
</body>
</html>