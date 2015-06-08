
function addField() {
	var newDiv = document.createElement("div");
	newDiv.innerHTML = '<br><input type="file" name="file"><br>';
	document.getElementById("fieldHolder").appendChild(newDiv);	
}