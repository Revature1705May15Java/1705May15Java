//Javascript Homework
//Due Friday @ 9PM
//Put all homework in:
//	....Firstname_Lastname_Code/Week4/Javascript_Homework/
//-----------------------------------------------------------------------------------
//PART I
//Create a single Javascript file called homework.js to answer these questions.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------
//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.
function fib(n){
	
	if(n<=1){
		return 1;
	}
	return fib(n-1) + fib(n-2);
}

function doFib(){
	var display = document.getElementById("fibDisplay");
	var input = document.getElementById("fibNum").value;
	display.innerHTML = fib(input);
}
document.getElementById("doFib").addEventListener("click", doFib, false);
//elem = document.getElementById("fib");
//elem.innerHTML=fib(4);

//document.getElementById("fib").innerHTML = fib(4);
//var x = document.getElementByClass("examples");
//x.append

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray){
	var check;
    do {
        check = false;
        for (var i=0; i < numArray.length-1; i++) {
            if (numArray[i] > numArray[i+1]) {
                var temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
                check = true;
            }
        }
    } while (check);
    return numArray;
}
function doBub(){
	var display = document.getElementById("bubDisplay");
	var str = document.getElementById("bubNum").value;
	console.log(str);
	var input = str.split(" ");
	console.log(input);
	display.innerHTML = bubbleSort(input);
}
document.getElementById("doBub").addEventListener("click", doBub, false);

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr){
	var toArr = someStr.split("");
	var revArr = toArr.reverse();
	var newStr = revArr.join("");
	return someStr = newStr;
}
function doStr(){
	var display = document.getElementById("strDisplay");
	var input = document.getElementById("strString").value;
	display.innerHTML = reverseStr(input);
}
document.getElementById("doStr").addEventListener("click", doStr, false);


//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(someNum){
	var InputMinus = someNum - 1;
	var LoopCheck = someNum;
	var Temp = 0;
	for(x = 0; x <= LoopCheck ;x++){
		if(InputMinus == 0 ){
			break;
		}
		Temp = someNum * InputMinus;
		InputMinus = InputMinus - 1;
		someNum = Temp;
	}
	return Temp;
}
function doFact(){
	var display = document.getElementById("facDisplay");
	var input = document.getElementById("facNum").value;
	display.innerHTML = factorial(input);
}
document.getElementById("doFact").addEventListener("click", doFact, false);



//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someString, length, offset){
    if(offset>=someString.length || offset<0){
        alert("Offset is incorrect, it is out of bounds.");
    }
    if(length+offset>=someString.length || offset<0){
        alert("Length is incorrect, it is out of bounds.");
    }
    return someString.substr(offset, length);
    
}
function doSubs(){
	var display = document.getElementById("offDisplay");
	var input1 = document.getElementById("subStr").value;
	var input2 = document.getElementById("subLen").value;
	var input3 = document.getElementById("subOff").value;
	display.innerHTML = substring(input1, input2, input3);
}
document.getElementById("doSubs").addEventListener("click", doSubs, false);


//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum){
	if((someNum & 1) == 0){
		return true;
	}else{
		return false;
	}
}

function doEvn(){
	var display = document.getElementById("evnDisplay");
	var input = document.getElementById("evnNum").value;
	display.innerHTML =  isEven(input);
}
document.getElementById("doEvn").addEventListener("click", doEvn, false);


//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
	var toArr = someStr.split("");
	var revArr = toArr.reverse();
	var newStr = revArr.join("");
	if(someStr == newStr){
		return true;
	}else{
		return false;
	}
}
function doPali(){
	var display = document.getElementById("palDisplay");
	var input = document.getElementById("palSrt").value;
	display.innerHTML = isPalindrome(input);
}
document.getElementById("doPali").addEventListener("click", doPali, false);


