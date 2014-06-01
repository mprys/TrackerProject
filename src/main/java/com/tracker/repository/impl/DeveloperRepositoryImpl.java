package com.tracker.repository.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.tracker.model.Developer;
import com.tracker.repository.DeveloperRepository;

@Repository
public class DeveloperRepositoryImpl extends BaseRepositoryImpl<Developer> implements DeveloperRepository {

	@Override
	public void addDeveloper(Developer developer) {
		save(developer);
	}

	@Override
	public Developer findDeveloperById(Long id) {
		return find(Developer.class, id);
	}

	@Override
	public Developer editDeveloper(Developer developer) {
		return update(developer);
	}

	@Override
	public void removeDeveloper(Developer developer) {
		remove(developer);
	}

	@Override
	public Collection<Developer> loadAllDevelopers() {
		return loadAll(Developer.class, "Developer.loadAll");
	}

}
