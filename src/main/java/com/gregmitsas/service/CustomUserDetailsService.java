package com.gregmitsas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gregmitsas.domain.CustomUserDetails;
import com.gregmitsas.domain.User;
import com.gregmitsas.repository.RoleRepository;
import com.gregmitsas.repository.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository, RoleRepository userRolesRepository)
	{
		this.userRepository = userRepository;
		this.roleRepository = userRolesRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findByUserName(username);
		if (null == user)
		{
			throw new UsernameNotFoundException("No user present with username: " + username);
		}
		else
		{
			List<String> userRoles = roleRepository.findRoleByUserName(username);
			return new CustomUserDetails(user, userRoles);
		}
	}
}