/**
 * 
 */
//function fib(n){
//	var num = 0;
//	var num2 = 1; 
//	var temp = 1; 
//	for(i = 0; i < n-2; i++)
//	{
//		num += num2; 
//		num2 = temp; 
//		temp = num; 
//	}
//	return num;
//}

function add()
{
	var id = document.getElementById("t_id").value;
	var name = document.getElementById("t_name").value;
	var major = document.getElementById("t_major").value; 
	
	var row = document.createElement("tr"); 
	
	var cell = document.createElement("td"); 
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	
	row.appendChild(cell); 
	row.appendChild(cell2); 
	row.appendChild(cell3); 
	
	cell.innerHTML = id; 
	cell2.innerHTML = name; 
	cell3.innerHTML = major; 
	
	document.getElementById("students").appendChild(row); 
}

document.getElementById("add").addEventListener("click", add, false); 

function count()
{	
	
}

document.getElementbyId("add").addEventListener("click", count, false); 



//
//elem = document.getElementById("fib"); 
//elem.innerHTML=fib(4);
//
//var parags = document.getElementsByTagName("p"); 


//document.getElementById("display").innerHTML = parags[0].innerHTML;

//var x = fib(5); 
//elem.appendChild(x); 
