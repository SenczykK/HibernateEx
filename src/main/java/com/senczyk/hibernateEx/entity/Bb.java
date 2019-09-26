package com.senczyk.hibernateEx.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bb {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy="bb", cascade=CascadeType.ALL)
	private Aa aa;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Aa getAa() {
		return aa;
	}
	public void setAa(Aa aa) {
		this.aa = aa;
	}
	
}
