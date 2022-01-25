package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/job")
public class JobController {
    //Importamos la interfaz de los servicios
    @Autowired
    private JobService jobService;

    //para listar utilizamos el metodo get
    @GetMapping("/listJobs")//http://localhost:8081/job/listJobs
    public ResponseEntity<List<JobsDTO>> listarJobs(){
        List<JobsDTO> listJob = jobService.listarJobs();
        return ResponseEntity.ok(listJob);
    }

    //para consultar por id utilizamos el metodo get
    @GetMapping("/findById/{id}")//http://localhost:8081/job/findById/:id
    public JobsDTO findById(@PathVariable String id){
        return jobService.findById(id);
    }

    //para crear utilizamos el metodo post
    @PostMapping("/createJobs")//http://localhost:8081/job/createJobs
    public ResponseEntity<String> createJobs(@RequestBody JobsDTO jobsDTO){
        try{
            jobService.saveJob(jobsDTO);
            return new ResponseEntity<>("El cargo fue creado con exito", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //para actualizar utilizamos em metodo put
    @PutMapping("/updateJobs")//http://localhost:8081/job/updateJobs
    public ResponseEntity<String> updateJobs(@RequestBody JobsDTO jobsDTO){
        JobsDTO jobs = jobService.findById(jobsDTO.getJob_id());
       if (jobs != null){
           jobs.setJob_id(jobsDTO.getJob_id());
           jobs.setJob_title(jobsDTO.getJob_title());
           jobs.setMin_salary(jobsDTO.getMin_salary());
           jobs.setMax_salary(jobsDTO.getMax_salary());
           jobService.updateJob(jobs);
           return new ResponseEntity<>("El cargo se actualizó con éxito",HttpStatus.OK);
       }else {
           return new ResponseEntity<>("No se puede encontrar el cargo con id"+jobsDTO.getJob_id(),HttpStatus.NOT_FOUND);
       }
    }
    @PostMapping("/createOrUpdate")//http://localhost:8081/job/createOrUpdate
    public ResponseEntity<Object> createOrUpdate(@RequestBody JobsDTO jobsDTO){
        jobService.createOrUpdate(jobsDTO);
        return  new ResponseEntity(jobsDTO,HttpStatus.OK);
    }

    //para eliminar utilizaremos el metodo delete
    @PostMapping("/deleteById")//http://localhost:8081/job/deleteById/:id
    public ResponseEntity<String> deleteById(@RequestBody JobsDTO jobsDTO){
        try{
            int dato = jobService.deleteByIdJob(jobsDTO.getJob_id());
            if (dato == 0){
                return new ResponseEntity<>("No se puede encontrar el cargo con id="+jobsDTO.getJob_id(),HttpStatus.OK);
            }
            return new ResponseEntity<>("El cargo se eliminó con éxito",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se puede eliminar el cargo",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
