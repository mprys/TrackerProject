package com.tracker.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.tracker.model.Project;
import com.tracker.model.Team;
import com.tracker.model.User;
import com.tracker.repository.ProjectRepository;
import com.tracker.repository.TeamRepository;
import com.tracker.repository.UserRepository;
import com.tracker.service.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	private TeamRepository teamRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	public TeamServiceImpl(TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.service.impl.TeamService#createTeam(com.tracker.model.Team)
	 */
	@Override
	public void createTeam(Team team){
		Assert.notNull(team, "Team object can not be null");
		teamRepo.createTeam(team);
	}

	/* (non-Javadoc)
	 * @see com.tracker.service.impl.TeamService#updateTeam(com.tracker.model.Team)
	 */
	@Override
	public void updateTeam(Team team){
		Assert.notNull(team, "Team object can not be null");
		teamRepo.updateTeam(team);
	}

	/* (non-Javadoc)
	 * @see com.tracker.service.impl.TeamService#loadAllTeams()
	 */
	@Override
	@Transactional(readOnly=true)
	public Collection<Team> loadAllTeams(){
		return teamRepo.loadAllTeams();
	}

	/* (non-Javadoc)
	 * @see com.tracker.service.impl.TeamService#loadTeamById(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public Team loadTeamById(Long id){
		Assert.notNull(id, "Team id can not be null");
		return teamRepo.loadTeamById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.service.impl.TeamService#createUser(User)
	 */
	@Override
	public void createUser(User user){
		Assert.notNull(user, "Team id can not be null");
		userRepo.createUser(user);
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.service.impl.TeamService#loadAllUsers()
	 */
	@Override
	@Transactional(readOnly=true)
	public Collection<User> loadAllUsers(){
		return userRepo.loadAllUser();
	}

	@Override
	public void createProject(Project project) {
		projectRepository.createProject(project);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Project> loadAllProjects(){
		return projectRepository.loadAllProjects();
	}

	@Override
	@Transactional(readOnly=true)
	public Project loadProject(Long id) {
		return projectRepository.loadProjectById(id);
	}
}
