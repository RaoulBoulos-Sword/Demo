package com.sword.oams.service;

import com.sword.oams.domain.Role;
import com.sword.oams.domain.Role;
import com.sword.oams.domain.Room;
import com.sword.oams.payload.request.RoleRequest;
import com.sword.oams.payload.request.RoomRequest;
import com.sword.oams.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role addRole(RoleRequest request) {
        Role newRole = Role.builder()
                .roleName(request.getRoleName())
                .build();

        return roleRepository.save(newRole);
    }

    public Role getRoleById(Long id) { return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Role Id Not Found")); }

    public List<Role> getAllRoles() { return roleRepository.findAll(); }

    public void deleteRoleById(Long id) { roleRepository.deleteById(id); }

    public Role updateRoleById(Long id, RoleRequest request) {
        return roleRepository.findById(id)
                .map( role -> {
                    role.setRoleName(request.getRoleName());
                    return roleRepository.save(role);
                })
                .orElse(null);
    }

}
