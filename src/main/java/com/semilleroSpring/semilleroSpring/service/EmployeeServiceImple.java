package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dao.EmployeesDao;
import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class EmployeeServiceImple implements EmployeeService {

    @Autowired
    private EmployeesDao employeesDao;

    @Override
    public List<EmployeesDTO> getEmployees() {
        return employeesDao.getEmployees();
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorCargo(String job_id) {

        return employeesDao.getEmployeesPorCargo(job_id);
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorNombre(String last_name) {
        return employeesDao.getEmployeesPorNombre(last_name);
    }


    @Override
    public List<EmployeesDTO> getEmployeesPorDepartament(String department_id) {
        return employeesDao.getEmployeesPorDepartament(department_id);
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorManager(String manager_id) {
        return employeesDao.getEmployeesPorManager(manager_id);
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorCity(String first_name) {
        return employeesDao.getEmployeesPorCity(first_name);
    }


}
