package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.CountriesDTO;
import com.semilleroSpring.semilleroSpring.dto.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class LocationDaoImple implements LocationDao{
    @Autowired
    public JdbcTemplate jdbcTemplate;

    private static String INSERT="INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id) VALUES(?, ?, ?, ?, ?, ?)";
    private static String UPDATE="UPDATE locations SET street_address=?, postal_code=?, city=?, state_province=?, country_id=? WHERE location_id=?";
    private static String DELETE="DELETE FROM locations WHERE location_id=?";
    private static String SELECT="SELECT l.location_id, l.street_address, l.postal_code, l.city, l.state_province, l.country_id, c.country_name FROM locations l\n" +
            "INNER JOIN countries c ON l.country_id = c.country_id";
    private static String SELECTEXIST="SELECT COUNT(1) AS NRO FROM locations WHERE location_id = ?";
    private static String SELECTID="SELECT location_id, street_address, postal_code, city, state_province, country_id FROM locations WHERE location_id = ?";

    @Override
    public List<LocationDTO> listLo() {
        //return jdbcTemplate.query(SELECT, BeanPropertyRowMapper.newInstance(LocationDTO.class));
        List<LocationDTO> listLoca = new ArrayList<>();
        List<Map<String,Object>> fila = jdbcTemplate.queryForList(SELECT);
        fila.forEach(rs ->{
            LocationDTO locationDTO = new LocationDTO();
            CountriesDTO countriesDTO = new CountriesDTO();
            locationDTO.setLocation_id((int) rs.get("location_id"));
            locationDTO.setStreet_address((String) rs.get("street_address"));
            locationDTO.setPostal_code((String) rs.get("postal_code"));
            locationDTO.setCity((String) rs.get("city"));
            locationDTO.setState_province((String) rs.get("state_province"));
            locationDTO.setCountry_id((String) rs.get("country_id"));
            countriesDTO.setCountry_id((String) rs.get("country_id"));
            countriesDTO.setCountry_name((String) rs.get("country_name"));

            listLoca.add(locationDTO);
        });
        return listLoca;
    }

    @Override
    public LocationDTO listId(int id) {
        return jdbcTemplate.queryForObject(SELECTID, new BeanPropertyRowMapper<>(LocationDTO.class),id);
    }

    @Override
    public int exist(int id) {
        int cantidad =0;
        try{
            cantidad = jdbcTemplate.queryForObject(SELECTEXIST,Integer.class,id);

        }catch (IncorrectResultSetColumnCountException e){
            return 0;
        }
        return cantidad;
    }

    @Override
    public int save(LocationDTO id) {
        return jdbcTemplate.update(INSERT, new Object[]{
                id.getLocation_id(),
                id.getStreet_address(),
                id.getPostal_code(),
                id.getCity(),
                id.getState_province(),
                id.getCountry_id()
        });
    }

    @Override
    public int update(LocationDTO id) {
        return jdbcTemplate.update(UPDATE, new Object[]{
                id.getStreet_address(),
                id.getPostal_code(),
                id.getCity(),
                id.getState_province(),
                id.getCountry_id(),
                id.getLocation_id()
        });
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
