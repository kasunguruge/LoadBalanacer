package com.example.demo.modal;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;

	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	Address address;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	List<Telephone> telephones;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_project", 
	joinColumns = @JoinColumn(name = "eid", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "pid", referencedColumnName = "id"))
	@Fetch(value = FetchMode.SUBSELECT)
	List<Project> projects;


	@Transient

	Allocation[] allocation;


	public Allocation[] getAllocation() {
		return allocation;
	}

	public void setAllocation(Allocation[] allocation) {
		this.allocation = allocation;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}