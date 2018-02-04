package com.shaman.test.giterek.constants;

import lombok.ToString;

public enum UserRole {
	ADMIN("ADMIN"), USER("USER");
	
	private final String role;
	
	private UserRole(String role){
		this.role = role;
	}
	
	@Override
	public String toString(){
		return role;
	}
}
