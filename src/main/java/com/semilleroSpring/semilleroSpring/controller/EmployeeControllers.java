package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dto.DepartamentDTO;
import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.service.DepartamentService;
import com.semilleroSpring.semilleroSpring.service.EmployeeService;
import com.semilleroSpring.semilleroSpring.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getEmployeesPorCargo/{id}")//http://localhost:8080/employees/getEmployeesPorCargo/:id (AD_VP)
    public ResponseEntity<List<EmployeesDTO>> getEmployeesPorCargo(@PathVariable("id") String job_id){
        try {
            List<EmployeesDTO> listEmpxCargo = employeeService.getEmployeesPorCargo(job_id);
            return ResponseEntity.ok(listEmpxCargo);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getEmployeesPorNombre/{id}")//http://localhost:8080/employees/getEmployeesPorNombre/:id (King)
    public ResponseEntity<List<EmployeesDTO>> getEmployeesPorNombre(@PathVariable("id") String last_name){
        try {
            List<EmployeesDTO> listEmpxNombre = employeeService.getEmployeesPorNombre(last_name);
            return ResponseEntity.ok(listEmpxNombre);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getEmployeesPorDepartament/{id}")//http://localhost:8080/employees/getEmployeesPorDepartament/:id (90)
    public ResponseEntity<List<EmployeesDTO>> getEmployeesPorDepartament(@PathVariable("id") String department_id){
        try {
            List<EmployeesDTO> listEmpxDepartmen = employeeService.getEmployeesPorDepartament(department_id);
            return ResponseEntity.ok(listEmpxDepartmen);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getEmployeesPorManager/{id}")//http://localhost:8080/employees/getEmployeesPorManager/:id (100)
    public ResponseEntity<List<EmployeesDTO>> getEmployeesPorManager(@PathVariable("id") String manager_id){
        try {
            List<EmployeesDTO> listEmpxManager = employeeService.getEmployeesPorManager(manager_id);
            return ResponseEntity.ok(listEmpxManager);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getEmployeesPorCity/{id}")//http://localhost:8080/employees/getEmployeesPorCity/:id (Steven)
    public ResponseEntity<List<EmployeesDTO>> getEmployeesPorCity(@PathVariable("id") String first_name){
        try {
            List<EmployeesDTO> listEmpxPorCity = employeeService.getEmployeesPorCity(first_name);
            System.out.println("entro a dao xxxxxxxxxxxx"+listEmpxPorCity);
            return ResponseEntity.ok(listEmpxPorCity);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
