package com.tinu.migrate;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tinu.app.SourceConfig;
import com.tinu.app.TargetConfig;
import com.tinu.domain.User;
import com.tinu.repository.source.SourceUserRepository;
import com.tinu.repository.target.TargetUserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SourceConfig.class, TargetConfig.class })
public class UserRepositoryIntegrationTest {

	@Autowired
	SourceUserRepository sourceUserRepository;

	@Autowired
	TargetUserRepository targetUserRepository;

	@Test
	public void insertInSource() {
		List<User> users = null;

		User user = new User();
		user.setFirstName("Abhishek");
		user.setLastName("Sharma");

		sourceUserRepository.save(user);
		users = (List<User>) sourceUserRepository.findAll();

		assertTrue("Insert in Source DB Failed", users.size() == 1);
	}

	@Test
	public void migrate() {
		targetUserRepository.save(sourceUserRepository.findAll());
		List<User> users = (List<User>) targetUserRepository.findAll();
		assertTrue("Migration to Target DB Failed", users.size() == 1);
	}
}
