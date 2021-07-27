package com.stoom.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@Entity
@Table(name="Endereco")
public class Endereco{
		 
	 @Id
	 @SequenceGenerator(name= "ENDERECO_SEQUENCE", sequenceName = "ENDERECO_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.AUTO, generator="ENDERECO_SEQUENCE")
	 private Long id;
	 
	 @Column(name = "streetname", nullable = false)
	 private String streetName;
	 
	 @Column(name = "numero",nullable = false)
	 private Integer number;
	 
	 @Column(name = "complement")
	 private String complement;
	 
	 @Column(name = "neighbourhood", nullable = false)
	 private String neighbourhood;
	 
	 @Column(name = "city", nullable = false)
	 private String city;
	 
	 @Column(name = "state",nullable = false)
	 private String state;
	 
	 @Column(name = "country", nullable = false)
	 private String country;
	 
	 @Column(name = "zipcode", nullable = false)
	 private Long zipCode;
	 
	 @Column(name = "latitude")
	 private String latitude;
	 
	 @Column(name = "longitude")
	 private String longitude;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", streetName=" + streetName + ", neighbourhood=" + neighbourhood + '}';
    }
	 
}
