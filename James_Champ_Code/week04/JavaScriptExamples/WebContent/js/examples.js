function add() {
	var id = document.getElementById("t_id").value;
	var name = document.getElementById("t_name").value;
	var major = document.getElementById("t_major").value;
	
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

var count = 0;
function hoverCounter() {
	count++;
	document.getElementById("count").innerHTML = count;
}

document.getElementById("add").addEventListener("mouseover", hoverCounter, false);