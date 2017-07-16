package com.ToDoList.ToDoListApi;

/**
 *
 * @author Gerson Santos
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_TASK")
  private long taskId;
  @Column(name = "NAME")
  private String Name;

  public void setTaskId(long studentId) {
    this.taskId = studentId;
  }

  public long getTaskId() {
    return taskId;
  }

  public void setTaskName(String studentName) {
    this.Name = studentName;
  }

  public String getTaskName() {
    return Name;
  }

}
