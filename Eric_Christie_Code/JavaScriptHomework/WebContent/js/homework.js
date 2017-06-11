/**
 * Javascript Homework
 * @due 9pm on Friday, June 9, 2017
 * @author Eric Christie
 */

/*
-----------------------------------------------------------------------------------
PART I
Create a single Javascript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
*/
// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
  if (n === 1) {
    return 0;
  } else if (n === 2) {
    return 1;
  } else {
    return fib(n-1) + fib(n-2);
  }
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
  let changed = false;
  for (let end = numArray.length - 1; end > 0; end--) {
    for (let i = 0; i < numArray.length - 1; i++) {
      let current = numArray[i];
      if (current > numArray[i + 1]) {
        numArray[i] = numArray[i + 1];
        numArray[i + 1] = current;
        changed = true;
      }
    }
    if (!changed) {
      return numArray;
    }
  }
  return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
const reverseStr = function(someStr) {
  let result = '';
  for (let i = someStr.length - 1; i >= 0; i--) {
    result += someStr[i];
  }
  return result;
};

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
  return (someNum === 1) ? 1 : someNum * factorial(someNum - 1);
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
const substring = (someStr, length, offset) => {
  if (typeof(someStr) !== 'string') {
    window.alert('first input must be a string');
  } else if (typeof(length) !== 'number') {
    window.alert('length must be a number');
  } else if (typeof(offset) !== 'number') {
    window.alert('offset must be a number');
  } else if (offset < 0 || offset >= someStr.length) {
    window.alert('offset must be between 0 and the length of the input string');
  } else if (length <= 0 || length >= someStr.length - offset) {
    window.alert('length must be between 1 and the length of the input string minus the offset');
  } else {
    let result;
    for (let i = offset; i <= length; i++) {
      result += someStr[i];
    }
    return result;
  }
};

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
const isEven = (someNum) => {
  return someNum.toString().endsWith('0') || someNum.toString().endsWith('2') || someNum.toString().endsWith('4')
      || someNum.toString().endsWith('6') || someNum.toString().endsWith('8');
};

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
  return someStr === reverseStr(someStr);
}

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *
function printShape(shape, height, char) {
  let result = '';
  if (shape === 'Square') {
    result = (char.repeat(height) + '\n').repeat(height);
  } else if (shape === 'Triangle') {
    for (let i = 1; i <= height; i++) {
      result += char.repeat(i) + '\n';
    }
  } else if (shape === 'Diamond') {
    let i;
    for (i = 1; i <= height; i+=2) {
      let pad = (height-i)/2;
      result += ' '.repeat(pad) + char.repeat(i) + ' '.repeat(pad) + '\n';
    }
    for (i = height - 2; i >= 1; i-=2) {
      let pad = (height-i)/2;
      result += ' '.repeat(pad) + char.repeat(i) + ' '.repeat(pad) + '\n';
    }
  } else {
    result = "please input either 'Square', 'Triangle', or 'Diamond'";
  }
  console.log(result);
  return result;
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(obj) {
  let result = '';
  for (let prop in obj) {
    let val = obj[prop];
    console.log(`${prop}: ${val}`);
    result += `${prop}: ${val}\n`
  }
  return result;
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
const deleteElement = (arr) => {
  let result = {before: arr.length};
  console.log(arr.length);
  delete arr[2];
  console.log(arr.length);
  result.after = arr.length;
  return result;
};

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
const spliceElement = function(arr) {
  let result = {before: arr.length};
  console.log(arr.length);
  let third = arr.splice(2, 1);
  console.log(arr.length);
  result.after = arr.length;
  return result;
};

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age) {
  // speak = () => { console.log('hello') };
  return {
    name: name,
    age: age
  };
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
 function getPerson(name, age) {
   return {
     name: name,
     age: age
   };
 }
 
/*
-----------------------------------------------------------------------------------
PART II
Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.
NOTE: Part II will be done twice: once with Javascript and once with jQuery.
	  They should be done separately.
	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
-----------------------------------------------------------------------------------
*/

// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA(useJQuery) { 
  if (useJQuery) {

  } else {
    document.querySelectorAll('*').forEach((elem) => {
      if (elem.innerHTML == 'USA') {
        console.log('1. ' + elem.innerHTML);
      }
    });
  }
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales(useJQuery) {
  if (useJQuery) {

  } else {
    document.querySelectorAll('tr td').forEach((elem) => {
      if (elem.innerHTML == 'Sales') {
        console.log('2. ' + elem.previousElementSibling.innerHTML);
      }
    });
  }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren(useJQuery) {
  if (useJQuery) {

  } else {
    document.querySelectorAll('a span').forEach((elem) => {
      console.log('3. ' + `contents: ${elem.innerHTML}`);
    });
  }
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies(useJQuery) {
  if (useJQuery) {

  } else {
    document.querySelectorAll('select[name="skills"] :checked').forEach((elem) => {
      console.log('4. ' + `value: ${elem.value}, contents: ${elem.innerHTML}`);
    });
  }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute(useJQuery) {
  if (useJQuery) {

  } else {
    document.querySelectorAll('[data-customAttr]').forEach((elem) => {
      console.log('5. ' + `data-customAttr: ${elem.getAttribute('data-customAttr')}, element: ${elem}`);
    });
  }
}

/*6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>
Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element*/
function setupSumEvent(useJQuery) {
  if (useJQuery) {

  } else {
    let in1 = document.getElementById('num1');
    let in2 = document.getElementById('num2');
    let out = document.getElementById('sum');
    document.querySelectorAll('.nums').forEach((elem) => {
      elem.addEventListener('change', function(){
        result = Number.parseFloat(in1.value) + Number.parseFloat(in2.value);
        if (Number.isNaN(result)) {
          out.innerHTML = 'Cannot add';
        } else {
          out.innerHTML = result;
        }
      });
    });
  }
}
// I think this is a situation where the <output> element is a better option

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
function setupSkillsEvent(useJQuery) {
  if (useJQuery) {

  } else {
    document.getElementsByName('skills').forEach((elem) => {
      elem.addEventListener('change', function() {
        window.confirm(`Are you really skilled with ${this[this.selectedIndex].innerHTML}? Really?`);
      }, false);
    });
  }
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
let changeCount = 0;
var currentColor;
function setupFavoriteColorEvent(useJQuery) {
  if (useJQuery) {

  } else {
    let colorOpts = document.querySelectorAll('[name="favoriteColor"]');
    colorOpts.forEach((elem) => {
      elem.addEventListener('change', function() {
        window.alert(`Changing color preference from ${currentColor} to ${elem.value}.`);

        currentColor = elem.value;
        colorOpts.forEach((elem) => {
          elem.style = `background-color: ${currentColor};`
        });
      });
    });
  }
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.
function setupShowHide(useJQuery) {
  if (useJQuery) {

  } else {
    let names = document.querySelectorAll('.empName');
    names.forEach((elem) => {
      elem.addEventListener('mouseover', function() {
        // console.log('over')
        elem.style.visibility = 'hidden';
      });
    });
    names.forEach((elem) => {
      elem.addEventListener('mouseout', function() {
        elem.style.visibility = 'visible';
      })
    })
  }
}

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
function setupCurrentTime(useJQuery) {
  if (useJQuery) {

  } else {
    setInterval(function() {
      let now = new Date();
      document.getElementById('currentTime').innerHTML = now.toLocaleTimeString('en-US');
    }, 500);
  }
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
function setupDelay(useJQuery) {
  if (useJQuery) {

  } else {
    document.getElementById('helloWorld').addEventListener('click', function() {
      setTimeout(() => {
        window.alert('hello');
        let color = '#' + Math.floor(Math.random() * 16777215).toString(16);
        document.getElementById('helloWorld').style.color = color;
      }, 3000);
    });
  }
}

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
function DOMWalk(useJQuery) {
  if (useJQuery) {
    function walkTheDOM(node, func) {
      func(node);
    }

  } else {
    function walkTheDOM(node, func) {
      func(node);
      node.querySelectorAll('*').forEach((elem) => walkTheDOM(elem, func));
      // let child = children.item()
      // for (let i = 0; i < children.length; i++) {
      //   walkTheDOM(children[i], func);
      // }
    }
    let elemCount = 0;
    walkTheDOM(document, (elem) => {
      elemCount++
    });
    console.log(elemCount);
  }
}