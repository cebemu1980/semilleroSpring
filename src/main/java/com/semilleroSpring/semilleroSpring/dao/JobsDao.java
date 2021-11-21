package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;

import java.util.List;

public interface JobsDao {
    List<JobsDTO> getAllJobs();
}
