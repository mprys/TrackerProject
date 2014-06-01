package com.tracker.repository;

import java.util.List;

import com.tracker.model.Story;

public interface StoryRepository {

	public List<Story> loadAllStoriesByDeveloperId(Long id);
	
	public void addStory(Story story);

}