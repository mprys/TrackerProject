package com.tracker.service;

import java.util.List;

import com.tracker.model.Story;

public interface StoryService {

	/**
	 * Add new story
	 * 
	 * @param story
	 */
	public void addStory(Story story);
	
	/**
	 * Edit story
	 * 
	 * @param story
	 * @return updated story entity
	 */
	public Story editStory(Story story);
	
	/**
	 * Loads all stories
	 * 
	 * @return list of stories.
	 */
	public List<Story> loadAllStories();
	
	/**
	 * Returns story bu given id
	 * 
	 * @param id
	 * 
	 * @return story entity
	 */
	public Story findStoryById(Long id);
	
	/**
	 * Loads unassigned stories
	 * 
	 * @return list of stories.
	 */
	public List<Story> loadUnassignedStories();
}
