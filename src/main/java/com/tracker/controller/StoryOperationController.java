package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tracker.model.Story;
import com.tracker.repository.StoryRepository;

@Controller
public class StoryOperationController {

	StoryRepository storyRepo;
	
	@Autowired
	public StoryOperationController(StoryRepository storyRepo){
		this.storyRepo = storyRepo;
	}
	
	@RequestMapping(value="/story/loadbyowner/{ownerId}", method=RequestMethod.GET)
	@ResponseBody
	public List<Story> loadAllStories(@PathVariable Long ownerId){
		
		List<Story> stories = storyRepo.loadAllStoriesByDeveloperId(ownerId);
		//model.addAttribute("stories", stories);
		
		return stories;
	}
}
