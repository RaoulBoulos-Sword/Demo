package com.sword.oams.rest;

import com.sword.oams.domain.RotationGroup;
import com.sword.oams.payload.request.RotationRequest;
import com.sword.oams.service.RotationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("oams/rotationGroups")
@CrossOrigin(origins = "*",maxAge = 3600)
@Api(tags = "Rotation Groups")
public class RotationGroupController {
    @Autowired
    RotationService rotationService;

    @GetMapping("")
    @ApiOperation(value = "This method is used to get all rotation groups.")
    List<RotationGroup> allRotationGroups() {
        return rotationService.getAllRotations();
    }

    @GetMapping("/available")
    @ApiOperation(value = "This method is used to get all available rotation groups.")
    List<RotationGroup> availableRotationGroups() { return rotationService.getAllRotationsByAvailableStatus(); }

    @GetMapping("/unavailable")
    @ApiOperation(value = "This method is used to get all unavailable rotation groups.")
    List<RotationGroup> unavailableRotationGroups() { return rotationService.getAllRotationsByUnavailableStatus(); }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to add a rotation group.")
    RotationGroup addRotationGroup(@RequestBody RotationRequest request) {
        return rotationService.addRotation(request);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This method is used to get a rotation group by its ID.")
    RotationGroup getRotationGroup(@PathVariable Long id) {
        return rotationService.getRotationById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to update a rotation group by its ID.")
    RotationGroup updateRotationGroup(@RequestBody RotationRequest request, @PathVariable Long id) {
        return rotationService.updateRotationById(id,request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to delete a rotation group by its ID.")
    void deleteRotationGroup(@PathVariable Long id) {
        rotationService.deleteRotationById(id);
    }
}