package com.dia.app_boot_secure.service;

import com.dia.app_boot_secure.Repository.JobTitleRepository;
import com.dia.app_boot_secure.model.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;

    public List<JobTitle> getJobTitle(){
        return jobTitleRepository.findAll();
    }

    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }
    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    public void delete(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
