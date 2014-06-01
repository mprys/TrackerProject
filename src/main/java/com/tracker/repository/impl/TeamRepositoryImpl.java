package com.tracker.repository.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.tracker.model.Team;
import com.tracker.repository.TeamRepository;

@Repository
public class TeamRepositoryImpl extends BaseRepositoryImpl<Team> implements TeamRepository {

	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.TeamRepository#createTeam(com.tracker.model.Team)
	 */
	@Override
	public void createTeam(Team team){
		save(team);
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.TeamRepository#updateTeam(com.tracker.model.Team)
	 */
	@Override
	public void updateTeam(Team team){
		update(team);
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.TeamRepository#loadAllTeams()
	 */
	@Override
	public Collection<Team> loadAllTeams(){
		return loadAll(Team.class, "loadAllTeams");
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.TeamRepository#loadTeamById(java.lang.Long)
	 */
	@Override
	public Team loadTeamById(Long id){
		return find(Team.class, id);
	}
}
