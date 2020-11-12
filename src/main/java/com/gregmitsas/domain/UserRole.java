package com.gregmitsas.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER_ROLES")
public class UserRole implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Id
    @ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}
}