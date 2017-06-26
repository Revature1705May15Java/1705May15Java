$(document).ready(function() {
$(".btn-pref .btn").click(function () {
    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
    // $(".tab").addClass("active"); // instead of this do the below 
    $(this).removeClass("btn-default").addClass("btn-primary");   
});
});
$(document).ready(function() {
	  $(".search").keyup(function () {
	    var searchTerm = $(".search").val();
	    var listItem = $('.results tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });

	  var jobCount = $('.results tbody tr[visible="true"]').length;
	    $('.counter').text(jobCount + ' item');

	  if(jobCount == '0') {$('.no-result').show();}
	    else {$('.no-result').hide();}
			  });
	});
$(document).ready(function() {
	  $(".search1").keyup(function () {
	    var searchTerm = $(".search1").val();
	    var listItem = $('.results1 tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results1 tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results1 tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });

	  var jobCount = $('.results1 tbody tr[visible="true"]').length;
	    $('.counter1').text(jobCount + ' item');

	  if(jobCount == '0') {$('.no-result').show();}
	    else {$('.no-result').hide();}
			  });
	});
$(document).ready(function() {
	  $(".search2").keyup(function () {
	    var searchTerm = $(".search2").val();
	    var listItem = $('.results2 tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results2 tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results2 tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });

	  var jobCount = $('.results2 tbody tr[visible="true"]').length;
	    $('.counter2').text(jobCount + ' item');

	  if(jobCount == '0') {$('.no-result').show();}
	    else {$('.no-result').hide();}
			  });
	});

$(document).ready(function(){
	

$('#pendingRequests').delegate("tr.rows","click",function(){
	var id = $('.pRequestId', this).html();
	var requestorId = $('.pRequestorId', this).html();
	var state = $('.pState', this).html();
	var amount = $('.pAmount', this).html();
	var dateRequested = $('.pOpen', this).html();
	var purpose = $('.pPurpose', this).html();
	
	$('#hiddenRequestId').val(id);
	
	$('#pendingModal .requestId').html('');
	$('#pendingModal .requestorId').html('');
	$('#pendingModal .state').html('');
	$('#pendingModal .amount').html('');
	$('#pendingModal .opendate').html('');
	$('#pendingModal .purpose').html('');	
	$('#pendingModal .requestId').html("Request Id: " + id);
	$('#pendingModal .requestorId').html("Employee Id: " + requestorId);
	$('#pendingModal .state').html("State: " + state);
	$('#pendingModal .amount').html("Amount: " + amount);
	$('#pendingModal .opendate').html("Date Requested: " + dateRequested);
	$('#pendingModal .purpose').html("Purpose: " + purpose);
	$('#pendingModal').modal('show');
	
});
});
