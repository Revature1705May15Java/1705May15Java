//Javascript Homework: Chantel Boor
//Due Friday @ 9PM
//Put all homework in:
//    ....Firstname_Lastname_Code/Week4/Javascript_Homework/
//-----------------------------------------------------------------------------------
//PART I
//Create a single Javascript file called homework.js to answer these questions.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------
//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.

function fib (n)
{
	
	var a  = 1,
		b = 0,
		temp;
	
	while(n >0)
	{
		temp = a;
		a = a+b;
		b = temp;
		n--;
	}
	
	return b;
}


function dofib ()
{
	var display = document.getElementById ("fib");
	var input = document.getElementById("test_f").value;
	display.innerHTML = fib(input);
}


document.getElementById("test_b_f").addEventListener("click",dofib);

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.


var a = [34, 203, 3, 746, 200, 984, 198, 764, 9];

function bubbleSort(a)
{
    var swapped;
    do {
        swapped = false;
        for (var i=0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                var temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
}
 
bubbleSort(a);

elem = document.getElementById("sort");
elem.innerHTML = a;

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

function reverse(someStr)
{
	var revStr;
	var x = someStr.length - 1;

	for(var i= x; i>=0;i--)	
    {
		if(i == x)
		revStr = someStr[i];
		else
		revStr += someStr[i];
    }

	return revStr;
	
}

function doreverse ()
{
	var display = document.getElementById ("reverse");
	var input = document.getElementById("test_r").value;
	display.innerHTML = reverse(input);
}


document.getElementById("test_b_r").addEventListener("click",doreverse);

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.


function fact(num)
{
	var temp = 1;
	
	for(var i = num; i > 0; i--)
	{
		temp = temp * i;
	}
		
	return temp;
}


function dofact ()
{
	var display = document.getElementById ("factorial");
	var input = document.getElementById("test_fact").value;
	display.innerHTML = fact(input);
}


document.getElementById("test_b_fact").addEventListener("click",dofact);




//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.





//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

function even(num)
{
	var result = true;
	var temp = num/2;
	
	var x = Math.floor(temp);
	x = x *2;
	
	//changes to false for odd numbers
	if(x<num)
	{
		result = false;
	}
	
	return result;
	
}


function doEven()
{
	var display = document.getElementById("ev");
	var input = document.getElementById("test_e").value;
	display.innerHTML = even(input);
}


document.getElementById("test_b_e").addEventListener("click",doEven);



//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function pali (someStr,revStr)
{
	var isPali = false;
	
	if(someStr == revStr)
		isPali = true;
		
	return isPali;
}

function doPali()
{
	var display = document.getElementById("p");
	var input = document.getElementById("test_p").value;
	var input2 = reverse(input);
	display.innerHTML = pali(input,input2);
}


document.getElementById("test_b_p").addEventListener("click",doPali);

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

function shape(shape,height,char)
{

	shape = shape.toLowerCase();

	switch(shape)
	{
	case "diamond":
	{

		var line = "";
		var odd = 1;
		var nos = height/2;
		nos = Math.floor(nos);
		
		var half = nos + 1;

		for (var i = 1; i <= height; i++) 
		{ 
			for (var k = nos; k >= 1; k--) 
			{ 

				line += " ";
			}
			for (var j = 1; j <= odd; j++) 
			{

				line += char;
			}

			console.log(line);
			line = "";

			if (i < half) 
			{
				odd += 2; 
				nos -= 1; 
			} 
			else 
			{
				odd -= 2; 
				nos += 1; 

			}
		}

		break;
	}
	case "triangle":
	{
		var line = "";

		for(var i = 0; i<height;i++)
		{
			for(var j = 0; j<=i;j++)
			{
				line += char;
			}

			console.log(line);
			line = "";

		}
		break;
	}
	case "square":
	default:
	{
		var line = "";

		for(var i = 0; i<height;i++)
		{
			for(var j = 0; j<height;j++)
			{
				line += char;
			}

			console.log(line);
			line = "";

		}
	}

	}
}

function doShape()
{
	var input = document.getElementById("test_shape").value;
	var input2 = document.getElementById("test_height").value;
	var input3 = document.getElementById("test_char").value;
	
	shape(input,input2,input3);
}


document.getElementById("test_b_shape").addEventListener("click",doShape);

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

function traverseObj(someObject)
{
	var txt = "";
	var obj = someObject;
	var x;
	for (x in obj) 
	{
	    txt += obj[x] + " ";
	}
	
	return txt;
}

var person = {Name:"Chantel",Age:23};

document.getElementById('tobject').innerHTML = traverseObj(person);



//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

var sa = ["cat","dog","cow","bat","fly"];

elem = document.getElementById("bDelete");
elem.innerHTML = sa.length;

function deleteE(someArr)
{
	delete(someArr[0]);
	var x = someArr.length;
	return x;
}

elem = document.getElementById("aDelete");
elem.innerHTML = deleteE(sa);


//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

var sa2 = ["cat","dog","cow","bat","fly"];

elem = document.getElementById("bSplice");
elem.innerHTML = sa2.length;

function spliceE(someArr)
{
	someArr.splice(2,1);
	var x = someArr.length;
	return x;
}

elem = document.getElementById("aSplice");
elem.innerHTML = spliceE(sa2);


//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//    var john = new Person("John", 30);


function getPerson(n,a)
{
	function person(first, age) 
	{
	    this.firstName = first;
	    this.age = age;
	}
	
	var p = new person(n,a);
	return p;
	
}

var jhon = getPerson("jhon",30);


//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//    var john = getPerson("John", 30);

function getPerson(n,a)
{
	var person = {Name:n,Age:a};
	return person;
}

var jhon = getPerson("jhon",30);
