$(document).ready(function() {

	$(".btn-pref .btn").click(function () {
		$(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
		// $(".tab").addClass("active"); // instead of this do the below 
		$(this).removeClass("btn-default").addClass("btn-primary");   
	});

});
$(document).ready(function() {
	$(".search").keyup(function () {
		$('.no-result').hide();
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