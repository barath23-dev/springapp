package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Job;
import com.example.springapp.repository.JobRepo;

@Service
public class JobService {
    private JobRepo jobRepo;

    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }
    public Job postjob(Job obj){
        return jobRepo.save(obj);
    }
    public List<Job> getAllJobs()
    {
        return jobRepo.findAll();
    }
    public Optional<Job> getJobById(Integer jobId)
    {
        return jobRepo.findById(jobId);
    }
   
}
