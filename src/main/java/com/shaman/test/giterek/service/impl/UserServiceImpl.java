package com.shaman.test.giterek.service.impl;

import static java.util.Objects.isNull;

import java.util.List;

import javax.inject.Inject;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.givaudan.cmslcms.configuration.OrikaBeanMapper;
import com.givaudan.cmslcms.repository.UserRepository;
import com.shaman.test.giterek.dto.UserDTO;
import com.shaman.test.giterek.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final OrikaBeanMapper mapper;
    @Inject 
    UserDetailsService manager;

	@Inject
	UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, OrikaBeanMapper userMapper) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.mapper = userMapper;
    }

	@Override
    public UserDTO create(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO delete(String id) {
    	return null;
    }

    @Cacheable("user")
    @Override
	public UserDTO findByUserName(String userName) {
    	
    	UserDetails user = manager.loadUserByUsername(userName);
    	if (isNull(user)) {
    		throw new UsernameNotFoundException(userName);
    	}
    	UserDTO result = mapper.map(user, UserDTO.class);
    	return result;
	}

	@Override
	public UserDTO findByUserNameWithPassword(String userName) {
		return null;
	}

    @Override
    public List<UserDTO> findAll() {
    	return null;
    }
    
    @Override
    public UserDTO findById(String id) {
    	return null;
    }

    @Override
    public UserDTO update(UserDTO user, boolean updatePassword) {
    	return null;
    }
}