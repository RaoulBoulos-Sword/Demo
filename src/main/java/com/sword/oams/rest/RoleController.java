package com.sword.oams.rest;

import com.sword.oams.domain.Role;
import com.sword.oams.exception.RoleNotFoundException;
import com.sword.oams.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/roles")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("")
    List<Role> allRoles() {
        return roleRepository.findAll();
    }

    @PostMapping("")
    Role addRole(@RequestBody Role newRole) {
        return roleRepository.save(newRole);
    }

    @GetMapping("/{id}")
    Role getRole(@PathVariable Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));
    }

    @PutMapping("/{id}")
    Role updateRole(@RequestBody Role newRole,@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }
}
