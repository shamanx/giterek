package com.shaman.test.giterek.dto;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String id;
	@NotEmpty
	private String username;
	@NotEmpty
	@Length(min=8, max=30)
	private String password;
	private boolean enabled;
	private String role;
	private Date dateCreation;

}
