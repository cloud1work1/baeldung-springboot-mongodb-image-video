package com.baeldung.entity;

import java.io.InputStream;

public class Video {

	private String title;
	private InputStream inoutStream;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public InputStream getInoutStream() {
		return inoutStream;
	}
	public void setInoutStream(InputStream inoutStream) {
		this.inoutStream = inoutStream;
	}
	
	
	
}
