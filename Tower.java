package edu.neu.cs5200.hw5.orm.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Tower {
	@Id
	private Integer id;
	private String name;
	private Double height;
	private Integer sides;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="siteId")
	private Site site;
	
	@OneToMany(mappedBy="tower")
	private List<Equipment> equipments;
	
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
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Integer getSides() {
		return sides;
	}
	public void setSides(Integer sides) {
		this.sides = sides;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public Tower(Integer id, String name, Double height, Integer sides,
			Site site) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.site = site;
	}
	public Tower() {
		super();
	}

}
