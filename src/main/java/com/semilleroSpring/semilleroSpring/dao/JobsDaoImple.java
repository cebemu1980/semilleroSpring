package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Component
@Repository
public class JobsDaoImple implements JobsDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JobsDaoImple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<JobsDTO> getAllJobs() {
        String sql = "SELECT job_id FROM jobs";
        return jdbcTemplate.query(sql, (rs, rowNum)->{
            JobsDTO jobsDTO = new JobsDTO();
            jobsDTO.setJob_id(rs.getString("job_id"));
            return jobsDTO;
        });
    }
}
