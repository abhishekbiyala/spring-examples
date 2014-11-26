package com.tinu.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tinu.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(" from User user where user.firstName = :name")
	@QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
	public List<User> findByName(@Param("name") String name);
}
