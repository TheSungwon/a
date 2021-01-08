function writeSave(){
	if(document.writeform.writer.value == ""){
		alert("작성자입력");
		document.writeform.writer.focus();
		return false;
	}
	
	if(document.writeform.subject.value == ""){
		alert("제목입력");
		document.writeform.subject.focus();
		return false;
	}
	
	if(document.writeform.content.value == ""){
		alert("내용입력");
		document.writeform.content.focus();
		return false;
	}
	
	if(document.writeform.passwd.value == ""){
		alert("비번입력");
		document.writeform.passwd.foucs();
		return false;
	}
	
	
}