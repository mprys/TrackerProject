package com.tracker.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tracker.model.Story;
import com.tracker.repository.StoryRepository;

@Repository
public class StoryRepositoryImpl extends BaseRepositoryImpl<Story> implements StoryRepository {

	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.StoryRepository#loadAllStoriesByDeveloperId(java.lang.Long)
	 */
	@Override
	public List<Story> loadAllStoriesByDeveloperId(Long id){
		TypedQuery<Story> query = em.createNamedQuery("Story.loadByOwner", Story.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public void addStory(Story story){
		save(story);
	}
}
