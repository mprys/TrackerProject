package com.tracker.repository;

import java.util.Collection;

import com.tracker.model.Developer;


public interface DeveloperRepository {

	/**
	 * Add new developer
	 * 
	 * @param developer
	 */
	public void addDeveloper(Developer developer);
	
	/**
	 * Return a developer by id. If it could not find, return null
	 *  
	 * @param id
	 * @return
	 */
	public Developer findDeveloperById(Long id);
	
	/**
	 * Update developer entity
	 * 
	 * @param developer
	 * @param id
	 * @return
	 */
	public Developer editDeveloper(Developer developer);
	
	/**
	 * Remove developer by given developer entity
	 * 
	 * @param developer
	 */
	public void removeDeveloper(Developer developer);
	
	/**
	 * Returns all developers
	 * 
	 * @return
	 */
	public Collection<Developer> loadAllDevelopers();
}
