/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ToDoList.ToDoListApi.DBHandler;

import com.ToDoList.ToDoListApi.EntityManagerUtil;
import com.ToDoList.ToDoListApi.Model.TaskFact;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gerson Santos
 */
public class TaskFactHandler {
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    public TaskFact saveTaskFct(String taskDescription) {
        TaskFact task = new TaskFact();
        try {
          entityManager.getTransaction().begin();
          task.setDescription(taskDescription);
          java.util.Date date = new java.util.Date();
          task.setFactDate(date);
          task = entityManager.merge(task);
          entityManager.getTransaction().commit();
        } catch (Exception e) {
          entityManager.getTransaction().rollback();
        }
        return task;
  }

  public void listTaskFct() {
    try {
      entityManager.getTransaction().begin();
      @SuppressWarnings("unchecked")
      List<TaskFact> Tasks = entityManager.createQuery("from Task").getResultList();
      for (Iterator<TaskFact> iterator = Tasks.iterator(); iterator.hasNext();) {
        TaskFact taskFact = (TaskFact) iterator.next();
        System.out.println(taskFact.getDescription());
      }
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

  public void updateTaskFct(Long taskId, String taskDescription) {
    try {
      entityManager.getTransaction().begin();
      TaskFact taskFct = (TaskFact) entityManager.find(TaskFact.class, taskId);
        taskFct.setDescription(taskDescription);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

  public void deleteTaskFct(Long taskId) {
    try {
      entityManager.getTransaction().begin();
      TaskFact task = (TaskFact) entityManager.find(TaskFact.class, taskId);
      entityManager.remove(task);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }
}
