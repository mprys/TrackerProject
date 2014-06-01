package com.tracker.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tracker.model.Project;
import com.tracker.model.Status;
import com.tracker.model.Team;
import com.tracker.model.User;
import com.tracker.service.DeveloperService;
import com.tracker.service.TeamService;

@Controller
@SessionAttributes(types={Team.class, Project.class})
public class TeamOperationController {
	
	private TeamService teamSvc;
	
	@Autowired
	private DeveloperService developerService;
	
	@Autowired
	public TeamOperationController(TeamService teamSvc) {
		this.teamSvc = teamSvc;
	}

	Collection<User> users;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(User.class, new UserEditor(users));
	}
	
	@RequestMapping(value="/team", method=RequestMethod.GET)
	public String initForm(Model model){
		model.addAttribute("team", new Team());
		users = teamSvc.loadAllUsers();
		
		model.addAttribute("users", users);
		
		return "team";
	}
	
	@RequestMapping(value="/team", method=RequestMethod.POST)
	public String createTeam(@ModelAttribute Team team, Model model, BindingResult result, SessionStatus sessionStatus){
		
		if (result.hasErrors()){
			model.addAttribute("message", "Error occured while binding form data.");
			return "error";
		}
		
		teamSvc.createTeam(team);
		sessionStatus.setComplete();
		return "dashboard";
	}
	
	@RequestMapping(value="/team/list", method=RequestMethod.GET)
	public String listTeams(Model model){
		Collection<Team> teams = teamSvc.loadAllTeams();
		model.addAttribute("teams", teams);
		return "list";
	}
	
	@RequestMapping(value="/team/members/{teamId}", method=RequestMethod.GET)
	public String addMembers(@PathVariable Long teamId, Model model){
		
		Team team = teamSvc.loadTeamById(teamId);
		model.addAttribute("users", team.getMembers());
		model.addAttribute("user", new User());
		
		return "members";
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String initUserForm(Model model){
		
		model.addAttribute("user", new User());
		return "user";
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public String createUser(@ModelAttribute User user, Model model, BindingResult result, SessionStatus sessionStatus){
		
		if (result.hasErrors()){
			model.addAttribute("message", "Error occured while binding form data.");
			return "error";
		}
		teamSvc.createUser(user);
		sessionStatus.setComplete();
		return "dashboard";
	}
	
	@RequestMapping(value="/team/members/{teamId}", method=RequestMethod.POST)
	public String addUserToTeam(@ModelAttribute User user, @PathVariable Long teamId, Model model, BindingResult result, SessionStatus sessionStatus){
		
		if (result.hasErrors()){
			model.addAttribute("message", "Error occured while binding form data." + result.toString());
			return "error";
		}
		teamSvc.createUser(user);
		
		Team team = teamSvc.loadTeamById(teamId);
		Collection<Team> teams = user.getTeams();
		teams.add(team);
		teamSvc.updateTeam(team);
		sessionStatus.setComplete();
		return "dashboard";
	}
	
	@RequestMapping(value="/project", method=RequestMethod.POST)
	public String createProject(@ModelAttribute Project project, Model model, BindingResult result, SessionStatus sessionStatus){
		
		if (result.hasErrors()){
			model.addAttribute("message", "Error occured while binding form data." + result.toString());
			return "error";
		}
		teamSvc.createProject(project);
		sessionStatus.setComplete();
		return "dashboard";
	}
	
	@RequestMapping(value="/project", method=RequestMethod.GET)
	public String initProjectForm(Model model){
		
		model.addAttribute("project", new Project());
		model.addAttribute("statusTypes", Status.values());
		
		return "project";
	}
	
	@RequestMapping(value="/project/list", method=RequestMethod.GET)
	public String listAllProjects(Model model){
		
		model.addAttribute("projects", teamSvc.loadAllProjects());
		return "projects";
	}
	
	@RequestMapping(value="/project/assign/{projectId}", method=RequestMethod.GET)
	public String assignProjectToTeamInit(@PathVariable Long projectId, Model model){
		
		model.addAttribute("project", teamSvc.loadProject(projectId));
		Collection<Team> teams = teamSvc.loadAllTeams();
		List<TextAndValue> teamList = new ArrayList<TextAndValue>();
		
		for (Team team : teams) {
			teamList.add(new TextAndValue(team.getName(), team.getId()));
		}
		model.addAttribute("teams", teamList);
		
		return "/project";
	}
	
	@RequestMapping(value="/project/assign/{projectId}", method=RequestMethod.POST)
	public String assignProjectToTeam(@ModelAttribute Project project, Model model, BindingResult result, SessionStatus sessionStatus){
		
		Project pr = project;
		
		return "/project";
	}
	
	
}
