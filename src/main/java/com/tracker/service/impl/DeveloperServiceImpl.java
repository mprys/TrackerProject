package com.tracker.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.tracker.model.Developer;
import com.tracker.repository.DeveloperRepository;
import com.tracker.service.DeveloperService;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

	private DeveloperRepository devRepo;

	@Autowired
	public DeveloperServiceImpl(DeveloperRepository devRepo){
		this.devRepo = devRepo;
	}
	
	@Override
	public void addDeveloper(Developer developer) {
		Assert.notNull(developer, "Developer object can not be null.");
		devRepo.addDeveloper(developer);
	}

	@Override
	@Transactional(readOnly=true)
	public Developer findDeveloperById(Long id) {
		Assert.notNull(id, "Developer id can not be null.");
		return devRepo.findDeveloperById(id);
	}

	@Override
	public Developer editDeveloper(Developer developer) {
		Assert.notNull(developer, "Developer object can not be null.");
		return devRepo.editDeveloper(developer);
	}

	@Override
	public void removeDeveloper(Long id) {
		Assert.notNull(id, "Developer id can not be null");
		Developer developer = findDeveloperById(id);
		Assert.notNull(developer, "Developer could not find by given id, check the id value.");
		devRepo.removeDeveloper(developer);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Developer> loadAllDevelopers() {
		return devRepo.loadAllDevelopers();
	}
	
}
