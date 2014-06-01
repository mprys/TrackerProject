package com.tracker.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tracker.model.Bug;
import com.tracker.repository.BugRepository;

@Repository
public class BugRepositoryImpl extends BaseRepositoryImpl<Bug> implements BugRepository {

	@Override
	public void addBug(Bug bug) {
		save(bug);
	}

	@Override
	public Bug editBug(Bug bug) {
		return update(bug);
	}

	@Override
	public List<Bug> loadAllBugs() {
		return (List<Bug>)loadAll(Bug.class, "Bug.loadAll");
	}

	@Override
	public List<Bug> loadAllOpenBugs() {
		return (List<Bug>)loadAll(Bug.class, "Bug.loadOpenBugs");
	}

	@Override
	public Bug findBugById(Long id) {
		return find(Bug.class, id);
	}
	
}
