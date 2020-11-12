package com.gregmitsas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gregmitsas.domain.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>
{
	@Query("select a.roleCode "
			+ "from Role a, UserRole b, User c "
			+ "where b.role.id = a.id "
			+ "and b.user.id = c.id "
			+ "and c.userName=?1 ")
    public List<String> findRoleByUserName(String userName);
}