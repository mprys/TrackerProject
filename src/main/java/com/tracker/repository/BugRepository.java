package com.tracker.repository;

import java.util.List;

import com.tracker.model.Bug;

public interface BugRepository {

	/**
	 * Add new bug
	 * 
	 * @param bug
	 */
	public void addBug(Bug bug);

	/**
	 * Edit given bug
	 * 
	 * @param bug
	 * 
	 * @return updated bug entity
	 */
	public Bug editBug(Bug bug);

	/**
	 * Returns the bug by given id
	 * 
	 * @param id
	 * 
	 * @return bug
	 */
	public Bug findBugById(Long id);

	/**
	 * Loads all bugs. Return empty list, if any bug is created.
	 * 
	 * @return
	 */
	public List<Bug> loadAllBugs();

	/**
	 * Loads all bugs are in not "Completed" or "Resolved" status. Return empty
	 * list, when it could not find.
	 * 
	 * @return
	 */
	public List<Bug> loadAllOpenBugs();
}
