<html>
<head>

<!-- JQuery -->
<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>

<!-- JQuery DataTables -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.js"></script>

<!--Bootstrap -->
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
  background-color: #222;
  border: none;
  border-radius: 20px;
  -webkit-user-select:none;
  -moz-user-select:none;
  -ms-user-select:none;
  user-select:none;
}

.button:hover {background-color: #333;}

.button:active {
  background-color: #333;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
  
  
}

.content {
	width:85%;
   margin-left: 7.5%;
    padding: 10px;
}
</style>


</head>
<body>


<div class="content">

	<!-- Navbar -->
	<nav class="navbar navbar-inverse bg-inverse navbar-fixed-top">
		
		
		<form method = "post">
			<input type="submit" value="Home" style = "background-color: Transparent; border: none; color: white;" onclick="form.action='goHome';"/>
			<input type="submit" value="Profile" style = "background-color: Transparent; border: none;  color: white;" onclick="form.action='goProfile';"/>
			<input type="submit" value="Logout" style = "background-color: Transparent; border: none;  color: white;" onclick="form.action='logout';"/>
		</form>

    </nav>

	<br>
	<br>
	
	 <h2>Welcome ${name}!</h2>
 	<br>

  <!-- Trigger the modal with a button -->
  <button type="button" class="button" data-toggle="modal" data-target="#eModal">Add Employee</button>
  <br>
	
	<h3>Requests</h3>
	<!-- Request Table -->
	<table  class="table" cellpadding="0" cellspacing="0" border="0" id="tableId">
		<thead>
		<tr>
			<th>ID</th>
			<th>Status</th>
			<th>Amount</th>
			<th>Purpose</th>
			<th>Requester</th>
			<th>Resolver</th>
			<th>Note</th>
		</tr>
		</thead>
	</table>
	
	
	<br>
	<br>
	
	<h3>Employees</h3>
	<!-- Employee Table -->
	<table  class="table" cellpadding="0" cellspacing="0" border="0" id="eTable">
		<thead>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Is Manager</th>
			<th>E-Mail</th>
		</tr>
		</thead>
	</table>
	
	<#if add! == "fail">
	<h5 style="color:red">Employee already exists or email is in use.</h5>
	</#if>
	


  <!-- Trigger the modal with a button -->
  <button type="button" class="button" data-toggle="modal" data-target="#eModal">Add Employee</button>


  <!-- Modal Accept and Deny -->
  <div class="modal fade" id="eModal" role="dialog" data-backdrop="static">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style = "background-color:#222;color:white;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Approve/Deny Request</h4>
        </div>
        <div class="modal-body">
          <form name = "addForm" action="addEmployee" method="post">
          	First Name <br>
			<input type = "text" name = "fn" required = required maxlength="30"/> 
			<br>
			Last Name <br>
			<input type = "text" name = "ln" required = required maxlength="30"/> 
			<br>
			Email <br>
			<input type = "email" name = "email" required = required maxlength="50"/> 
			<br>
			Password <br>
			<input type = "password" name = "pass" required = required maxlength="20"/> 
			<br>
			Are they a manager? <br>
			<input type="radio" name="isManager" value="yes" > Yes<br>
  			<input type="radio" name="isManager" value="no"checked> No
  			<br>
			<input type="submit" class="button" value="submit"/>
		   </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="button" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
	
</div>





  <!-- Modal Accept and Deny -->
  <div class="modal fade" id="myModal" role="dialog" data-backdrop="static">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style = "background-color:#222;color:white;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Approve/Deny Request</h4>
        </div>
        <div class="modal-body">
          <form name = "resolveForm" action="resolve" method="post">
			ID <br>
			<input type = "number" id = "rid" name ="id"  value = "0" readonly> <br>
			Note <br>
			<input type = "text" name = "note" required = required maxlength="300"/> 
			<br>
			  <input type="radio" name="stat" value="accepted" checked> Accept<br>
  			<input type="radio" name="stat" value="denied"> Deny
  			<br>
			<input type="submit" class="button" value="submit"/>
			</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="button" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
	
</div>

	<script>

	$(document).ready(function() 
	{
	var table = $('#tableId').dataTable( 
	{
	"processing": true,
	"ajax": {
	"url": "/ERS/displayRequets",
	"dataSrc": "demo",
	"type": "POST"
	
	}
	});
	
	var table2 = $('#eTable').dataTable( 
	{
	"processing": true,
	"ajax": {
	"url": "/ERS/displayEmployees",
	"dataSrc": "demo",
	"type": "POST"
	}
	});
	
	$('#tableId tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            
           var x = parseInt($('.selected :first-child').text());
        
        	var stat = $('.selected :first-child').next().text();
        	
        
        	if(stat == "pending")
        	{
        		 $('#myModal').modal('show');
          		 $('#rid').val(x);
        	}
           
        }
    });
	
	});
	
	
	</script>


</body>
</head>