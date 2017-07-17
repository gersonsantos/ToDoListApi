package com.ToDoList.ToDoListApi;



import com.ToDoList.ToDoListApi.Model.Task;
import com.ToDoList.ToDoListApi.DBHandler.TaskHandler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//import com.ToDoListApi.Model.List;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;

//import javax.persistence.EntityManager;
import java.util.List;
import java.util.Iterator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.stream.Stream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ToDoListApiApplication {         
         
    public static void main(String[] args) {
    SpringApplication.run(ToDoListApiApplication.class, args);
                
                //This is for populating the database  
    TaskHandler example = new TaskHandler();
    System.out.println("After Sucessfully insertion ");
    Task task1 = example.saveTask("Crear","Crear un proyecto");
    Task task2 = example.saveTask("Editar","Editar un proyecto");
    //example.listStudent();
    System.out.println("After Sucessfully modification ");
    example.updateTask(task1.getTaskId(), "Sumith Honai","Crear un proyecto");
    example.updateTask(task2.getTaskId(), "Anoop Pavanai","Editar un proyecto");
    //example.listStudent();
    System.out.println("After Sucessfully deletion ");
    example.deleteTask(task2.getTaskId());
    //example.listStudent();
   
                
	}
    
}