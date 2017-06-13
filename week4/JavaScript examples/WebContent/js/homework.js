//Javascript Homework
//Due Friday @ 9PM
//-----------------------------------------------------------------------------------
//PART I
//Create a single Javascript file called homework.js to answer these questions.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------


//1. Fibonacci
//Define function: fib(n)
//Return the nth number in the fibonacci sequence.
function fib(n){
	var num1=0;
	var num2=1;
	var num3=0;
	for(i=1;i<n-1;i++){
		num3=num1+num2;
		num1=num2;
		num2=num3;
	}
	if(n==0){
		return 0;
	}else{
		return num2;
	}
}
//document.getElementById("fib").innerHTML=fib(5);

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(unsortedarray){
	var nosort=true;
	for(i=0;i<unsortedarray.length-1;i++){
		var firstnum=unsortedarray[i];
		var secondnum=unsortedarray[i+1];
		if(firstnum>secondnum){
			unsortedarray[i]=secondnum;
			unsortedarray[i+1]=firstnum;
			nosort=false;
		}
		if(i==unsortedarray.length-2&&nosort==false){
			bubbleSort(unsortedarray);
		}
	}

	return unsortedarray.join();
}
//var unsorted=[3,1,2,5,6,4];
//document.getElementById("fib").innerHTML=bubbleSort(unsorted);

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr){
	var outstr ="";
	var len=someStr.length;
	for(i=0;i<len;i++){
		outstr=outstr+someStr.charAt(len-i-1);
	}
	return outstr;
}
//document.getElementById("fib").innerHTML=reverseStr("whales");

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(n){
	if(n==1||n==0){
		return 1;
	}else if(n>1){
		return n*factorial(n-1);
	}else if(n<0){
		return -1;
	}
}
//document.getElementById("fib").innerHTML=factorial(6);

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr,length,offset){
	var strout;
	if((typeof someStr)=='string'){
		return someStr.substring(offset,offset+length+1);
	}else{
		alert("incorrect data type!");
	}
}
//document.getElementById("fib").innerHTML=substring("whales",3,2);

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum){
	if((-1)^(someNum)==1){
		return true;
	}else{
		return false;
	}
}

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){

	for(i=0;i<Floor((someStr.length)/2);i++){
		if(someStr.charAt(i)!=someStr.charAt(someStr.length-1-i)){
			return false;
		}
	}
	return true;
}


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
function printShape(shape,height,character){
	var linenum=1;
	var linestr="";
	var spacestr="";
	var linesize;
	var strout;
	var spacechar=" ";
	if(shape=='Square'){
		linestr=character.repeat(height);
		for(i=0;i<height;i++){
				console.log(linestr);
		}
	}
	if(shape=='Diamond'){
		var c=Math.ceil(height/2);
		for(i=1;i<height+1;i++){
			if(i>=c){
				var spacesize=i-c;
				var linesize=2*c-1-(i-c)*2;
			}else{
				var linesize=2*i-1;
				var spacesize=c-i;
			}
			spacestr=' '.repeat(spacesize);
			linestr=character.repeat(linesize);
			strout=spacestr+linestr;
			console.log(strout);
		}
	}
	if(shape=='Triangle'){
		for(i=1;i<height+1;i++){
			var linesize=i;
			linestr=character.repeat(linesize);
			console.log(linestr);
		}
	}
}

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj){
	for(var property in someObj){
		console.log(property+" "+someObj[property]);
	}
}


//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
function deleteElement(someArr){
	console.log(someArr.length);
	delete someArr[2];
	console.log(someArr.length);
}


//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
function spliceElement(someArr){
	console.log(someArr.length);
	someArr.splice(3,1);
	console.log(someArr.length);
}


//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//    var john = new Person("John", 30);
function Person(name,age){
	var Person={
			"name":name,
			"age":age
	}
	return Person;
}


//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//    var john = getPerson("John", 30);
function getPerson(name,age){
	var Person={
			"name":name,
			"age":age
	}
	return Person;
}



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
function getUSA(){
	var elems = document.body.getElementsByTagName("*");
	for(i=0;i<elems.length;i++){
		if(elems[i].innerHTML=="USA"){
			console.log(elems[i]);
		}
	}
}
//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
function getPeopleInSales(){
	var elems = document.body.getElementsByTagName("td");
	for(i=0;i<elems.length;i++){
		//if(elems[i].innerHTML=="Sales"){
			console.log(elems[i].innerHTML);
		//}
	}
}

//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
function getAnchorChildren(){
	var elems = document.body.getElementsByTagName("a");
	for(i=0;i<elems.length;i++){
		if(elems[i].hasChildNodes()){
			var elems2=elems[i].childNodes;
			for(j=0;j<elems2.length;j++){
				// console.log(elems2[j].tagName);
				if(elems2[j].tagName=="SPAN")
				console.log(elems2[j].innerHTML);
				}
		}
	}
}
//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
function getHobbies(){
	var elems = document.getElementsByName('skills')[0].options;
	for(i=0;i<elems.length;i++){
		if(elems[i].selected){
			console.log(elems[i].innerHTML);
		}
	}
}

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
function getCustomAttribute(){
	var elems = document.body.getElementsByTagName("*");
	for(i=0;i<elems.length;i++){
		if(elems[i].getAttribute("data-customAttr")!==null){
			console.log(elems[i].getAttribute("data-customAttr"));
		}
	}
}

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
function hw6(){
	var num1=+document.getElementById('num1').value;
	var num2=+document.getElementById('num2').value;
	if(!isNaN(num1)&&!isNaN(num2)){
		var sum = 0;
		sum=sum+num1+num2;
		document.getElementById('sum').innerHTML=sum;
	}else{
		document.getElementById('sum').innerHTML="Cannot add";
	}
}


//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//    "Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
function hw7(){
	var elems = document.getElementsByName('skills')[0].options;
	for(i=0;i<elems.length;i++){
		if(elems[i].selected){
			alert("Are you sure "+elems[i].innerHTML+" is one of your skills?");
		}
	}
}


//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//    "So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor



//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//    Hide the name if shown.
//    Show the name if hidden.


//10. Current Time
//Regarding this element:
//    <h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.


//11. Delay
//Regarding this element:
//    <p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.


//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
