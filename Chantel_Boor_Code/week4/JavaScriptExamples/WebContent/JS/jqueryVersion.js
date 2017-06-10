//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
function getUSA()
{
	var x = $("[data-customAttr = USA]").html();
	console.log(x);
	
}

console.log("get usa");
getUSA();

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.

function printPeopleSales()
{
	var allElems = $('td:contains("Sales")').prev();
	
	for(var i =0; i<allElems.length;i++)
	{
		console.log(allElems[i].innerHTML);
	}

}

console.log("sales people");
printPeopleSales();

//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>

function getAnchorChildren()
{
   var x = $("a").children("span");
   
	for(var i =0; i<x.length;i++)
	{
		console.log(x[i].innerHTML);
	}
}

console.log("anchor children");
getAnchorChildren();

//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
function getHobbies()
{
	var all = $('select[name = "skills"]').children('[selected="selected"]');
	
	for(var i=0;i<all.length;i++)
	{
		if(all[i].parentNode.name == "skills")
		{
			console.log("value: " + all[i].value + " contents: " + all[i].innerHTML);
		}
	}
	
}

console.log("hobbies");
getHobbies();

function getCustomAt()
{
	var all =  $("[data-customAttr]");
	
	
	for(var i = 0;i<all.length;i++)
	{
		console.log("Element: "+all[i].nodeName + " Attribut Value: " + all[i].attributes["data-customattr"].value);
	}
}

console.log("Custom Atribute");
getCustomAt();


//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//  <input id="num1" class="nums" type="text"/>
//  <input id="num2" class="nums" type="text"/>
//  <h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element

$( ".nums" ).change(function() 
{
	var a = parseInt($("#num1").val()); 
	var b = parseInt($("#num2").val());
	
	var sum = a+b;
	
	if(isNaN(sum))
	{
		document.getElementById("sum").innerHTML = "Can not be added";
	}
	else
	{
		document.getElementById("sum").innerHTML = sum;
	}
})

//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//    "Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
$("[name = skills]").change(function() 
{
	alert( "Are you sure " + $("[name =skills]").value + " is one of your skills?" );
})

//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//    "So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
$( 'input[name="favoriteColor"]' ).click(function()
{
	var prevColor = $("#favColors").css("background-color");
	
	var newColor = $('input[name=favoriteColor]:checked').val();
	
	 $("#favColors").css('background-color', newColor);
	alert("so you like " + newColor + " more than " + prevColor + " now?")
})

//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//    Hide the name if shown.
//    Show the name if hidden.
//shown on one element
$(document).ready(function() {
	$('.empName').mouseenter(function() {
		$('td').hide();
	})
	.mouseleave(function() {
		$('td').show();
	});
});


//10. Current Time
//Regarding this element:
//  <h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
function updateClock() 
{
    
	$("#currentTime").html(new Date($.now()));

    // call this function again in 1000ms
    setTimeout(updateClock, 1000);
}

updateClock();

//11. Delay
//Regarding this element:
//  <p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
$("#helloWorld").click(function() {

	    	var colors = ["black","red","blue","green","purple","orange","yellow","teal","lime"];
	    	var chosenColor = colors[Math.floor(Math.random()*colors.length)];

	        setTimeout(function() 
	        	{
	        	document.getElementById("helloWorld").style.color = chosenColor;
	            },3000);
 })
 
 //12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
$("body").find("*").andSelf().each(function() {
    alert(this.nodeName); //alerts body, div, div, span
});​