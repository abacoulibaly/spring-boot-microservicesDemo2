/**
 * 
 */
package com.seydou.addressservice.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seydou.addressservice.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(
        nativeQuery = true,
        value
        = "SELECT ea.id, ea.city, ea.state FROM seydoumicroservicesdemo.address ea join seydoumicroservicesdemo.employee"
        		+ " e on e.id = ea.employee_id where ea.employee_id=:employeeId")
       Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
    @Query(
            nativeQuery = true,
            value
            = "SELECT * FROM seydoumicroservicesdemo.address where  id=id")
    
    Optional<Address> findAddressByAddressId(@Param("id") int id);
    
}