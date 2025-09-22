package com.examly.springapp.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.examly.springapp.model.Language;
import com.examly.springapp.service.LanguageService;
 
@RestController
public class LanguageController {
    @Autowired
    LanguageService ls;
 
    @PostMapping("/language")
    public ResponseEntity<Language> adddata(@RequestBody Language l)
    {
        Language obj=ls.create(l);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
 
    @GetMapping("/language")
    public ResponseEntity<List<Language>> showdetails()
    {
        return new ResponseEntity<>(ls.getalldetail(),HttpStatus.OK);
    }
 
    @GetMapping("/language/{languageId}")
    public ResponseEntity<Language> getById(@PathVariable int languageId)
    {
        Language obj = ls.getbyid(languageId);
        if(obj!=null)
            return new ResponseEntity<>(obj,HttpStatus.OK);
        else    
            return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
    }
 
    @PutMapping("/language/{languageId}")
    public ResponseEntity<Language> putMethod(@PathVariable("languageId") int languageId,@RequestBody Language l)
    {
        if(ls.updateDetails(languageId,l) == true)
        {
            return new ResponseEntity<>(l,HttpStatus.OK);
        }
       
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/language/{languageId}")
    public ResponseEntity<Boolean> delete(@PathVariable("languageId") int languageId)
    {
        if(ls.deleteEmployee(languageId) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
