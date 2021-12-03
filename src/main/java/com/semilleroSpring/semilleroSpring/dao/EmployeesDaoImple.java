package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeesDaoImple implements EmployeesDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<EmployeesDTO> getEmployees() {
        String sql = "SELECT * FROM employees WHERE manager_id and department_id IS NOT NULL ORDER BY first_name";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class));
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorCargo(String job_id) {
        String sql = "SELECT * FROM employees WHERE job_id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),job_id);
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorDepartament(int department_id) {
        String sql = "SELECT e.salary, e.first_name, e.last_name, d.department_name\n" +
                "FROM employees e \n" +
                "inner join departments d on e.department_id = d.department_id\n" +
                "where e.department_id = ?\n" +
                "group by e.salary, e.first_name, e.last_name, d.department_name\n" +
                "order by e.salary desc";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),department_id);
    }
}
