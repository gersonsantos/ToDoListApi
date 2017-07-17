/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ToDoList.ToDoListApi.Map;

import com.ToDoList.ToDoListApi.DBHandler.TaskHandler;
import com.ToDoList.ToDoListApi.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gerson Santos
 */
@RestController 
@Controller
@RequestMapping("/task")
public class RequestMapper {
     
    @RequestMapping("/hello")  
    public String hello() {   
     return "Hello, world"; 
     }

    //Creates a new Task.
    @RequestMapping("/POST/{name}/{description}") 
    @ResponseBody
    public Task createTask(@PathVariable("name") String nombretask, @PathVariable("description") String desctask) {    
        TaskHandler taskhandlr = new TaskHandler();
        System.out.println("After Sucessfully insertion ");
        Task task1 = taskhandlr.saveTask(nombretask,desctask);
        
        return task1;
     }
    
    @RequestMapping("/PUT/{id}/{name}/{description}") 
    @ResponseBody
    public Task editTask(@PathVariable("id") long idtask, @PathVariable("name") String nombretask, @PathVariable("description") String desctask) {    
        TaskHandler taskhandlr = new TaskHandler();
        System.out.println("After Sucessfully modification ");
        Task task1 = taskhandlr.updateTask(idtask,nombretask,desctask);        
        return task1;
     }

    //Fallback Method
    @RequestMapping("*")
    @ResponseBody
    public String fallbackMethod(){
            return "fallback method";
    }
    
    @RequestMapping("/error")
    @ResponseBody
    public String errorMethod(){
            return "fallback method";
    }

}
