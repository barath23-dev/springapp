package com.examly.springapp.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.examly.springapp.model.Language;
import com.examly.springapp.repository.LanguageRepo;
 
@Service
public class LanguageService {
    @Autowired
    LanguageRepo lr;
    public Language create(Language l)
    {
        return lr.save(l);
    }
 
    public List<Language> getalldetail()
    {
        return lr.findAll();
    }
 
    public Language getbyid(int languageId)
    {
        return lr.findById(languageId).orElse(null);
    }
   
    public boolean updateDetails(int languageId,Language l)
    {
        if(this.getbyid(languageId)==null)
        {
            return false;
        }
        try{
            lr.save(l);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int employeeId)
    {
        if(this.getbyid(employeeId) == null)
        {
            return false;
        }
        lr.deleteById(employeeId);
        return true;
    }
 
}
