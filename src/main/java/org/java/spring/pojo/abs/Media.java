package org.java.spring.pojo.abs;

public abstract class Media {
	
	private int id;
	private String title;
	
	public Media(int id, String title) {
		setId(id);
		setTitle(title);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "[" + id + "] - " + title;
	}
}
