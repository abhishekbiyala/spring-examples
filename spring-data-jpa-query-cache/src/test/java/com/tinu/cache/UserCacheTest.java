package com.tinu.cache;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tinu.domain.User;
import com.tinu.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserCacheTest {

	@Autowired
	UserRepository userRepository;

	@Autowired
	SessionFactory sessionFactory;

	@Test
	public void test() {
		User user = new User();
		user.setFirstName("James");
		user.setLastName("Bond");

		userRepository.save(user);

		// First invocation. DB Hit
		userRepository.findByName("James").get(0);

		// Second invocation. Cache Hit
		userRepository.findByName("James").get(0);

//		System.out.println();
//		System.out.println("===================");
//		System.out.println(sessionFactory.getStatistics().getSecondLevelCacheRegionNames()[0]);
//		System.out.println(sessionFactory.getStatistics().getSecondLevelCacheStatistics("org.hibernate.cache.StandardQueryCache").getHitCount());
//		System.out.println("===================");
//		System.out.println();

		assertEquals(sessionFactory.getStatistics().getSecondLevelCacheStatistics("org.hibernate.cache.StandardQueryCache").getHitCount(), 1);
	}

}
