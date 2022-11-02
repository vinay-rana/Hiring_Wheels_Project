package org.ncu.hirewheels.DAO;

import org.ncu.hirewheels.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleDAO extends JpaRepository<Role, Long>{

	@Query("SELECT r FROM Role r Where lower(r.name) = ?1")
	public Role getRoleByName(String name);
	
}
