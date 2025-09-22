package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
private EmployeeService es;
    @Autowired
    public EmployeeController(EmployeeService es) {
        this.es = es;
    }

   
    @PostMapping("/employee")
    public ResponseEntity<Employee> adddata(@RequestBody Employee e)
    {
        Employee obj=es.adddata(e);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }


    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Employee>
    putMethod(@PathVariable("employeeId") int employeeId, @RequestBody Employee e)
    {
if (es.updateDetails(employeeId,e)==true)
{
    return new ResponseEntity<>(e,HttpStatus.OK);
}
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<Boolean> delete(@PathVariable("employeeId") int employeeId)
    {
        if(es.deleteEmployee(employeeId)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
