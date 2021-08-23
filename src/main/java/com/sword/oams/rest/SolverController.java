package com.sword.oams.rest;

import com.sword.oams.domain.*;
import com.sword.oams.repository.EmployeeRepository;
import com.sword.oams.repository.EmployeeRotationRepository;
import com.sword.oams.repository.RoomRepository;
import com.sword.oams.repository.RotationRepository;
import com.sword.oams.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/oams/solve")
@Api(tags = "OptaPlanner Solver")
public class SolverController {
    @Autowired
    private EmployeeRotationRepository employeeRotationRepository;

    @Autowired
    private SolverManager<EmployeeRotation, Long> solverManager;

    @Autowired
    private ScoreManager<EmployeeRotation, HardSoftScore> scoreManager;

    public SolverStatus getSolverStatus() {
        return solverManager.getSolverStatus(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);
    }

    @PostMapping("/start")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "This method is used to assign to each employee an available rotation group & room.")
    public EmployeeRotation solve() throws RuntimeException {
        solverManager.solveAndListen(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID,
                employeeRotationRepository::findById,
                employeeRotationRepository::save);
        SolverStatus solverStatus = getSolverStatus();
        EmployeeRotation solution = employeeRotationRepository.findById(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);
        scoreManager.updateScore(solution);
        solution.setSolverStatus(solverStatus);

        return solution;
    }

    @PostMapping("/stop")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Method to stop solving.")
    public void stopSolving() {
        solverManager.terminateEarly(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);
    }
}
