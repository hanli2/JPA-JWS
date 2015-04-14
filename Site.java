package edu.neu.cs5200.hw5.orm.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;
import javax.persistence.*;

@Entity


public class Site {
	@Id
    private Integer id;
	private String name;
	private Double latitude;
	private Double longitude;
	@OneToMany(mappedBy="site")
	private List<Tower> towers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public List<Tower> getTowers() {
		return towers;
	}
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}
	public Site(Integer id, String name, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Site() {
		super();
	}
	
}