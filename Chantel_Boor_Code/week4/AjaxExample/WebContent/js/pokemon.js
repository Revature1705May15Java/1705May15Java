var pokemonVar;

function getPokemon ()
{
	var pokemonId = document.getElementById("pokemonId").value;
	console.log("sending pokemon id" + pokemonId);
	
	//step 1 : open XHR
	var xhttp = new XMLHttpRequest();
	//typiccally we will use this to store JSON
	
	//step 2: write functio to handle readstatechange
	xhttp.onreadystatechange = function (){
		if(xhttp.readyState == 4 && xhttp.status == 200)
		{
			var pokemon = JSON.parse(xhttp.responseText);
			setValues(pokemon);
			pokemonVar= pokemon;
		}
	};
	
	//step 3 open Xhttp
	xhttp.open("GET","http://pokeapi.co/api/v2/pokemon/"+pokemonId,true);
	
	//step 4 send
	xhttp.send();//post our data w. get method
}

function setValues(pokemon)
{
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	
	var t = pokemon.types;
	var tStr = "";
	
	for(var i = 0; i<t.length;i++)
	{
		tStr += t[i].type.name + " ";
	}
	
	document.getElementById("pokemonType").innerHTML = "Type: "  + tStr;
	tStr = "";
	
	var c = pokemon.types[0];
	console.log(c);
	
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("alt",pokemon.name);
	pokeImg.setAttribute("src",pokemon.sprites.front_default);
}


window.onload = function ()
{
	document.getElementById("pokemonSubmit").addEventListener("click",getPokemon);
}