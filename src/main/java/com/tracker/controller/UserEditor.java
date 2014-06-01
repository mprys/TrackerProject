package com.tracker.controller;

import java.beans.PropertyEditorSupport;
import java.util.Collection;
import java.util.Iterator;

import com.tracker.model.User;

public class UserEditor extends PropertyEditorSupport {
	
	private Collection<User> users;
	
	public UserEditor(Collection<User> users){
		this.users = users;
	}

	@Override
	public String getAsText() {
		User user = (User)this.getValue();
		return user.getFirstName() + " " + user.getLastName();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		Iterator<User> it = users.iterator();
		
		while(it.hasNext()){
			User user = it.next();
			if (user.getUuid().equals(text)){
				this.setValue(user);
			}
		}
	}
}
