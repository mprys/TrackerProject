package com.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.tracker.model.BaseEntity;
import com.tracker.model.Team;
import com.tracker.service.TeamService;

public class TeamConversion implements Converter<String, BaseEntity> {

	@Autowired
	TeamService service;
	
	@Override
	public Team convert(String source) {
		Team team = service.loadTeamById(Long.valueOf(source));
		return team;
	}
}
