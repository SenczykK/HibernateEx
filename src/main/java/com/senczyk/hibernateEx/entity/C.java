package com.senczyk.hibernateEx.entity;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;

import com.senczyk.hibernateEx.colors.Color;

@Entity
public class C {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String name;
	
	@NonNull
	private LocalDate myDate;
	
	@NonNull
	private LocalDate myDate2;
	
	@NonNull
	@Convert(converter = Color.class)
	private Color myColor;

	
	
	public C(String name, LocalDate myDate, LocalDate myDate2, Color myColor) {
		super();
		this.name = name;
		this.myDate = myDate;
		this.myDate2 = myDate2;
		this.myColor = myColor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getMyDate() {
		return myDate;
	}

	public void setMyDate(LocalDate myDate) {
		this.myDate = myDate;
	}
	
	public void setMyDate2(LocalDate myDate2) {
		this.myDate2 = myDate2;
	}

	public LocalDate getMyDate2() {
		return myDate2;
	}

	public Color getMyColor(Color color) {
		return Color.valueOf(color.getColor());
	}

	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}
	
	
}