//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *
function printShape(shape, height, character){
	var x = 1;
	var p = height-2;
	if(shape == "Triangle"){
		var prnt = [];
		for(i=0;i<height;i++){
			prnt.push(character);
			var srt = prnt.join("");
			console.log(srt);
		}
		return "Look at Console";
	}else if(shape == "Square"){
		var prnt = [];
		for(i=0;i<height;i++){
			var temp = 0;
			while(temp<height){
				prnt.push(character);
				temp++;
			}
			var srt = prnt.join("");
			console.log(srt + '\n');
			prnt = [];
		}
		return "Look at Console";
	}else if(shape == "Diamond"){
		for (var i = height/2; i >= 1; i--) {
		     var output = "";
		     for (var j = i; j >= 1; j--) {
		         output += ' ';
		     }
		     
		     for(var k = 0; k<x; k++){
		    	 output+= character;
		     }
		     x+=2;
		     console.log(output);
		 }
		var h = '';
		for(var y = 0; y< height; y++){
			h+=character;
			
		}
		console.log(h);
		
		
		for (var o = 1; o < (height/2); o++) {
		     var bot = "";
		     for (var n = 0; n < o; n++) {
		         bot += ' ';
		     }

		     
		     for(var u = p; u>0; u--){
		    	 bot+= character;
		     }
		     p-=2;
		     console.log(bot);
		 }
		return "Look at Console";
	}else{
		console.log("Not a valid choice!")
	}
}

function doShape(){
	var display = document.getElementById("shaDisplay");
	var input1 = document.getElementById("strSha").value;
	var input2 = document.getElementById("shaHei").value;
	var input3 = document.getElementById("shaChar").value;
	display.innerHTML = printShape(input1, input2, input3);
}
document.getElementById("doShape").addEventListener("click", doShape, false);


//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj){
	var x = 0;
	var i;
	var keys = Object.keys(someObj);
	for(i in someObj){
		console.log(keys[x] + " " + someObj[i]);
		x++;
	}
}
function doObj(){
	function makePerson(name, age, address){
		this.Name = name;
		this.Age = age;
		this.Address = address;
	}
	var display = document.getElementById("objDisplay");
	var input1 = document.getElementById("objTxt1").value;
	var input2 = document.getElementById("objTxt2").value;
	var input3 = document.getElementById("objTxt3").value;
	var person = new makePerson(input1, input2, input3);
	var x = 0;
	var i;
	var str;
	var keys = Object.keys(person);
	for(i in person){
		str += keys[x] + " " + person[i] + " ";
		x++;
	}
	display.innerHTML = str;
}
document.getElementById("doObj").addEventListener("click", doObj, false);


//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
function deleteElement(someArr){
	console.log("Array Length = " + someArr.length);
	delete someArr[2];
	console.log("Array Length = " + someArr.length);
	return someArr;
}
function doDel1(){
	var display = document.getElementById("delDisplay1");
	var str = document.getElementById("arrDel1").value;
	var input = str.split(" ");
	display.innerHTML = deleteElement(input);
}
document.getElementById("doDel1").addEventListener("click", doDel1, false);

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
function spliceElement(someArr){
	console.log("Array Length = " + someArr.length);
	someArr.splice(2,1);
	console.log("Array Length = " + someArr.length);
	return someArr;
}
function doDel2(){
	var display = document.getElementById("delDisplay2");
	var str = document.getElementById("arrDel2").value;
	var input = str.split(" ");
	display.innerHTML = spliceElement(input);
}
document.getElementById("doDel2").addEventListener("click", doDel2, false);


//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);
function Person(name, age){
	this.Name = name;
	this.Age = age;
}
function doPer(){
	var display = document.getElementById("perDisplay");
	var name = document.getElementById("perName").value;
	var age = document.getElementById("perAge").value;
	var pers = new Person(name, age);
	var disp = "Name: "+ pers.Name + ", Age: " + pers.Age;
	display.innerHTML = disp;
}
document.getElementById("doPer").addEventListener("click", doPer, false);




