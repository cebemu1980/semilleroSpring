package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;

import java.util.List;

public interface JobsDao {
    List<JobsDTO> listarJobs();
    JobsDTO findById(String id);
    int saveJob(JobsDTO jobsDTO);
    int updateJob(JobsDTO j);
    int deleteByIdJob(String id);
    public  int exist(String id);


}
