package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
}
