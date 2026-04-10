/**
 * 
 */
package com.seydou.demo.demoEmployee.employeeResponse;

import java.util.Objects;

import com.seydou.addressservice.dto.AddressResponse;

/**
 * 
 */
public class EmployeeResponse {

	private int id;
    private String name;
    private String email;
    private String age;


    // Adding AddressResponse to use restTemplate
    private AddressResponse addressResponse;

	public int getId() {
        return id;
    }

 

	public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    @Override
   	public int hashCode() {
   		return Objects.hash(age, email, id, name);
   	}

   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		EmployeeResponse other = (EmployeeResponse) obj;
   		return Objects.equals(age, other.age) && Objects.equals(email, other.email) && id == other.id
   				&& Objects.equals(name, other.name);
   	}
    /**
 	 * @return the addressResponse
 	 */
 	public AddressResponse getAddressResponse() {
 		return addressResponse;
 	}

 	/**
 	 * @param addressResponse the addressResponse to set
 	 */
 	public void setAddressResponse(AddressResponse addressResponse) {
 		this.addressResponse = addressResponse;
 	}

    
}
