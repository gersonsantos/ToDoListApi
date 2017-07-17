/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ToDoList.ToDoListApi.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Gerson Santos
 */
@Entity
@Table(name="LIST", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"ID_LIST"})})
public class List implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LIST", nullable=false, unique=true, length=11)
	private int idList;
	
	@Column(name="NAME", length=255, nullable=true)
	private String name;
        
        @Column(name="DESCRIPTION", length=1000, nullable=true)
	private String description;
        
        @Column(name="ID_STATUS", length=20, nullable=true)
	private int idStatus;
	
	public int getId() {
		return idList;
	}
	public void setId(int id) {
		this.idList = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
        public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
        public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int id) {
		this.idStatus = id;
	}
}
