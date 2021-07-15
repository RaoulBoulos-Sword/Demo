package com.sword.oams.rest;

import com.sword.oams.domain.EmployeeRotation;
import com.sword.oams.repository.EmployeeRotationRepository;
import io.swagger.annotations.Api;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @GetMapping("")
    public EmployeeRotation getEmployeeRotation() {
        SolverStatus solverStatus = getSolverStatus();
        EmployeeRotation solution = employeeRotationRepository.findById(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);
        scoreManager.updateScore(solution);
        solution.setSolverStatus(solverStatus);

        return solution;
    }

    @PostMapping("/start")
    public void solve() {
        solverManager.solveAndListen(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID,
                employeeRotationRepository::findById,
                employeeRotationRepository::save);
    }

    @PostMapping("/stop")
    public void stopSolving() {
        solverManager.terminateEarly(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);
    }



}
