function add ()
{
	
	var id = document.getElementById("t_id").value;
	var name = document.getElelmentById("t_name").value;
	var major = document.getElelmentById("t_major").value;
	
	
	var row = document.createElement("tr");
	
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	
	
	cell1.innerHTML = id;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	document.getElementById("students").appendChild(row);
	
}

document.getElementById("add").addEventListener("click", add);