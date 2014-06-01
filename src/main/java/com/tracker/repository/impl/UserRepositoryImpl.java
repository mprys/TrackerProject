package com.tracker.repository.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.tracker.model.User;
import com.tracker.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.UserRepository#createUser(com.tracker.model.User)
	 */
	@Override
	public void createUser(User user){
		save(user);
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.repository.impl.UserRepository#loadAllUser()
	 */
	@Override
	public Collection<User> loadAllUser(){
		return loadAll(User.class, "User.loadAllUser");
	}
}
