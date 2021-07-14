package com.sword.oams.rest;

import com.sword.oams.domain.RotationGroup;
import com.sword.oams.payload.request.RotationRequest;
import com.sword.oams.service.RotationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("oams/rotationGroups")
@Api(tags = "Rotation Groups")
public class RotationGroupController {
    @Autowired
    RotationService rotationService;

    @GetMapping("")
    List<RotationGroup> allRotationGroups() {
        return rotationService.getAllRotations();
    }

    @PostMapping("")
    RotationGroup addRotationGroup(@RequestBody RotationRequest request) {
        return rotationService.addRotation(request);
    }

    @GetMapping("/{id}")
    RotationGroup getRotationGroup(@PathVariable Long id) {
        return rotationService.getRotationById(id);
    }

    @PutMapping("/{id}")
    RotationGroup updateRotationGroup(@RequestBody RotationRequest request, @PathVariable Long id) {
        return rotationService.updateRotationById(id,request);
    }

    @DeleteMapping("/{id}")
    void deleteRotationGroup(@PathVariable Long id) {
        rotationService.deleteRotationById(id);
    }
}