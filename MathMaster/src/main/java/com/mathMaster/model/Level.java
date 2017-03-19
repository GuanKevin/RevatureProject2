package com.mathMaster.model;

public class Level {
	private int levelId;
	private String levelName;
	
	public Level() {
		// TODO Auto-generated constructor stub
	}
	
	public Level(int levelId, String levelName) {
		super();
		this.levelId = levelId;
		this.levelName = levelName;
	}

	public int getLevelId() {
		return levelId;
	}
	
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	public String getLevelName() {
		return levelName;
	}
	
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	@Override
	public String toString() {
		return "Level [levelId=" + levelId + ", levelName=" + levelName + "]";
	}
}
