package com.shaman.test.giterek.service;

import java.util.List;

import com.shaman.test.giterek.dto.UserDTO;

public interface UserService {
	UserDTO create(UserDTO user);
	UserDTO delete(String id);
    List<UserDTO> findAll();
    UserDTO findById(String id);
    UserDTO findByUserName(String userName);
    UserDTO update(UserDTO user, boolean updatePassword);
	UserDTO findByUserNameWithPassword(String userName);
}
