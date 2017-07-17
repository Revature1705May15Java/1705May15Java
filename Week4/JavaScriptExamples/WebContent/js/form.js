/**
 * Form Javascript for adding students
 */

function add(){
	
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
	
	//Append the cells to the row
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	//add text
	cell1.innerHTML = id;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	
	//append to the table
	document.getElementById("students").appendChild(row);
}


function addStudentToDatabase(){
	//Element Values
	var id = document.getElementById("t_id").value;
	var name = document.getElementById("t_name").value;
	var major = document.getElementById("t_major").value;
	
	//Create input tags
	var input_user_id = document.createElement("input");
	var input_user_name = document.createElement("input");
	var input_user_major = document.createElement("input");
	
//	<input id="id" name="id" value="1">
	//Set Attributes
	input_user_id.name = "id";
	input_user_id.value = id;
	
	input_user_name.name = "name";
	input_user_name.value = name;
	
	input_user_major.name = "major";
	input_user_major.value = major;
	
	//Append to the form
	document.getElementById("studentForm").appendChild(input_user_id);
	document.getElementById("studentForm").appendChild(input_user_name);
	document.getElementById("studentForm").appendChild(input_user_major);
	//add a break
	document.getElementById("studentForm").appendChild(document.createElement("br"));
	
	//Reset Form values
	document.getElementById("t_id").value = "";
	document.getElementById("t_name").value ="";
	document.getElementById("t_major").value = "";
}


//Add event listener to document
//document.getElementById("add").addEventListener("click", addStudentToDatabase, false);