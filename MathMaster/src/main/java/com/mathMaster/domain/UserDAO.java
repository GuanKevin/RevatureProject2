package com.mathMaster.domain;

import com.mathMaster.model.UserRole;

//denise test
public interface UserDAO {
	public void createUser(String username, String password, String firstName, String lastName, UserRole userRoleId);
}
