package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.DepartamentDTO;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartamentDaoImple implements DepartamentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<DepartamentDTO> listDepartament() {
        String sql = "SELECT * FROM departments";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DepartamentDTO.class));
    }
}
