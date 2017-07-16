package com.ToDoList.ToDoListApi;

import com.ToDoListApi.Model.Task;
import com.ToDoListApi.Model.List;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;

//import javax.persistence.EntityManager;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.EntityManager;
//import java.util.Collection;
//import java.util.stream.Stream;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RestResource;
//import org.springframework.stereotype.Component;

@SpringBootApplication
public class ToDoListApiApplication {

         private EntityManager entityManager = EntityManagerUtil.getEntityManager();
         
	public static void main(String[] args) {
		SpringApplication.run(ToDoListApiApplication.class, args);
                
                //This is for testing 
                 ToDoListApiApplication example = new ToDoListApiApplication();
    System.out.println("After Sucessfully insertion ");
    Task student1 = example.saveTask("Sumith");
    Task student2 = example.saveTask("Anoop");
    //example.listStudent();
    System.out.println("After Sucessfully modification ");
    example.updateTask(student1.getTaskId(), "Sumith Honai");
    example.updateTask(student2.getTaskId(), "Anoop Pavanai");
    //example.listStudent();
    System.out.println("After Sucessfully deletion ");
    example.deleteTask(student2.getTaskId());
    //example.listStudent();
   
                
	}
        
    public Task saveTask(String taskName) {
        Task task = new Task();
        try {
          entityManager.getTransaction().begin();
          task.setTaskName(taskName);
          task = entityManager.merge(task);
          entityManager.getTransaction().commit();
        } catch (Exception e) {
          entityManager.getTransaction().rollback();
        }
        return task;
  }
/*
  public void listStudent() {
    try {
      entityManager.getTransaction().begin();
      @SuppressWarnings("unchecked")
      List<Student> Students = entityManager.createQuery("from Student").getResultList();
      for (Iterator<Student> iterator = Students.iterator(); iterator.hasNext();) {
        Student student = (Student) iterator.next();
        System.out.println(student.getStudentName());
      }
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }
*/
  public void updateTask(Long taskId, String taskName) {
    try {
      entityManager.getTransaction().begin();
      Task student = (Task) entityManager.find(Task.class, taskId);
      student.setTaskName(taskName);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

  public void deleteTask(Long taskId) {
    try {
      entityManager.getTransaction().begin();
      Task task = (Task) entityManager.find(Task.class, taskId);
      entityManager.remove(task);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }
}
/*
@RepositoryRestResource //Esto es para usar Spring Data y se pretende usar Hibernate
interface RnRepository extends JpaRepository{
    //@RestResource(path = "by-name")
    //Collection findByReservationName(@Param("rn") String rn);
}

@Component
class DummyCLR implements CommandLineRunner {
    @Autowired
    private RnRepository repository;
    @Override
    public void run(String... args) throws Exception {
        /*Stream.of("Josh", "Geertjan", "Pieter").forEach(x -> 
           repository.save(new Task()));
        repository.findAll().forEach(System.out::println);*/
      //  System.out.println("Hello");
    //}
//}