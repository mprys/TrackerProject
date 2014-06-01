package com.tracker.service.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tracker.repository.StoryRepository;

@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/persistence-config.xml"})
@Transactional
@Ignore
public class StoryRepositoryTest {

	@Autowired
	StoryRepository storyRepository;
	
	
	@Test
	public void testLoadAllStoriesByDeveloperId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAddStory() {
		//fail("Not yet implemented");
	}

}
