package com.tinu.repository.source;

import org.springframework.data.repository.CrudRepository;

import com.tinu.domain.User;

public interface SourceUserRepository extends CrudRepository<User, Integer> {

}
