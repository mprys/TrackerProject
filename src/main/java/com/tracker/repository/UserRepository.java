package com.tracker.repository;

import java.util.Collection;

import com.tracker.model.User;

public interface UserRepository {

	public void createUser(User user);

	public Collection<User> loadAllUser();

}