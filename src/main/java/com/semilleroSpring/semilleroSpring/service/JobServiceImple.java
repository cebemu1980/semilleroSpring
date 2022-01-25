package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dao.JobsDao;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JobServiceImple implements JobService{

    @Autowired
    private JobsDao jobsDao;

    @Override
    public List<JobsDTO> listarJobs() {
        return jobsDao.listarJobs();
    }

    @Override
    public JobsDTO findById(String id) {
        return jobsDao.findById(id);
    }


    @Override
    public int saveJob(JobsDTO jobsDTO) {
        return jobsDao.saveJob(jobsDTO);
    }

    @Override
    public int updateJob(JobsDTO j) {
        return jobsDao.updateJob(j);
    }


    @Override
    public int createOrUpdate(JobsDTO jobsDTO) {
        System.out.println("entro al servicio de createOrUpdate"+jobsDTO);
        int cuantos = jobsDao.exist(jobsDTO.getJob_id());
        int exitoso=0;
        if (cuantos >0) {
            exitoso=jobsDao.updateJob(jobsDTO);

        }else{
            exitoso=jobsDao.saveJob(jobsDTO);
        }
        return exitoso;
    }

    @Override
    public int deleteByIdJob(String id) {
        System.out.println("entro al deleteByIdJob de JobServiceImple "+id);
        return jobsDao.deleteByIdJob(id);
    }




}
