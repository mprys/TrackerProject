package com.tracker.util;

import java.util.UUID;

/**
 * Generate unique id for each entity to use in hashCode and equals method.
 * 
 */
public class IdGenerator {
	
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
