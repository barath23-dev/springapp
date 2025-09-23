package com.example.springapp.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.springapp.model.Children;
 
public interface ChildrenRepo extends JpaRepository<Children,Integer>{
   
}
 
