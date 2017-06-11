<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="crossorigin="anonymous"></script>
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		
		
	</head
	
	<body>
		<#if employee??>
    		${employee.getUsername()} 
    		${employee.getPassword()} 
    		${employee.getId()} 
    		${employee.getFirstName()} 
    		${employee.getLastName()} 
		</#if>
		<h3>EMPLOYEE HOME PAGE</h3>
		
		<div class="container">
		  <h2>Modal Example</h2>
		  <!-- Trigger the modal with a button -->
		  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
		
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Submit Reimbursement Request</h4>
		        </div>
		        <form class="form-newRequest" method="POST" action="submitRequest">
			        <div class="modal-body">
			          <p>Enter Reibursement Request</p>
			          <input type="number" class="form-control" name="amount" placeholder="Enter amount" required="required"/>
			          	<input type="text" class="form-control" name="purpose" placeholder="purpose" required="required"/>
			        </div>
			        <div class="modal-footer">
			          <input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit Request"/>
			        </div>
		        </form>
		      </div>    
		    </div>
		  </div> 
		</div>
		
		<form class="form-signout" method="POST" action="logout">
			<input type="submit" class="btn btn-lg btn-primary btn-block" value="Logout"/>
		</form>
	</body>
</html>