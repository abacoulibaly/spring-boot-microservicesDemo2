/**
 * 
 */
package com.seydou.demo.demoEmployee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.seydou.addressservice.dto.AddressResponse;
import com.seydou.demo.demoEmployee.employeeResponse.EmployeeResponse;
import com.seydou.demo.demoEmployee.model.Employee;
import com.seydou.demo.demoEmployee.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;

/**
 * Employee Service
 */
@Service
public class EmployeeServiceRestTemplate {



		private static final String HTTP_LOCALHOST_8081_DEMOADDRESS_SERVICE_ADDRESS_ID 
		= "http://localhost:8081/demoaddress-service/address/{id}";

		@Autowired
		private EmployeeRepo employeeRepo;

		@Autowired
		private ModelMapper mapper;

		@Autowired
		private RestTemplate restTemplate;

		public EmployeeResponse getEmployeeById(int id) {

			Optional<Employee> employee = employeeRepo.findById(id);
			EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
            //url to pull 
			AddressResponse addressResponse = restTemplate
					.getForObject(HTTP_LOCALHOST_8081_DEMOADDRESS_SERVICE_ADDRESS_ID, AddressResponse.class, id);
			employeeResponse.setAddressResponse(addressResponse);

			return employeeResponse;
		}

		/**
		 * 
		 * @return List<Employees>
		 */
		public List<Employee> getEmployees() {
			return employeeRepo.findAll();
		}

		public Employee getEmployeeByIdOrThrowError(int id) {
			return employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee id not found!"));

		}
	
}