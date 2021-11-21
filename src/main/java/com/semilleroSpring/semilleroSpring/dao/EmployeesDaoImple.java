package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class EmployeesDaoImple implements EmployeesDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmployeesDaoImple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeesDTO> getAllEmployees() {
        String sql = "SELECT job_id FROM employees";
        return jdbcTemplate.query(sql, (rs, rowNum)->{
            EmployeesDTO employeesDTO = new EmployeesDTO();
            employeesDTO.setEmployee_id(rs.getInt("employee_id"));
            return employeesDTO;
        });
    }
}
