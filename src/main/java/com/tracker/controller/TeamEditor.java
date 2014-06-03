package com.tracker.controller;

import java.beans.PropertyEditorSupport;
import java.util.Collection;
import java.util.Iterator;

import com.tracker.model.Team;

public class TeamEditor extends PropertyEditorSupport {

	private Collection<Team> teams;
	
	
//	public TeamEditor(Collection<Team> teams) {
//		this.teams = teams;
//	}
	
	public void setTeams(Collection<Team> teams) {
		this.teams = teams;
	}



	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		for (Iterator<Team> iterator = teams.iterator(); iterator.hasNext();) {
			Team team =  iterator.next();
			if (team.getId().equals(Long.valueOf(text))){
				this.setValue(team);
			}
		}
	}
}
