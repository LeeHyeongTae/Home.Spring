package com.lht91.web.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private String userid, name, password, ssn, address;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", userid,name,password,ssn,address);
	}
}