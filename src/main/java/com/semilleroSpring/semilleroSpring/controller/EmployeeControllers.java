package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dto.DepartamentDTO;
import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.service.DepartamentService;
import com.semilleroSpring.semilleroSpring.service.EmployeeService;
import com.semilleroSpring.semilleroSpring.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeControllers {
    //Importamos la interfaz de los servicios
    @Autowired
    private JobService jobService;
    @Autowired
    private DepartamentService departamentService;
    @Autowired
    private EmployeeService employeeService;

    //Aquí se generaran las consultas del los select o maetros nesesarios para la clase de employees

    @GetMapping("/listJobs")//http://localhost:8080/employees/listJobs
    public ResponseEntity<List<JobsDTO>> listarJobs(){
        List<JobsDTO> listJob = jobService.listarJobs();
        return ResponseEntity.ok(listJob);
    }
    @GetMapping("/listDepartament")//http://localhost:8080/employees/listDepartament
    public ResponseEntity<List<DepartamentDTO>> listDepartaments(){
        List<DepartamentDTO> listDeparta = departamentService.listDepartament();
        return ResponseEntity.ok(listDeparta);
    }
    @GetMapping("/listEmployee")//http://localhost:8080/employees/listEmployee
    public ResponseEntity<List<EmployeesDTO>> getEmployees(){
        List<EmployeesDTO> listEmploye = employeeService.getEmployees();
        return ResponseEntity.ok(listEmploye);
    }
    //Aquí se generaran las consultas del las tablas


}
