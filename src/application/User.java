package application;

import java.util.regex.*;

public class User {
	private String address;
	private String name;
	private String password;

	
	public User(String name,String address,String password) {
		this.name=name;
		if(!(verifPas(password))) {
            throw new IllegalArgumentException("Invalid Email format !");
		}
		if(!(verifEmail( address))) {
            throw new IllegalArgumentException("Password must have a minimum length of 8 characters!");
		}
		this.address=address;
		this.password=password;
	}
	


	//--------hethouma getters w setters------------
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address; 
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//-------------------------------------------------

	
	//hethouma verification
	public boolean verifPas(String password) {
		if( password.length()<8){
			return false;
		}
		return true;
	}
	public boolean verifEmail(String address) {
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";//style of Email
        Pattern pattern = Pattern.compile(emailRegex);//regular expression pattern to compare the address tchouf style ta3 el Email
        if(address==null) {
        	return false;
        }
        return pattern.matcher(address).matches();//tchouf style el Email
	}

}
