package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDaoImple implements LocationDao{
    @Autowired
    public JdbcTemplate jdbcTemplate;

    private static String INSERT="INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id) VALUES(?, ?, ?, ?, ?, ?)";
    private static String UPDATE="UPDATE locations SET street_address=?, postal_code=?, city=?, state_province=?, country_id=? WHERE location_id=?";
    private static String DELETE="DELETE FROM locations WHERE location_id=?";
    private static String SELECT="SELECT location_id, street_address, postal_code, city, state_province, country_id FROM locations";
    private static String SELECTEXIST="SELECT COUNT(1) AS NRO FROM locations WHERE location_id = ?";
    private static String SELECTID="SELECT location_id, street_address, postal_code, city, state_province, country_id FROM locations WHERE location_id = ?";

    @Override
    public List<LocationDTO> listLo() {
        return jdbcTemplate.query(SELECT, BeanPropertyRowMapper.newInstance(LocationDTO.class));
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
