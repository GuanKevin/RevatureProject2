package com.mathMaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Daniel Liu
 *
 */

@Entity
@Table(name="M2_LEVEL")
public class Level {
	@Id
	@Column(name="LEVEL_ID")
	@SequenceGenerator(name="level", sequenceName="LEVEL_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="level", strategy=GenerationType.SEQUENCE)
	private int levelId;
	@Column(name="LEVEL_NAME", unique=true)
	private String levelName;
	
	public Level() {
		// TODO Auto-generated constructor stub
	}
	
	public Level(String levelName) {
		super();
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
