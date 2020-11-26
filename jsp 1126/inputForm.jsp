<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C"DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>회원가입</title>

<link href="style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function checkit(){
	var userinput = eval("document.userinput");
	if(!userinput.id.value){
		alert("id입력 해");
		return false;
	}
	
	if(!userinput.passwd.value){
		alert("비번입력해");
		return false;
	}
	
	if(!userinput.passwd.value !=userinput.passwd2.value){
		alert("비번같아");
		return false;		
	}
	
	if(!userinput.jumin1.value || !userinput.jumin2.value){
		alert{"주민입력"};
		return false;
	}
}

</script>
</head>
<body>
<div id="wrap">
	<form action="inputPro.jsp" name="userinput" onsubmit="return checkit()" method="post">
		<h1>회원가입<h1>
		<div id="body">
			<table width="500px;">
				<colgroup>
					<col width="20%"/>
					<col width="*"/>
				</colgroup>
				
				<tr>
					<th colspan="2" class="subTitle">*아이디입력</th>
				</tr>
				
				<tr>
					<th>사용자아아이디</th>
					<td>
						<input type="text" name="id" maxlength="12"/>
						<input type="button" name="confirm_id" value="아이디중복확인" class="inputBtn" onclick="javascript:openConfirmid(this.form);"/></td>
				</tr>
				
				<tr>
					<th>비번확인</th>
					<td><input type"password" name="passwd2" maxlength="12"/></td>
				</tr>
				
				<tr>
					<th colspan="2" class="subTitle">*개인정보입력</th>
				</tr>
				
				<tr>
					<th>사용자이름</th>
					<td><input type="text" name="name" maxlength="10"/></td>
				</tr>
				
				<tr>
					<th>주민번호</th>
					<td>
						<input type="text" name="jumin1" maxlength="6" /> -
						<input type="password" name="jumin2" maxlength="7"/>
					</td>
					
				</tr>
				
				<tr>
					<th>email</th>
					<td><input type="text" name="email" class="w300" maxlength="30"/></td>
				</tr>
				
				<tr>
					<th>blog</th>
					<td><input type="text" name="blog" class="w300" maxlength="50"/></td>
				</tr>
				
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" name="zipcode"/><input type="button" value="우편검색" class="inputBtn" onclick="javascript:zipCheck();"/>
						<span>우편번호입력</span>
					</td>
				</tr>
				
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="address" class="w380"/>
						<span class=descB>주소입력 </span>
					</td>
				</tr>
					
										
			</table>
		</div>
		
		<div id="footer">
			<input type="submit" name="confirm" class="inputBtn" value="등록"/>
			<input type="reset" name="reset" class="inputBtn" value="다시입력"/>
			<input type="button" value="취소" class="inputBtn" onclick="javascript:window.location='main.jsp'"/>
		</div>
	</form>
</div>
</body>
</html>