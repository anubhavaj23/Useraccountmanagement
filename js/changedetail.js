function Function(){
	if((document.getElementById("name").value) == null || (document.getElementById("name").value) =="" || (document.getElementById('age').value) == null || (document.getElementById('age').value) == "" || (document.getElementById('addr').value) == null || (document.getElementById('addr').value) == "" || (document.getElementById('city').value) == null || (document.getElementById('city').value) == "" || (document.getElementById('state').value) == null || (document.getElementById('state').value) == "" || (document.getElementById('postcode').value) == null || (document.getElementById('postcode').value) == "" || (document.getElementById('contactnum').value) == null || (document.getElementById('contactnum').value) == ""){
		console.log(document.getElementById('name').value+"");
		alert("Please fill all the details");
		return false;
	}
	return true;
}