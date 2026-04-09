/**
 * 
 */
package com.seydou.addressservice.dto;

import java.util.Objects;

/**
 * 
 */
public class AddressResponse {


    private int id;
    private String city;
    private String state;



	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    //*******
    @Override
	public int hashCode() {
		return Objects.hash(city, id, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressResponse other = (AddressResponse) obj;
		return Objects.equals(city, other.city) && id == other.id && Objects.equals(state, other.state);
	}
}