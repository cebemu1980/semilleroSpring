package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;

import java.util.List;

public interface JobService {
    List<JobsDTO> listarJobs();
    JobsDTO findById(String id);
    int saveJob(JobsDTO jobsDTO);
    int updateJob(JobsDTO j);
    int createOrUpdate(JobsDTO jobsDTO);
    int deleteByIdJob(String id);
}
