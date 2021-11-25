package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JobsDaoImple implements JobsDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<JobsDTO> listarJobs() {
        String sql = "SELECT * FROM jobs";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(JobsDTO.class));
    }

    /*
    @Override
    public List<JobsDTO> listarJobs() {
        String sql = "SELECT * FROM jobs";
        //return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(JobsDTO.class));
        List<JobsDTO> jobsDTOList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<JobsDTO>(JobsDTO.class));
        return jobsDTOList;
    }
     */


/*
    @Override
    public List<JobsDTO> listarJobs() {
        //return jdbcTemplate.query("SELECT job_id FROM jobs", BeanPropertyRowMapper.newInstance(JobsDTO.class));
        String sql = "SELECT * FROM jobs";
        List<JobsDTO> jobsList = new ArrayList<JobsDTO>();
        List<Map<String, Object>> fila = jdbcTemplate.queryForList(sql);
        fila.forEach(rs -> {
            JobsDTO jobsDTO = new JobsDTO();
            jobsDTO.setJob_id((String) rs.get(""));
            jobsDTO.setJob_title((String) rs.get(""));
            jobsDTO.setMin_salary((int) rs.get(""));
            jobsDTO.setMax_salary((int) rs.get(""));
            jobsList.add(jobsDTO);
        });
        return jobsList;
    }
 */
}
