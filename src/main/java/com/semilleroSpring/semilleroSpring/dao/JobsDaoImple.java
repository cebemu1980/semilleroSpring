package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobsDaoImple implements JobsDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<JobsDTO> listarJobs() {
        String sql = "SELECT * FROM jobs";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(JobsDTO.class));
    }

    @Override
    public JobsDTO findById(String id) {
        try{
            String sql = "SELECT * FROM jobs WHERE job_id=?";
            JobsDTO jobs = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(JobsDTO.class),id);
            return jobs;
        }catch (IncorrectResultSetColumnCountException e){
            return null;
        }
    }


    @Override
    public int saveJob(JobsDTO j) {
        System.out.println("entro al dao a guardar");
        String sql = "INSERT INTO jobs(job_id,job_title,min_salary,max_salary) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{j.getJob_id(),j.getJob_title(),j.getMin_salary(),j.getMax_salary()});
    }

    @Override
    public int updateJob(JobsDTO j) {
        String sql = "UPDATE jobs SET job_title=?, min_salary=?, max_salary=? WHERE job_id=?";
        return jdbcTemplate.update(sql,new Object[]{j.getJob_title(),j.getMin_salary(),j.getMax_salary(),j.getJob_id()});
    }

    @Override
    public int deleteByIdJob(String id) {
        String sql = "DELETE FROM jobs WHERE job_id=?";
        return jdbcTemplate.update(sql, id);
    }


}
