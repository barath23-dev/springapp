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

import com.examly.springapp.model.Shirt;
import com.examly.springapp.service.ShirtService;

@RestController
public class ShirtController {
    @Autowired
    ShirtService ss;
    @PostMapping("/shirt")
    public ResponseEntity<Shirt> adddata(@RequestBody Shirt s)
    {
        Shirt obj=ss.create(s);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);

    }
    @GetMapping("/shirt")
    public ResponseEntity<List<Shirt>> showdetails()
    {
        return new ResponseEntity<>(ss.getalldetail(),HttpStatus.OK);

    }
    @GetMapping("/shirt/{shirtId}")
    public ResponseEntity<Shirt> getById(@PathVariable int shirtId)
        {
            Shirt obj=ss.getbyid(shirtId);
            if(obj!=null)
                return new ResponseEntity<>(obj,HttpStatus.OK);
            else
                return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);

        }
    @PutMapping("/shirt/{shirtId}")
    public ResponseEntity<Shirt> putMethod(@PathVariable("shirtId") int
        shirtId,@RequestBody Shirt s)
        {
            if(ss.updateDetails(shirtId, s)==true)
            {
                return new ResponseEntity<>(s,HttpStatus.OK);
            }
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    @DeleteMapping("/shirt/{shirtId}")
    public ResponseEntity<Boolean> delete(@PathVariable("shirtId") int
        shirtId)
        {
            if(ss.deleteShirt(shirtId)==true)
            {
                return new ResponseEntity<>(true,HttpStatus.OK);
            }
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }
