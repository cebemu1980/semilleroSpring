package com.semilleroSpring.semilleroSpring.maper;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaperJobs implements RowMapper<JobsDTO> {

    @Override
    public JobsDTO mapRow(ResultSet resultSet, int i) throws SQLException {

        JobsDTO jobs = new JobsDTO();
        jobs.setJob_id(resultSet.getString("job_id"));
        jobs.setJob_title(resultSet.getString("job_title"));
        jobs.setMin_salary(resultSet.getInt("min_salary"));
        jobs.setMax_salary(resultSet.getInt("max_salary"));
        return jobs;
    }

}
