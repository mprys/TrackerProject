package com.tracker.controller;

public class TextAndValue {
	
	String text;
	
	Long id;
	
	public TextAndValue(String text, Long id) {
		this.text = text;
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
