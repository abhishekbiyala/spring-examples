package com.tinu;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tinu.service.Service;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class SpringMethodCacheTest {
	
	@Autowired
	Service service;

	@Test
	public void test() {
		
		assertSame(service.foo(Integer.class), service.foo(Integer.class));
		assertSame(service.foo(Long.class), service.foo(Long.class));
		assertSame(service.foo(Integer.class), service.foo(Integer.class));
		
	}

	@Test
	public void test1() {
		
		assertSame(service.foo(Integer.class), service.foo(Integer.class));
		assertSame(service.foo(Long.class), service.foo(Long.class));
		assertSame(service.foo(Integer.class), service.foo(Integer.class));
		
	}

	@Test
	public void test2() {
		
		assertSame(service.foo(Integer.class), service.foo(Integer.class));
		assertSame(service.foo(Long.class), service.foo(Long.class));
		assertSame(service.foo(Integer.class), service.foo(Integer.class));
		
	}

}
