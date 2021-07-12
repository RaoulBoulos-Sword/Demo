package com.sword.oams.rest;

import com.sword.oams.domain.RotationGroup;
import com.sword.oams.exception.RotationGroupNotFoundException;
import com.sword.oams.repository.RotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("oams/rotationGroups")
public class RotationGroupController {
    @Autowired
    RotationRepository rotationRepository;

    @GetMapping("")
    List<RotationGroup> allRotationGroups() {
        return rotationRepository.findAll();
    }

    @PostMapping("")
    RotationGroup addRotationGroup(@RequestBody RotationGroup rotationGroup) {
        return rotationRepository.save(rotationGroup);
    }

    @GetMapping("/{id}")
    RotationGroup getRotationGroup(@PathVariable Long id) {
        return rotationRepository.findById(id).orElseThrow(() -> new RotationGroupNotFoundException(id));
    }

    @PutMapping("/{id}")
    RotationGroup updateRotationGroup(@RequestBody RotationGroup newRotationGroup, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    void deleteRotationGroup(@PathVariable Long id) {
        rotationRepository.deleteById(id);
    }
}