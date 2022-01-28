package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dto.CountriesDTO;
import com.semilleroSpring.semilleroSpring.dto.RegionDTO;
import com.semilleroSpring.semilleroSpring.service.CountryService;
import com.semilleroSpring.semilleroSpring.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    public CountryService countryService;
    @Autowired
    public RegionService regionService;

    @GetMapping("/listCo")//http://localhost:8081/country/listCo
    public ResponseEntity<List<CountriesDTO>> listCo(){
        List<CountriesDTO> list = countryService.list();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/listRegion")//http://localhost:8081/country/listRegion
    public ResponseEntity<List<RegionDTO>> listRegion(){
        List<RegionDTO> listRe = regionService.listRegion();
        return ResponseEntity.ok(listRe);
    }
    @PostMapping("/createOrUpdate")//http://localhost:8081/country/createOrUpdate
    public ResponseEntity<Object>createOrUpdate(@RequestBody CountriesDTO countriesDTO){
        countryService.createOrUpdate(countriesDTO);
        return new ResponseEntity("Creado o actualizado con exito"+countriesDTO,HttpStatus.OK);
    }
    @PostMapping("/deleteCo")//http://localhost:8081/country/deleteCo
    public ResponseEntity<Object>deleteCo(@RequestBody CountriesDTO countriesDTO){
        countryService.delete(countriesDTO.getCountry_id());
        return new ResponseEntity("Eliminado con exito"+countriesDTO,HttpStatus.OK);
    }
}
