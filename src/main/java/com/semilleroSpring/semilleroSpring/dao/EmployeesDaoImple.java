package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeesDaoImple implements EmployeesDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<EmployeesDTO> getEmployeesPorCargo(String job_id) {

        String sql = "SELECT * FROM employees WHERE job_id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),job_id);
        //return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),job_id);
    }
}
