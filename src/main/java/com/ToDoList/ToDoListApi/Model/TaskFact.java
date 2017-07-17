/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ToDoList.ToDoListApi.Model;

import java.text.SimpleDateFormat;
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
@Table(name = "TSK_TRCKNG_FCT")
/*@Table(name="TSK_TRCKNG_FCT", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"ID_TASK"})})*/
public class TaskFact implements java.io.Serializable{

	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TASK", nullable=false, unique=true, length=11)
	private int idTask;
	
	@Column(name="DESCRIPTION", length=1000, nullable=true)
	private String description;
        @Id // Dummy ID
        @Column(name="FACT_DATE", nullable=true)
	private Date factDate;
	
	public int getId() {
		return idTask;
	}
	public void setId(int id) {
		this.idTask = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String name) {
		this.description = name;
	}
        public Date getFactDate() {
		return factDate;
	}
	public void setFactDate(Date factDate) {
		this.factDate = factDate;
	}
}
