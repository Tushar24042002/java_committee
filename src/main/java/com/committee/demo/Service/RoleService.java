package com.committee.demo.Service;

import com.committee.demo.Entity.Roles.Roles;
import com.committee.demo.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;
    public Roles addOrUpdate(Roles roles) {
        roles = roleRepository.save(roles);
        return  roles;
    }


    public Roles deleteRole(Roles role) {
        roleRepository.deleteById(role.getId());
        return  role;
    }
}
