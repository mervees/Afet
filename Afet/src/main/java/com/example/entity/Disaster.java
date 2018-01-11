package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="DISASTER")
public class Disaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="PERIOD")
	private int period;
	
	@Column(name="CITY")
	private City city;
	
	@Column(name="DISTRICT")
	private District district;
	
	@Column(name="VILLAGE")
	private Village village;
	
	@Column(name="NEIGHBORHOUD")
	private Neighborhood neighborhood;
	
	@Column(name="AREA")
	private String area;
	
	@Column(name="CAUSE")
	private String cause;
	
	@Column(name="AREA_AFFECTED")
	private String areaAffected;
	
	@Column(name="SOURCE")
	private String source;
	
	public Disaster() {
		// TODO Auto-generated constructor stub
	}
	
	public Disaster(int id, String name, Date startDate, Date endDate, int period, City city, District district,
			Village village, Neighborhood neighborhood, String area, String cause, String areaAffected, String source) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.period = period;
		this.city = city;
		this.district = district;
		this.village = village;
		this.neighborhood = neighborhood;
		this.area = area;
		this.cause = cause;
		this.areaAffected = areaAffected;
		this.source = source;
	}
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public Neighborhood getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getAreaAffected() {
		return areaAffected;
	}
	public void setAreaAffected(String areaAffected) {
		this.areaAffected = areaAffected;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
