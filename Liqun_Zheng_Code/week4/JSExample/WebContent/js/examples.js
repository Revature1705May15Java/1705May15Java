//var parags = document.getElementsByTagName("p");
////var pString = parags.join(" - ");
//
//var inner;
//
//for(i = 0; i < parags.length; i++){
//	inner.push(parags[i].innerHTML);
//}
//
//document.getElementById("display").innerHTML = inner[1].innerHTML;
function cou(n){
	return n+1;
}
var count =0;
function add(){
	count = cou(count);
	//Element Values
	var id = document.getElementById("t_id").value;
	var name = document.getElementById("t_name").value;
	var major = document.getElementById("t_major").value;
	
	//Create Row Element
	var row = document.createElement("tr");
	
	//Create Row Cells
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	var cell4 = document.createElement("td");
	
	//Append the cells to the row
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	
	//add text
	cell1.innerHTML = id;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	cell4.innerHTML = count;

	//append to the table
	document.getElementById("students").appendChild(row);
}

document.getElementById("add").addEventListener("click", add, false);



