function writeSave(){
	if(document.writeform.writer.value == ""){
		alert("�ۼ����Է�");
		document.writeform.writer.focus();
		return false;
	}
	
	if(document.writeform.subject.value == ""){
		alert("�����Է�");
		document.writeform.subject.focus();
		return false;
	}
	
	if(document.writeform.content.value == ""){
		alert("�����Է�");
		document.writeform.content.focus();
		return false;
	}
	
	if(document.writeform.passwd.value == ""){
		alert("����Է�");
		document.writeform.passwd.foucs();
		return false;
	}
	
	
}