package com.tracker.repository.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.tracker.model.BaseEntity;

/**
 * Base implementation of JPA repository, it centralize CRUD operations.
 * 
 * @param <T> is the Entity type
 */
@Transactional
public abstract class BaseRepositoryImpl<T extends BaseEntity>{
	
	@PersistenceContext
	protected EntityManager em;

	public void save(T entity) {
		em.persist(entity);
		em.flush();
	}

	public T update(T entity) {
		T t = em.merge(entity);
		em.flush();
		return t; 
	}

	public void remove(T entity) {
		em.remove(entity);
		em.flush();
	}

	public T find(Class<T> clazz, Long id) {
		return em.find(clazz, id);
	}

	public Collection<T> loadAll(Class<T> clazz, String queryName) {
		TypedQuery<T> query = em.createNamedQuery(queryName, clazz);
		return query.getResultList();
	}
}