//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);
function getPerson(name, age){
	var temp = {
		Name: name,
		Age: age,
	};
	return temp;
}
function doPer1(){
	var display = document.getElementById("perDisplay1");
	var name = document.getElementById("perName1").value;
	var age = document.getElementById("perAge1").value;
	var pers = getPerson(name, age);
	console.log(pers);
	var disp = "Name: "+ pers.Name + ", Age: " + pers.Age;
	display.innerHTML = disp;
}
document.getElementById("doPer1").addEventListener("click", doPer1, false);



//-----------------------------------------------------------------------------------
//PART II
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//	  They should be done separately.
//	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
function getUSA(){
	var usa = document.querySelector('[data-customAttr="USA"]').innerHTML;
	console.log(usa);
	return usa;
}





//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
function getPeopleInSales(){
	var x = document.getElementsByTagName("td");
	var i;
	var arr = new Array;
	for(i in x){
		arr.push(x[i].innerHTML);
	}
	var arr2 = new Array;
	var y = 0;
	for(y; y<= arr.length;y++){
		var temp = y+1;
		if(arr[temp]=="Sales"){
			console.log(arr[y]);
			arr2.push(arr[y]);
		}
	}
	return arr2;
} 



//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
function getAnchorChildren(){
	var aList = document.getElementsByTagName("a");
	for(i of aList){
		var span = i.getElementsByTagName('span');
		if(span.length > 0){
			for(x of span){
				console.log(x.textContent);
			}
		}
	}
}
getAnchorChildren();


//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
function getHobbies(){
	var s = document.getElementsByName('skills')[0];
	var text = s.options[s.selectedIndex].text;
	console.log(text);
}
getHobbies();






//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
function getCustomAttribute(){
	var cust = document.getElementsByTagName('*');
	for(i of cust){
		if(i.hasAttribute('data-customAttr')){
			console.log(i.getAttribute('data-customAttr'));
		}
	}
}
getCustomAttribute();


//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element
var num1 = document.getElementById('num1');
var num2 = document.getElementById('num2');
var sum = document.getElementById('sum');
num1.value = 'NUM1';
num2.value = 'NUM2';
num1.onchange = updateSum;
num2.onchange = updateSum;
function updateSum() {
    var result = parseInt(num1.value) + parseInt(num2.value);
    if (Number.isNaN(result)) {
        sum.innerHTML = 'Cannot add';
    } else {
        sum.innerHTML = result;
    }
}


//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
var skillEvent = document.getElementsByName('skills')[0];
skillEvent.onchange = function() {
    confirm('Do you want ' + skillNode.value + ' as one of your skills?');
};


//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
function chkColor(){
	var colo = document.querySelector('input[name="favoriteColor"]:checked').value;
	if(colo == "green"){
		alert("This color is not that great!");
		document.getElementById("radioColo").style.backgroundColor ='green';
	}else if(colo == "orange"){
		alert("RIDDLE! What ryhmes with orange?");
		document.getElementById("radioColo").style.backgroundColor ='orange';
	}
}
document.getElementById("radioColo").addEventListener("click", chkColor, false);



//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.
var empList = document.getElementsByClassName('empName');
for(let i of empList){
	empList[i].addEventListener("mouseover", function show(){
		this.style.display = 'none';
	}, false);
	
	empList[i].addEventListener("mouseout", function hide(){
		this.style.display = 'block';
	}, false);
}



//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
function showCurrentTime(){
	var date = new Date();
	document.getElementById("currentTime").innerHTML = date.getHours() + ":" +date.getMinutes() + ":" + date.getSeconds();
}
setInterval(function(){ showCurrentTime() }, 1000);




//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
function changeColor(){
	var clr = "#"+((1<<24)*Math.random()|0).toString(16);
	document.getElementById("helloWorld").style.color = clr;
}
document.getElementById("helloWorld").addEventListener("click", changeColor, false);




//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
function walkTheDOM(node, func) {
    func(node);

    var child = node.childNodes;
    for (let c of child) {
        walkTheDOM(c, func);
    }
}
walkTheDOM(document, function(node) { console.log(node); } );

