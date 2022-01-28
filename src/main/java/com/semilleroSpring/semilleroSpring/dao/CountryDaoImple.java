package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.CountriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImple implements CountryDao{
    @Autowired
    public JdbcTemplate jdbcTemplate;

    private static String INSERT="INSERT INTO countries (country_id, country_name, region_id) VALUES (?,?,?)";
    private static String UPDATE="UPDATE countries SET country_name = ?, region_id = ? WHERE country_id = ?";
    private static String DELETE="DELETE FROM countries WHERE country_id = ?";
    private static String SELECT="SELECT country_id, country_name, region_id FROM countries";
    private static String SELECTEXIST="SELECT COUNT(1) AS NRO FROM countries WHERE country_id = ?";
    private static String SELECTID="SELECT country_name, region_id FROM countries WHERE country_id = ?";


    @Override
    public int save(CountriesDTO id) {
        return jdbcTemplate.update(INSERT,new Object[]{
                id.getCountry_id(),
                id.getCountry_name(),
                id.getRegion_id()
        });
    }

    @Override
    public int update(CountriesDTO id) {
        return jdbcTemplate.update(UPDATE,new Object[]{
                id.getCountry_name(),
                id.getRegion_id(),
                id.getCountry_id()
        });
    }

    @Override
    public int delete(String id) {
        return jdbcTemplate.update(DELETE,id);
    }

    @Override
    public int exist(String id) {
        int cantidad =0;
        try{
            cantidad = jdbcTemplate.queryForObject(SELECTEXIST,Integer.class,id);

        }catch (IncorrectResultSetColumnCountException e){
            return 0;
        }
        return cantidad;
    }

    @Override
    public List<CountriesDTO> list() {
        return jdbcTemplate.query(SELECT,BeanPropertyRowMapper.newInstance(CountriesDTO.class));
    }
}
