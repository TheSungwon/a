package BEAN;

import java.util.Date;

public class javaBeanMem {
	
	//자바빈 클래스. 회원정보를 저장. 프로퍼티 목록
	
private String id;
private String password;
private String name;
private String address;
private String email;
private Date registerDate;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getRegisterDate() {
	return registerDate;
}
public void setRegisterDate(Date registerDate) {
	this.registerDate = registerDate;
}

}
