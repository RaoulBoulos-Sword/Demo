package com.sword.oams.rest;

import com.sword.oams.domain.*;
import com.sword.oams.repository.EmployeeRepository;
import com.sword.oams.repository.EmployeeRotationRepository;
import com.sword.oams.repository.RoomRepository;
import com.sword.oams.repository.RotationRepository;
import com.sword.oams.service.EmployeeService;
import com.sword.oams.service.RoomService;
import io.swagger.annotations.Api;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/oams/solve")
@Api(tags = "OptaPlanner Solver")
public class SolverController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RotationRepository rotationRepository;

    @Autowired
    RoomRepository roomRepository;

    //Throwing Exception
    @Autowired
    private EmployeeRotationRepository employeeRotationRepository;

    @Autowired
    private SolverManager<EmployeeRotation, Long> solverManager;

    @Autowired
    private ScoreManager<EmployeeRotation, HardSoftScore> scoreManager;

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }


    public SolverStatus getSolverStatus() {
        return solverManager.getSolverStatus(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);
    }

    @PostMapping("/start")
    public EmployeeRotation solve() throws RuntimeException {

        /*List<Employee> employeeCount = employeeRepository.findAll();
        List<Employee> rotationIds = employeeCount.stream().filter(distinctByKey(Employee::getRotationGroup)).collect(Collectors.toList());
        List<Employee> preScheduledEmployees = employeeCount.stream().filter(x -> x.getRotationGroup()!=null && x.getRotationGroup().getRotationId()!=null).collect(Collectors.toList());

        if(preScheduledEmployees.size()>0) {
            for (Employee rot : rotationIds) {
                solverManager.solveAndListen(rot.getRotationGroup().getRotationId(),
                        employeeRotationRepository::findById,
                        employeeRotationRepository::save);
                SolverStatus solverStatus = getSolverStatus();
                EmployeeRotation solution = employeeRotationRepository.findById(rot.getRotationGroup().getRotationId());
                scoreManager.updateScore(solution);
                solution.setSolverStatus(solverStatus);

                return solution;
            }
        }else {
                solverManager.solveAndListen(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID,
                        employeeRotationRepository::findById,
                        employeeRotationRepository::save);

            SolverStatus solverStatus = getSolverStatus();
            EmployeeRotation solution = employeeRotationRepository.findById(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);
            scoreManager.updateScore(solution);
            solution.setSolverStatus(solverStatus);

            return solution;
            }
        return employeeRotationRepository.findById(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);*/
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
    public void stopSolving() {
        solverManager.terminateEarly(EmployeeRotationRepository.SINGLETON_EMPLOYEE_ROTATION_ID);
    }
}
