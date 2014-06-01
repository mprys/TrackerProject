package com.tracker.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tracker.model.Team;
import com.tracker.repository.TeamRepository;

@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/persistence-config.xml"})
@Transactional
@Ignore
public class TeamRepositoryTest {

	@Autowired
	TeamRepository teamRepository;
	
	@Before
	public void init(){
		
	}
	
	@Test
	public void testCreateTeam() {
		Team team = new Team();
		team.setName("test team");
		teamRepository.createTeam(team);
		Team retrievedTeam =  teamRepository.loadTeamById(team.getId());
		assertEquals("test sconfiguration success", team.getId(), retrievedTeam.getId());
	}

	@Test
	public void testUpdateTeam() {
		Team team = new Team();
		team.setName("test team");
		teamRepository.createTeam(team);
		team.setName("new test team");
		teamRepository.updateTeam(team);
		Team retrievedTeam =  teamRepository.loadTeamById(team.getId());
		assertEquals("team update completed..", team.getName(), retrievedTeam.getName());
		assertEquals(team.getId(), team.getId());
		assertEquals(Integer.valueOf(team.getVersion() + 1), retrievedTeam.getVersion());
	}
//
//	@Test
//	public void testLoadAllTeams() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLoadTeamById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCreateUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLoadAllUsers() {
//		fail("Not yet implemented");
//	}

}
