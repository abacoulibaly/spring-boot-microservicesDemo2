/**
 * 
 */
package com.seydou.demo.demoEmployee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seydou.demo.demoEmployee.employeeResponse.EmployeeResponse;
import com.seydou.demo.demoEmployee.model.Employee;
import com.seydou.demo.demoEmployee.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;

/**
 * Employee Service
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public EmployeeResponse getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
		return employeeResponse;

	}

	public Employee getEmployeeByIdOrThrowError(int id) {
		return employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee id not found!"));

	}

	/**
	 * 
	 * @return List<Employees>
	 */
	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}
}
