package com.tracker.controller;

import java.util.List;

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

import com.tracker.model.Bug;
import com.tracker.model.Priority;
import com.tracker.model.Status;
import com.tracker.service.BugService;

@Controller
@RequestMapping(value="/issue")
@SessionAttributes(types=Bug.class)
public class BugOperationController {

	private BugService bugSvc;
	
	@Autowired
	public BugOperationController(BugService bugSvc){
		this.bugSvc = bugSvc;
	}
	
	@ModelAttribute("statusTypes")
	public Status[] populateStatusTypes(){
		Status[] types = new Status[3];
		types[0] = Status.NEW;
		types[1] = Status.VERIFIED;
		types[2] = Status.RESOLVED;
		return types;
	}
	
	@ModelAttribute("priorityTypes")
	public Priority[] populatePriorityTypes(){
		return Priority.values();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String initForm(Model model){
		model.addAttribute("bug", new Bug());
		return "issue/addbug";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addBug(@ModelAttribute Bug bug, Model model, BindingResult result, SessionStatus status){
		
		if (result.hasErrors()){
			model.addAttribute("message", "Error occured while binding form data.");
			return "error";
		}
		
		/**
		 * @TODO add validation for Bug object.
		 */
		bugSvc.addBug(bug);
		status.setComplete();
		
		return "redirect:/issue/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listBugs(Model model){
		List<Bug> bugs = bugSvc.loadAllBugs();
		model.addAttribute("bugs", bugs);

		return "issue/list";
	}
	
	@RequestMapping(value="/listopen", method=RequestMethod.GET)
	public String listOpenBugs(Model model){
		List<Bug> bugs = bugSvc.loadAllOpenBugs();
		model.addAttribute("bugs", bugs);
		return "issue/list";
	}
	
	@RequestMapping(value = "/edit/bug/{id}", method = RequestMethod.GET)
	public String editIssue(@PathVariable Long id, Model model) {
		Bug bug = bugSvc.findBugById(id);
		model.addAttribute("bug", bug);
		return "issue/addbug";
	}
	
	@RequestMapping(value="/edit/bug/{id}", method=RequestMethod.PUT)
	public String editIssue(@ModelAttribute Bug bug, Model model, BindingResult result, SessionStatus status){
		
		if (result.hasErrors()){
			model.addAttribute("message", "Something was wrong.");
			return "error";
		}
		
		/**
		 * @TODO add validation
		 */
		bugSvc.editBug(bug);
		status.setComplete();
		
		return "redirect:/issue/list";
	}
	
}
