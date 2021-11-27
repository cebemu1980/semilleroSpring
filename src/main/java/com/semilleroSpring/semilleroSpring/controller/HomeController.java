package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dao.EmployeesDao;
import com.semilleroSpring.semilleroSpring.dao.JobsDao;
import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@Controller
//@RestController
@RequestMapping("/api")//http://localhost:8080/api
public class HomeController {
    @Autowired
    private JobsDao jobsDao;
    @Autowired
    private EmployeesDao employeesDao;

    @RequestMapping("/listJobs")
    public String listJobs(Model model){
        List<JobsDTO> listJobs = jobsDao.listarJobs();
        model.addAttribute("cargos",listJobs);
        return "home";
    }

    @GetMapping("/listarEmpleados/{id}")
    public String listarEmpleados(@PathVariable(value = "id")String id, Model model){
        List<EmployeesDTO> employeesDTOS = employeesDao.getEmployeesPorCargo(id);
        model.addAttribute("listaEmplePorCargo",employeesDTOS);
        return "home";
    }

    /*
    @RequestMapping("/listEmployee/{id}")
    public String listEmployee(@PathVariable("id") String id, Model model){
        List<EmployeesDTO> listEmployees = employeesDao.getEmployeesPorCargo(id);
        model.addAttribute("empls",listEmployees);
        System.out.println(model.addAttribute("empls",listEmployees));

        return "home";
    }

     */
}
