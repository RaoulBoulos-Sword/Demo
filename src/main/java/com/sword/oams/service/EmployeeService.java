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

import javax.transaction.Transactional;

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

		Room room = this.roomRepository.findById(request.getRoomId()).orElse(null);
		Team team = this.teamRepository.findById(request.getTeamId()).orElse(null);

		Employee employee = Employee.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.room(room)
				.team(team).build();

		return employeeRepository.save(employee);

	}
}
