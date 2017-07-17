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
@Table(name="LIST_STATUS", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"ID_STATUS"})})
public class ListStatus implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STATUS", nullable=false, unique=true, length=11)
	private int idStatus;
	
	@Column(name="NAME", length=255, nullable=true)
	private String name;	
	
	public int getId() {
		return idStatus;
	}
	public void setId(int id) {
		this.idStatus = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

