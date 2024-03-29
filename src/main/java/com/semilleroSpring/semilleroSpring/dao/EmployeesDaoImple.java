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
        try {
            System.out.println("entro a dao xxxxxxxxxxxx"+job_id);
            String sql = "SELECT * FROM employees WHERE job_id = ? and manager_id and department_id IS NOT NULL ORDER BY first_name";
            return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),job_id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorNombre(String last_name) {
        try {
        System.out.println("entro a dao xxxxxxxxxxxx"+last_name);
        String sql = "SELECT * FROM employees WHERE last_name = ? and manager_id and department_id IS NOT NULL ORDER BY first_name";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),last_name);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorDepartament(String department_id) {
        try {
            System.out.println("entro a dao xxxxxxxxxxxx"+department_id);
        String sql = "SELECT e.salary, e.first_name, e.last_name, d.department_name\n" +
                "FROM employees e \n" +
                "inner join departments d on e.department_id = d.department_id\n" +
                "where e.department_id = ? and e.manager_id and e.department_id IS NOT NULL\n" +
                "group by e.salary, e.first_name, e.last_name, d.department_name\n" +
                "order by e.salary desc";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),department_id);
    }catch (Exception ex){
        ex.printStackTrace();
    }
        return null;
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorManager(String manager_id) {
        try {
            System.out.println("entro a dao xxxxxxxxxxxx"+manager_id);
        String sql = "SELECT e.salary, e.first_name, e.last_name, d.department_name\n" +
                "FROM employees e \n" +
                "inner join departments d on e.department_id = d.department_id\n" +
                "where e.manager_id = ? and e.manager_id and e.department_id IS NOT NULL\n" +
                "group by e.salary, e.first_name, e.last_name, d.department_name\n" +
                "order by e.salary desc";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),manager_id);
    }catch (Exception ex){
        ex.printStackTrace();
    }
        return null;
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorCity(String first_name) {
        try {
            System.out.println("entro a dao xxxxxxxxxxxx"+first_name);
        String sql = "SELECT e.first_name, e.last_name, l.city, l.state_province, c.country_name, r.region_name\n" +
                "FROM employees e\n" +
                "INNER JOIN departments d ON e.department_id = d.department_id\n" +
                "INNER JOIN locations l ON d.location_id = l.location_id\n" +
                "INNER JOIN countries c ON l.country_id = c.country_id\n" +
                "INNER JOIN regions r ON c.region_id = r.region_id\n" +
                "WHERE e.first_name = ? and e.manager_id and e.department_id IS NOT NULL\n" +
                "GROUP BY e.first_name, e.last_name, l.city, l.state_province, c.country_name, r.region_name";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EmployeesDTO.class),first_name);
    }catch (Exception ex){
        ex.printStackTrace();
    }
        return null;
    }


}
