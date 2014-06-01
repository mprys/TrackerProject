package com.tracker.service;

import java.util.Collection;

import com.tracker.model.Project;
import com.tracker.model.Team;
import com.tracker.model.User;

public interface TeamService {

	public void createTeam(Team team);

	public void updateTeam(Team team);

	public Collection<Team> loadAllTeams();

	public Team loadTeamById(Long id);
	
	public void createUser(User user);

	public Collection<User> loadAllUsers();
	
	public void createProject(Project project);
	
	public Collection<Project> loadAllProjects();
	
	public Project loadProject(Long id);

}