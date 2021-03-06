package com.ToDoList.ToDoListApi.Model;

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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="TASK", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"ID_TASK"})})
public class Task implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_TASK")
  private long taskId;
  @Column(name = "NAME")
  private String Name;
  @Column(name = "DESCRIPTION")
  private String Description;
  

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }

  public long getTaskId() {
    return taskId;
  }

  public void setTaskName(String taskName) {
    this.Name = taskName;
  }

  public String getTaskName() {
    return Name;
  }
    public String getDescription() {
      return Description;
  }

  public void setDescription(String Description) {
      this.Description = Description;
  }


}
