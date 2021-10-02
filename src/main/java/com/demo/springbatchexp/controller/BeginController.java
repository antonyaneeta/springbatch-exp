package com.demo.springbatchexp.controller;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/load")
public class BeginController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping
    public BatchStatus begin() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException,
            JobParametersInvalidException, JobRestartException {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println(String.format("Job Status : [%s]" ,jobExecution.getStatus()));

        System.out.println("Batch running ...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }



        return jobExecution.getStatus();
    }
}


