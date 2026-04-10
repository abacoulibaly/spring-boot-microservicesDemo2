/**
 * 
 */
package com.seydou.demo.demoEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seydou.demo.demoEmployee.model.Employee;

/**
 * 
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
