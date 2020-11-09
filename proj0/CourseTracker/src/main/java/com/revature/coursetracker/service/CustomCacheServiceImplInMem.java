package com.revature.coursetracker.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomCacheServiceImplInMem <T> implements CustomCacheService<T> {
	
	private Set<T> cache = new HashSet<T>();

	public CustomCacheServiceImplInMem() {
		super();
	}

	public CustomCacheServiceImplInMem(Set<T> cache) {
		this();
		this.cache = cache;
	}

	public void setCache(Set<T> cache) {
		this.cache = cache;
	}
	
	@Override
	public void addToCache(T obj) {
		System.out.println("Adding " + obj + " to cache");
		this.cache.add(obj);
	}

	@Override
	public void removeFromCache(T obj) {
		cache.remove(obj);		
	}

	@Override
	public T retrieveItem(T obj) {
		return null;
	}

	@Override
	public void emptyCache() {
		cache = new HashSet<T>();
		
	}

	@Override
	public boolean contains(T obj) {
		return cache.contains(obj);
	}

//	@Override
//	public void updateFromCache(T org, T upd) {
//		
//	}

	@Override
	public List<T> retrieveAllItems() {
		return new ArrayList<T>(cache);
	}

	@Override
	public List<T> retrieveMatching(Predicate<T> p) {
		return cache.stream().filter(p).collect(Collectors.toList());
	}

}
