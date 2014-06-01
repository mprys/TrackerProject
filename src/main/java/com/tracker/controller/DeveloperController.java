package com.tracker.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tracker.model.Developer;
import com.tracker.model.Status;
import com.tracker.model.Story;
import com.tracker.repository.StoryRepository;
import com.tracker.service.DeveloperService;

@Controller
@RequestMapping(value="/developer")
@SessionAttributes(types=Developer.class)
public class DeveloperController {

	private DeveloperService devSvc;
	
	@Autowired
	private StoryRepository storyRepo;
	
	@Autowired
	public DeveloperController(DeveloperService devSvc){
		this.devSvc = devSvc;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String initForm(Model model){
		model.addAttribute("developer", new Developer());
		return "developer/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addDeveloper(@ModelAttribute Developer developer, Model model, BindingResult result, SessionStatus status){
		
		if (result.hasErrors()){
			model.addAttribute("message", "Something was wrong.");
			return "error";
		}
		
		/**
		 * @TODO add validation
		 */
		devSvc.addDeveloper(developer);
		
		Story story = new Story();
		story.setDeveloper(developer);
		story.setDescription("new story");
		story.setPointValue(3);
		story.setTitle("sdsssssssss");
		story.setStatus(Status.NEW);
		
		storyRepo.addStory(story);
		status.setComplete();
		return "redirect:/developer/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listDeveloper(Model model){
		
		Collection<Developer> list = devSvc.loadAllDevelopers();
		model.addAttribute("developerList", list);
		
		return "developer/list";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editDeveloper(@PathVariable Long id, Model model){
		
		Developer developer = devSvc.findDeveloperById(id);
		model.addAttribute("developer", developer);
		
		return "developer/add";
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public String editDeveloper(@ModelAttribute Developer developer, Model model, BindingResult result, SessionStatus status){
		
		if (result.hasErrors()){
			model.addAttribute("message", "Error occured while binding form data.");
			return "error";
		}
		
		/**
		 * @TODO add validation.
		 */
		devSvc.editDeveloper(developer);
		status.setComplete();
		
		return "redirect:/developer/list";
	}
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String removeDeveloper(@PathVariable Long id, SessionStatus status){
		
		devSvc.removeDeveloper(id);
		status.setComplete();
		return "redirect:/developer/list";
	}
	
}
