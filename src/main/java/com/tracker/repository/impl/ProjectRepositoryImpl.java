package com.tracker.repository.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.tracker.model.Project;
import com.tracker.repository.ProjectRepository;

@Repository
public class ProjectRepositoryImpl extends BaseRepositoryImpl<Project> implements ProjectRepository {

	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.ProjectRepository#createProject(com.tracker.model.Project)
	 */
	@Override
	public void createProject(Project project){
		save(project);
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.ProjectRepository#updateProject(com.tracker.model.Project)
	 */
	@Override
	public void updateProject(Project project){
		update(project);
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.ProjectRepository#removeProject(com.tracker.model.Project)
	 */
	@Override
	public void removeProject(Project project){
		remove(project);
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.ProjectRepository#loadProjectById(java.lang.Long)
	 */
	@Override
	public Project loadProjectById(Long id){
		return find(Project.class, id); //
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.ProjectRepository#loadAllProjects()
	 */
	@Override
	public Collection<Project> loadAllProjects(){
		return loadAll(Project.class, "Project.loadAll");
	}
}
