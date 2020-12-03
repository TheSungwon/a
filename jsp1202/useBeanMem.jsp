<%-- 자바빈 객체를 지정해주는 기능은 <jsp:useBean>
jsp: useBean id="bean이름" class="자바빈클래스이름" scope="범위"

id= jsp페이지에서 자바빈 객체에 접근할 때 사용할 이름 명시
class= 패키지이름을 포함한 자바빈 클래스의 완전한 이름 입력
scope= 자바빈 객체가 저장될 영역을 지정 page request session application
중 하나를 값으로 갖는다. 기본값은 page

MemberInfo info = new MemberInfo();
request.setAttribute("info",info); 와 비슷한 코드방식

하지만 유즈빈액션태그는 지정한 영역에 이미 id속성에서 지저한
이름의 속성값이 존재할 경우 객체를 새로 생성하지 않고 기존에
존재하는 객체를 그대로 사용.

객체를 생성할 뿐만 아니라 지정한 영역에 저장을 한다. 이미 영역에
객체가 존재하는 경우 그 객체를 그대로 사용가능
 따라서 유즈빈 액션태그는 각 영역별로 공유할 데이터를 쉽게 저장할수있다
 
  --%>
  <%@ page contentType="text/html; charset=euc-kr"%>
  <jsp:useBean id="a" scope="request" class="BEAN.javaBeanMem"/>
  
  <% a.setId("아이디");
  	 a.setName("이름");
  %>
  
  <jsp:forward page="/jsp1202/useBeanObj.jsp" />
  
<!--  이름이 a인 객체를 생성해서 request기본객체에 저장
 스크립트 코드에서 이 이름을 사용하여 생성한 객체에 접근한다 -->