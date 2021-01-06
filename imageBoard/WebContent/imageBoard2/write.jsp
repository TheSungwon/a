<%@page import="Image.ImageUtil"%>
<%@page import="fileUpload.FileUploadRequestWrapper"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="DTO.Theme"%>
<%@page import="DAO.ThemeManager"%>
<%@page import="Exception.ThemeManagerException"%>

<%
FileUploadRequestWrapper requestWrap = new FileUploadRequestWrapper(request, -1, -1, "C:\\Users\\sungw\\Desktop\\Java\\imageBoard\\WebContent");
HttpServletRequest temRequest = request;
request = requestWrap;
%>

<jsp:useBean id="theme" class="DTO.Theme"><jsp:setProperty name="theme" property="*"/>
</jsp:useBean>

<%
FileItem imageFileItem = requestWrap.getFileItem("imageFile");
String image="";

if(imageFileItem.getSize() >0){
	image = Long.toString(System.currentTimeMillis());
	
	//이미지를 지정한 경로에 저장
	File imageFile = new File("C:\\Users\\sungw\\Desktop\\Java\\imageBoard\\WebContent\\image",image);
	
	//같은 파일이름 처리
	if(imageFile.exists()){
		for(int i =0; true; i++){
			imageFile = new File("C:\\Users\\sungw\\Desktop\\Java\\imageBoard\\WebContent\\image",image+"_"+i);
			if(!imageFile.exists()){
				image = image +"_" +i;
				break;
			}
		}
	}
	
	imageFileItem.write(imageFile);
	
	//썸넬 이미지생성
	File destFile =new File("C:\\Users\\sungw\\Desktop\\Java\\imageBoard\\WebContent\\image",image+".small.jpg");
	
	ImageUtil.resize(imageFile, destFile, 50, ImageUtil.RATIO);
}
theme.setRegister(new Timestamp(System.currentTimeMillis()));
theme.setImage(image);

ThemeManager manager = ThemeManager.getInstance();
manager.insert(theme);
%>
<script>
alert("image");
location.href="list.jsp";
</script>
