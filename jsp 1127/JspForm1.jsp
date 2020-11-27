<%@ page contentType = "text/html; charset=euc-kr"	%>

<html>
<head><title> Make a form</title></head>

폼에 데이터를 입력후 전송버튼 클릭

<form action="./requestview1.jsp" method="post">
<!-- action경로 지정방법 -->
<!-- ./ ~.jsp 				--같은 폴더 .하나당바깥폴더
	~.jsp					--같은 폴더
	http://localhost~~.jsp 	--주소
	(URI) WebPjt/jsp 1127/~~.jsp  --URI -->
	
이름: <input type="text" name="name" size="10"> <br>
주소: <input type="text" name="address" size="30"> <br>
좋아하는 동물:
<input type="checkbox" name="pet" value="dog">강아지
<input type="checkbox" name="pet" value="cat">고양이
<input type="checkbox" name="pet" value="pig">돼지 <br>
<!-- 15~20라인 요청파라미터 생성 -->
<input type="submit" value="전송">
</form>

</html>