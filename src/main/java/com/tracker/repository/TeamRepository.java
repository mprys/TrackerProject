package com.tracker.repository;

import java.util.Collection;

import com.tracker.model.Team;

public interface TeamRepository {

	public void createTeam(Team team);

	public void updateTeam(Team team);

	public Collection<Team> loadAllTeams();

	public Team loadTeamById(Long id);

}