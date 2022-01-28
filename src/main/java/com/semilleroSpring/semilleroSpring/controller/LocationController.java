package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dto.CountriesDTO;
import com.semilleroSpring.semilleroSpring.dto.LocationDTO;
import com.semilleroSpring.semilleroSpring.service.CountryService;
import com.semilleroSpring.semilleroSpring.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    public LocationService locationService;
    @Autowired
    public CountryService countryService;

    @GetMapping("/listCou")//http://localhost:8081/location/listCou
    public ResponseEntity<List<CountriesDTO>> listCou() {
        List<CountriesDTO> list = countryService.list();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/listLoc")//http://localhost:8081/location/listLoc
    public ResponseEntity<List<LocationDTO>> listLoc() {
        List<LocationDTO> list = locationService.listLo();
        return ResponseEntity.ok(list);
    }
    @PostMapping("/createOrUpdate")//http://localhost:8081/location/createOrUpdate
    public ResponseEntity<Object>createOrUpdate(@RequestBody LocationDTO locationDTO){
        locationService.createOrUpdate(locationDTO);
        return new ResponseEntity("Creado o actualizado con exito"+locationDTO, HttpStatus.OK);
    }
    @PostMapping("/deleteLoc")//http://localhost:8081/location/deleteLoc
    public ResponseEntity<Object>deleteLoc(@RequestBody LocationDTO locationDTO){
        locationService.delete(locationDTO.getLocation_id());
        return new ResponseEntity("Eliminado con exito"+locationDTO.getCountry_id(),HttpStatus.OK);
    }
}
