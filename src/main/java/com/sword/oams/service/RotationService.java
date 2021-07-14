package com.sword.oams.service;

import com.sword.oams.domain.RotationGroup;
import com.sword.oams.domain.Team;
import com.sword.oams.payload.request.RotationRequest;
import com.sword.oams.payload.request.TeamRequest;
import com.sword.oams.repository.RotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotationService {

    @Autowired
    RotationRepository rotationRepository;

    public List<RotationGroup> getAllRotations() { return rotationRepository.findAll(); }

    public RotationGroup getRotationById(Long id) { return rotationRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Rotation Not Found"));}

    public void deleteRotationById(Long id) { rotationRepository.deleteById(id); }

    public RotationGroup addRotation(RotationRequest request) {
        RotationGroup newRotation = RotationGroup.builder()
                .name(request.getName())
                .weekdays(request.getWeekDay())
                .build();
        return rotationRepository.save(newRotation);
    }

    public RotationGroup updateRotationById(Long id, RotationRequest request) {
        return rotationRepository.findById(id)
                .map(rotationGroup -> {
                    rotationGroup.setName(request.getName());
                    rotationGroup.setWeekdays(request.getWeekDay());
                    return rotationRepository.save(rotationGroup);
                })
                .orElse(null);
    }
}
