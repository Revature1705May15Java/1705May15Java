//var parags = document.getElementsByTagName("p");
////var pString = parags.join(" - ");
//
//var inner;
//
//for(i = 0; i< parags.length; i++){
//	inner.push(parags[i].innerHTML);
//}
//
//document.getElementById("display").innerHTML = parags[0].innerHTML;
//
//
//var friends = ["I", "have", "no", "friends"];
//
//friends.forEach(function(eachName, index){
//	console.log(index + 1 + "." + eachName);
//});
//
var count = 0;
function makeCounter(myTypeOfCounter){
	var count = 0;
	return function(){
		count++;
		return count +" " + myTypeOfCounter + "s";
	}
}

function add(){
	count++;
	document.getElementById("Counter").innerHTML = "Count = " + count;
	var id = document.getElementById("tid").value;
	var name = document.getElementById("tname").value;
	var major = document.getElementById("tmajor").value;
	
	var row = document.createElement("tr");
	
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	cell1.innerHTML = id;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	
	document.getElementById("students").appendChild(row);
	
	
	
}
document.getElementById("add").addEventListener("click", add, false);


function hoverCounter(){
		count++;
		document.getElementById("counter").innerHTML = count;
		
	
}
	document.getElementById("counter").addEventListener("click", hoverCounter, false);
