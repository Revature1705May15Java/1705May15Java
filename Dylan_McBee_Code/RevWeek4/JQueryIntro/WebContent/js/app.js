//is mouse over ryu
var isHovered = false;
$(document).ready(function(){
	$('.ryu').mouseenter(function(){
		$('.ryu-still').hide();
		$('.ryu-ready').show();
		isHovered = true;
	})

	.mouseleave(function(){
		$('.ryu-ready').hide();
		$('.ryu-still').show();
		isHovered = true;
	})

	.mousedown(function(){
		playHadouken();
		$('.ryu-throwing').show();
		$('.ryu-ready').hide();
		$('.haduken').finish().show().animate(
				{'left': '8.75rem'},
				280,
				function(){
					$(this).hide();
					$(this).css('left', '-10rem');
				});
	})

	.mouseup(function(){
		$('.ryu-throwing').hide();
		$('.ryu-ready').show();
	});

});

//document ready keydown 'x'

$(window).keydown(function(e){
	if(e.keyCode==88){
		playPose();
		$('.ryu-cool').show();
		$('.ryu-still').hide();
		$('.ryu-ready').hide();
	}

})	.keyup(function(e){
	$('#pose-sound')[0].pause();
	$('#pose-sound')[0].load();
	$('.ryu-cool').hide();
	if(isHovered==true){
		$('.ryu-ready').show();
	}
	else{
		$('.ryu-still').show();
	}

});

function playHadouken(){
	$('#hadouken-sound')[0].volume=0.2;
	$('#hadouken-sound')[0].load();
	$('#hadouken-sound')[0].play();
}
var playSound = false;
function playPose(){
	playSound = !playSound;
	if(playSound){
		$('#pose-sound')[0].volume=0.2;
		$('#pose-sound')[0].play();
	}
}