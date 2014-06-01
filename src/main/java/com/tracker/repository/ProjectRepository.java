package com.tracker.repository;

import java.util.Collection;

import com.tracker.model.Project;

public interface ProjectRepository {

	public void createProject(Project project);

	public void updateProject(Project project);

	public void removeProject(Project project);

	public Project loadProjectById(Long id);

	public Collection<Project> loadAllProjects();

}