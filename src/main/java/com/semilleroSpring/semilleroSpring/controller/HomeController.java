package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dao.EmployeesDao;
import com.semilleroSpring.semilleroSpring.dao.JobsDao;
import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        JobsDTO jobsDTO = new JobsDTO();
        List<JobsDTO> listJobs = jobsDao.listarJobs();
        model.addAttribute("cargos",listJobs);
        model.addAttribute("jobsDTO",jobsDTO);
        return "home";
    }
    @RequestMapping("/listEmployee/{id}")
    public String listEmployee(@PathVariable("id") String id, Model model){
        List<EmployeesDTO> listEmployees = employeesDao.getEmployeesPorCargo(id);
        model.addAttribute("employees",listEmployees);
        return "home";
    }
}
