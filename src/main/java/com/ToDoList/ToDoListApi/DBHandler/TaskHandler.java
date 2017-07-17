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
    
    public Task saveTask(String taskName, String descriptionTask) {
        Task task = new Task();
        try {
          entityManager.getTransaction().begin();
          task.setTaskName(taskName);
          task.setDescription(descriptionTask);
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

  public Task updateTask(Long taskId, String taskName, String descTask) {
    try {
      entityManager.getTransaction().begin();
      Task task = (Task) entityManager.find(Task.class, taskId);
      task.setTaskName(taskName);
      task.setDescription(descTask);
      entityManager.getTransaction().commit();
      return task;
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
    return null;
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

