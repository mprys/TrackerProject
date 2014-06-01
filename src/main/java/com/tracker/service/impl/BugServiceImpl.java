package com.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.tracker.model.Bug;
import com.tracker.repository.BugRepository;
import com.tracker.service.BugService;

@Service
@Transactional
public class BugServiceImpl implements BugService {

	private BugRepository bugRepo;
	
	@Autowired
	public BugServiceImpl(BugRepository bugRepo){
		this.bugRepo = bugRepo;
	}

	@Override
	public void addBug(Bug bug) {
		Assert.notNull(bug, "Bug object can not be null.");
		bugRepo.addBug(bug);
	}

	@Override
	public Bug editBug(Bug bug) {
		Assert.notNull(bug, "Bug object can not be null.");
		return bugRepo.editBug(bug);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Bug> loadAllBugs() {
		return bugRepo.loadAllBugs();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Bug> loadAllOpenBugs() {
		return bugRepo.loadAllOpenBugs();
	}

	@Override
	@Transactional(readOnly=true)
	public Bug findBugById(Long id) {
		Assert.notNull(id, "Bug id can not be null, check id value.");
		return bugRepo.findBugById(id);
	}
	
}
