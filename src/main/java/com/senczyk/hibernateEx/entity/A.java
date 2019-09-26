package com.senczyk.hibernateEx.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="a")
public class A {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="B_id")
	private B b;
	
	public A() {};
	public A(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}	
}
