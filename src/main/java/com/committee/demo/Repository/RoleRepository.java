package com.committee.demo.Repository;

import com.committee.demo.Entity.Roles.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Long> {
}
