/**
 * 
 */
package com.seydou.demo.demoEmployee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.seydou.demo.demoEmployee.employeeResponse.EmployeeResponse;
import com.seydou.demo.demoEmployee.model.Employee;
import com.seydou.demo.demoEmployee.services.EmployeeServiceRestTemplate;
/**
 * Seydou Coulibaly  
 */

@RestController
public class EmployeeController {

    @Autowired
   // private EmployeeService employeeService;
    private EmployeeServiceRestTemplate employeeService;  // to use RestTemplate

    @GetMapping("/employees/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
       
    }
    
	@GetMapping("api/v1/employees")
	private List<Employee> getAllEmployee() {
		return employeeService.getEmployees();

	}
}
