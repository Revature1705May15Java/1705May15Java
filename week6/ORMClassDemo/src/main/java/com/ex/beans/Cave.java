package com.ex.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVE")
public class Cave implements Serializable{
	
	private static final long serialVersionUID = 2477978902890111704L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caveSeq")
	@SequenceGenerator(allocationSize=1,name="caveSeq", sequenceName="CAVE_SEQ")
	@Column(name="CAVE_ID")
	private int id;
	
	@Column(name="CAVE_NAME")
	private String name;
	
	@OneToMany(mappedBy="cave", fetch=FetchType.EAGER)
	List<Animal> occupants;
	
	public Cave(){}
	
	public Cave(String name) {
		super();
		this.name = name;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + ", occupants=" + occupants + "]";
	}
	
	
}
