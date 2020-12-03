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
		alert("비번");
		userinput.repasswd.focus();
		return false;
	}
	if(userinput.name.value == ""){
		alert("이름");
		userinput.name.focus();
		return false;
	}
	if(userinput.email.value == ""){
		alert("이메일");
		userinput.email.focus();
		return false;
	}	
	if(userinput.passwd.value != userinput.repasswd.value){
		alert("비번");
		userinput.repasswd.focus();
		return false;
	}
}
