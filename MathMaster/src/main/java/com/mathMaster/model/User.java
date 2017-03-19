package com.mathMaster.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({

})
@NamedNativeQueries({

})
@Entity
@Table(name = "M2_USER")
public class User {
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name="USER", sequenceName="USER_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="USER", strategy=GenerationType.SEQUENCE)
	private int userId;
	@Column(name = "USERNAME", unique = true)
	private String username;
	@Column(name = "PASSWORD")
	private String password; // Encrpyt with JBCrypt
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LASTE_NAME")
	private String lastName;
	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ROLE_ID")
	private UserRole userRoleId;
	@Column(name = "EMAIL", unique = true)
	private String email;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String firstName, String lastName, UserRole userRoleId,
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRoleId = userRoleId;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserRole getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(UserRole userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userRoleId=" + userRoleId + ", email=" + email + "]";
	}
}
