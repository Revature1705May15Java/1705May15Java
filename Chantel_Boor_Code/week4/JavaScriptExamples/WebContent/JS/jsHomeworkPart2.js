
//-----------------------------------------------------------------------------------
//PART II
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//      They should be done separately.
//      Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
function getUSA()
{
	var x = document.querySelector("[data-customAttr = USA]").innerHTML;
	console.log(x);
	
}

console.log("get usa");
getUSA();

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.

function printPeopleSales()
{
	var allElems = document.querySelectorAll("td"); 


	for(var i = 1;i<allElems.length;i+=2)
	{
		if(allElems[i].innerHTML == "Sales")
		{
			console.log(allElems[i-1].innerHTML+" "+allElems[i].innerHTML);
		}
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
	var allSpan =  document.querySelectorAll("span");
	
	for(var i=0;i<allSpan.length;i++)
	{
		if(allSpan[i].parentNode.nodeName == "A")
			console.log(allSpan[i].innerHTML);
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
	var all =  document.querySelectorAll("[selected=selected]");
	
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


//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.

function getCustomAt()
{
	var all =  document.querySelectorAll("[data-customAttr]");
	
	
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
//    <input id="num1" class="nums" type="text"/>
//    <input id="num2" class="nums" type="text"/>
//    <h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element

function onChange()
{
	var num1 = 0;
	var nam2 = 0;
	var num3;
	
	num1 = parseInt(document.getElementById("num1").value);
	num2 = parseInt(document.getElementById("num2").value);
	

	num3 = num1+num2
	
	if(isNaN(num3))
	{
		document.getElementById("sum").innerHTML = "Can not be added";
	}
	else
	{
		document.getElementById("sum").innerHTML = num3;
	}
}

document.getElementById("num1").addEventListener("change",onChange);
document.getElementById("num2").addEventListener("change",onChange);


//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//    "Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.

function skillAlert()
{
	var x = document.querySelector("[name = skills]").value;
	
	alert("Are you sure  " + x + " is one of your skills?");
}


document.querySelector("[name = skills]").addEventListener("change",skillAlert);

//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//    "So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

function colorAlert()
{
	var prevColor = document.getElementById("favColors").style.backgroundColor;
	
	if(prevColor == "")
		prevColor = "nothing";
	
	var newColor = document.querySelector("[name=favoriteColor]:checked").value;
	
	
	document.getElementById("favColors").style.backgroundColor = newColor;
	alert("so you like " + newColor + " more than " + prevColor + " now?")

	
}


document.querySelector("input[value=red]").addEventListener("click",colorAlert);
document.querySelector("input[value=blue]").addEventListener("click",colorAlert);
document.querySelector("input[value=green]").addEventListener("click",colorAlert);
document.querySelector("input[value=orange]").addEventListener("click",colorAlert);



//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//    Hide the name if shown.
//    Show the name if hidden.
//shown on one element

document.getElementById("emp1").onmouseover = function showHide ()
{
	document.getElementById("emp1").style.display = "none";
}

document.getElementById("emp1").onmouseout = function showHide ()
{
	document.getElementById("emp1").style.display = "block";
}



//10. Current Time
//Regarding this element:
//    <h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.

function updateClock() {
    var now = new Date(), // current date
    
        time = now.getHours() + ':' + now.getMinutes() + ":" + now.getSeconds(); // again, you get the idea


    // set the content of the element with the ID time to the formatted string
    document.getElementById('currentTime').innerHTML = [time].join(" / ");

    // call this function again in 1000ms
    setTimeout(updateClock, 1000);
}
updateClock()




//11. Delay
//Regarding this element:
//    <p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.

function delay()
{
	
	var colors = ["black","red","blue","green","purple","orange","yellow","teal","lime"];
	
	var chosenColor = colors[Math.floor(Math.random()*colors.length)];
	
	
	setTimeout(function()
	{
		
		document.getElementById("helloWorld").style.color = chosenColor;

	}, 3000);
}

document.getElementById("helloWorld").addEventListener("click",delay);


//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).

var results = [];


var walkDOM = function (node,func) {
      func(node);                     //What does this do?
      node = node.firstChild;
      while(node) {
          walkDOM(node,func);
          node = node.nextSibling;
      }
};    

//invoke method after
walkDOM(document.body, function(node) {
  results += node.nodeName + " ";
});

console.log(results);