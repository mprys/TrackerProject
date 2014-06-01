package com.tracker.service.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/persistence-config.xml"})
@Transactional
@Ignore
public class BugRepositoryTest {

	@Test
	public void testAddBug() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditBug() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadAllBugs() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadAllOpenBugs() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBugById() {
		fail("Not yet implemented");
	}

}
