$(document).ready(function() {
	//$('#reqTable').on('click', 'tr', function() {
	$('#reqTable tr').click(function() {
		var id = $('.reqid', this).html();
		var empId = $('.empId', this).html();
		var state = $('.state', this).html();
		var amount = $('.amount', this).html();
		var openDate = $('.opendate', this).html();
		var closeDate = $('.closedate', this).html();
		var purpose = $('.purpose', this).html();
		var managerId = $('.manid', this).html();
		var managerNote = $('.mannote', this).html();
		
		$('#reqModal .reqid').html('');
		$('#reqModal .empid').html('');
		$('#reqModal .state').html('');
		$('#reqModal .amount').html('');
		$('#reqModal .opendate').html('');
		$('#reqModal .closedate').html('');
		$('#reqModal .purpose').html('');
		$('#reqModal .manid').html('');
		$('#reqModal .mannote').html('');
		
		$('#reqModal .reqid').html("Request Id: " + id);
		$('#reqModal .empid').html("Employee Id: " + empId);
		$('#reqModal .state').html("State: " + state);
		$('#reqModal .amount').html("Amount: " + amount);
		$('#reqModal .opendate').html("Date Opened: " + openDate);
		if (closeDate != "")
			$('#reqModal .closedate').html("Date Closed: " + closeDate);
		$('#reqModal .purpose').html("Purpose: " + purpose);
		if (managerId != 0)
			$('#reqModal .manid').html("Manager Id: " + managerId);
		if (managerNote != "")
			$('#reqModal .mannote').html("Manager Note: " + managerNote);
		$('#reqModal').modal('show');
	});
});