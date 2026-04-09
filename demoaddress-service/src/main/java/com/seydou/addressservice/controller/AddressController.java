/**
 * 
 */
package com.seydou.addressservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.seydou.addressservice.dto.AddressResponse;
import com.seydou.addressservice.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) {
        AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
        // curl test at curl -X GET --location "http://localhost:8080/demoemployee/employees/1"
    }
    
    //findAddressByAddressId
    @GetMapping("/addressId/{Id}")
    public ResponseEntity<AddressResponse> getAddressByAddress(@PathVariable("Id") int Id) {
        AddressResponse addressResponse = addressService.findAddressByEmployeeId(Id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
        
        // test  -inside   curl -X GET --location "http://localhost:8081/demoaddress-service/addressId/2"
    }
    
}