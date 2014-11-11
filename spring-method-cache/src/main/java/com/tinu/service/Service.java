package com.tinu.service;

import com.googlecode.ehcache.annotations.Cacheable;

public class Service {

	@Cacheable(cacheName = "fooCache")
	public int foo(int i, int j) {
		System.out.println("inside foo");
		return i * j;
	}

	@Cacheable(cacheName = "fooCache")
	public String foo(Class<?> clazz) {
		System.out.println("inside foo");
		return ""+clazz.getName();
	}

}
