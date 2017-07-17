/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ToDoList.ToDoListApi.DBHandler;

import com.ToDoList.ToDoListApi.EntityManagerUtil;
import com.ToDoList.ToDoListApi.Model.Task;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gerson Santos
 */
public class TaskHandler {
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
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

  public void listTask() {
    try {
      entityManager.getTransaction().begin();
      @SuppressWarnings("unchecked")
      List<Task> Tasks = entityManager.createQuery("from Task").getResultList();
      for (Iterator<Task> iterator = Tasks.iterator(); iterator.hasNext();) {
        Task student = (Task) iterator.next();
        System.out.println(student.getTaskName());
      }
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

  public void updateTask(Long taskId, String taskName) {
    try {
      entityManager.getTransaction().begin();
      Task task = (Task) entityManager.find(Task.class, taskId);
      task.setTaskName(taskName);
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

