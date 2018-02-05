package com.shaman.test.giterek.repository;

import org.springframework.data.repository.CrudRepository;

import com.shaman.test.giterek.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);
}
