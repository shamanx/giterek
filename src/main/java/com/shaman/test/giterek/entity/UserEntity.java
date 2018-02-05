package com.shaman.test.giterek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.shaman.test.giterek.constants.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserEntity {

	@Id
	private Long id;
	private String username;
	private String password;
	private UserRole userRole;
	
}
