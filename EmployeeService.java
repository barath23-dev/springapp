package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo er;
    public Employee adddata(Employee e)
    {
        return er.save(e);
    }
    public List<Employee> getalldetail()
    {
        return er.findAll();
    }
    public Employee getById(int employeeId)
    {
        return er.findById(employeeId).orElse(null);
    }
    public boolean updateDetails(int employeeId, Employee e)
    {
        if(this.getById(employeeId)==null)
        {
            return false;
        }
        try{
            er.save(e);
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int employeeId)
    {
        if(this.getById(employeeId)==null){
            return false;
        }
        er.deleteById(employeeId);
        return true;
    }
}
