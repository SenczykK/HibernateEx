package com.senczyk.hibernateEx.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Aaa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy="id", cascade= CascadeType.ALL, targetEntity=Bbb.class)
	private Set<Bbb> bbb;
	
	@Column(name="Bbb_id")
	private Long Bbb_id;
	
	public void add(Bbb bbbTemplate) {
		if(this.bbb == null) {
			this.bbb = new HashSet<>();
		}
		this.bbb.add(bbbTemplate);
		this.Bbb_id=bbbTemplate.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Bbb> getBbb() {
		return bbb;
	}

	public void setBbb(Set<Bbb> bbb) {
		this.bbb = bbb;
	}

	public Long getBbb_id() {
		return Bbb_id;
	}

	public void setBbb_id(Long bbb_id) {
		Bbb_id = bbb_id;
	}
	
	
	
}
