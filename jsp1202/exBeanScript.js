/**
 * 
 */
function inputCheck(){
	var userinput = eval("document.regForm");
	if(userinput.idvalue == ""){
		alert("ID");
		userinput.id.focus();
		return false;
	}
	
	if(userinput.passwd.value == ""){
		alert("PASSWORD");
		userinput.passwd.focus();
		return false;
	}
	
	if(userinput.passwd.value == ""){
		alert("���");
		userinput.repasswd.focus();
		return false;
	}
	if(userinput.name.value == ""){
		alert("�̸�");
		userinput.name.focus();
		return false;
	}
	if(userinput.email.value == ""){
		alert("�̸���");
		userinput.email.focus();
		return false;
	}	
	if(userinput.passwd.value != userinput.repasswd.value){
		alert("���");
		userinput.repasswd.focus();
		return false;
	}
}
