package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dao.JobsDao;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@Service
public class JobServiceImple implements JobService{

    @Autowired
    private JobsDao jobsDao;

    @Override
    public List<JobsDTO> getAllJobs() {
        return jobsDao.getAllJobs();
    }
}
