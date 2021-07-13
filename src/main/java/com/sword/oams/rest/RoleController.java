package com.sword.oams.rest;

import com.sword.oams.domain.Role;
import com.sword.oams.exception.RoleNotFoundException;
import com.sword.oams.payload.request.RoleRequest;
import com.sword.oams.repository.RoleRepository;
import com.sword.oams.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/roles")
@Api(tags = "Roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("")
    @ApiOperation(value = "This method is used to get all roles.")
    List<Role> allRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping("")
    @ApiOperation(value = "This method is used to add a role.")
    Role addRole(@RequestBody RoleRequest newRole) {
        return roleService.addRole(newRole);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This method is used to get a role by its id.")
    Role getRole(@PathVariable Long id) { return roleService.getRoleById(id); }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "This method is used to delete a role by its id.")
    void deleteRole(@PathVariable Long id) { roleService.deleteRoleById(id); }

    @PutMapping("/{id}")
    @ApiOperation(value = "This method is used to update a role by its id.")
    Role updateRole(@PathVariable Long id, @RequestBody RoleRequest request) {
        return roleService.updateRoleById(id, request);
    }
}
