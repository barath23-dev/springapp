package com.examly.springapp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Shirt;
import com.examly.springapp.repository.ShirtRepository;

@Service
public class ShirtService {
    @Autowired
    ShirtRepository sr;
    public Shirt create(Shirt s)
    {
        return sr.save(s);
    }
    public List<Shirt> getalldetail()
    {
        return sr.findAll();
    }
    public Shirt getbyid(int shirtId)
    {
        return sr.findById(shirtId).orElse(null);
    }
    public boolean updateDetails(int shirtId,Shirt s)
    {
        if(this.getbyid(shirtId)==null)
        {
            return false;
        }
        try{
            sr.save(s);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
     public boolean deleteShirt(int shirtId)
     {
        if(this.getbyid(shirtId)==null)
        {
            return false;
        }
        sr.deleteById(shirtId);
        return true;
     }
    
}
