package com.committee.demo.Controllers;

import com.committee.demo.Entity.Roles.Roles;
import com.committee.demo.Entity.Users.Users;
import com.committee.demo.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;
    @PostMapping("/addOrUpdate")
    public ResponseEntity<Roles> addOrUpdateUser(@RequestBody Roles roles) {
        Roles savedRole = roleService.addOrUpdate(roles);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @PostMapping("/deleteRole")
    public ResponseEntity<Roles> deleteRole(@RequestBody Roles role){
        Roles roles = roleService.deleteRole(role);
        return  new ResponseEntity<>(roles,HttpStatus.OK);
    }
}
