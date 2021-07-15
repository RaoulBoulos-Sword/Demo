package com.sword.oams.service;

import com.sword.oams.domain.Employee;
import com.sword.oams.domain.Room;
import com.sword.oams.domain.Team;
import com.sword.oams.payload.request.EmployeeRequest;
import com.sword.oams.repository.EmployeeRepository;
import com.sword.oams.repository.RoomRepository;
import com.sword.oams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	TeamRepository teamRepository;

	public Employee addEmployee(EmployeeRequest request) {
		//Room room = this.roomRepository.findById(request.getRoomId()).orElse(null);
		Team team = this.teamRepository.findById(request.getTeamId()).orElse(null);

		Employee employee = Employee.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				//.room(room)
				.team(team).build();

		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Employee Id Not Found"));
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void deleteEmployeeById(Long id) { employeeRepository.deleteById(id); }

	public Employee updateEmployeeById(Long id, EmployeeRequest request) {
		Team team = teamRepository.findById(request.getTeamId()).orElse(null);
		//Room room = this.roomRepository.findById(request.getRoomId()).orElse(null);

		return employeeRepository.findById(id)
				.map(employee -> {
					employee.setFirstName(request.getFirstName());
					employee.setLastName(request.getLastName());
					employee.setTeam(team);
					//employee.setRoom(room);

					return employeeRepository.save(employee);
				})
				.orElse(null);
	}
}
