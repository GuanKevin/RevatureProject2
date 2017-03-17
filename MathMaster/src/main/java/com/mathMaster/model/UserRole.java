package com.mathMaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class consist of two current users
 * Teacher
 * Students
 * 
 * @author kevgu
 *
 */

@Entity
@Table(name="M2_User_Role")
public class UserRole {
	@Id
	@Column
	@SequenceGenerator(name="userRole", sequenceName="USER_ROLE_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="userRole", strategy=GenerationType.SEQUENCE)
	private int userRoleId;
	@Column
	private String userRole;
	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}
	
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRole=" + userRole + "]";
	}
}
