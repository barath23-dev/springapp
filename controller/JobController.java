package com.example.springapp.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Job;
import com.example.springapp.service.JobService;

@RestController
@RequestMapping("/api")
public class JobController {
    private JobService jobService;
@Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @PostMapping("/job")
    public ResponseEntity<Job> postJob(@RequestBody Job obj){
      Job solution = jobService.postjob(obj);
      return ResponseEntity.status(HttpStatus.CREATED).body(solution);
    }
    @GetMapping("/job")
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobs = jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    @GetMapping("/job/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable int jobId){
        Optional<Job> job = jobService.getJobById(jobId);
        if(job.isPresent()){
            return new ResponseEntity<Job>(job.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
