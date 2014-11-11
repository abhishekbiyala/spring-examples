package com.tinu.repository.target;

import org.springframework.data.repository.CrudRepository;

import com.tinu.domain.User;

public interface TargetUserRepository extends CrudRepository<User, Integer> {

}
