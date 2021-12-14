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
    public List<EmployeesDTO> getEmployeesPorCargo(String job_id){
        try {
            return employeesDao.getEmployeesPorCargo(job_id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorNombre(String last_name) {
        try {
            return employeesDao.getEmployeesPorNombre(last_name);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    public List<EmployeesDTO> getEmployeesPorDepartament(String department_id) {
        try {
            return employeesDao.getEmployeesPorDepartament(department_id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorManager(String manager_id) {
        try {
            return employeesDao.getEmployeesPorManager(manager_id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeesDTO> getEmployeesPorCity(String first_name) {
        try {
            return employeesDao.getEmployeesPorCity(first_name);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("entro a getEmployeesPorCity xxxxxxxxxxxx"+employeesDao.getEmployeesPorCity(first_name));
        return null;
    }


}
