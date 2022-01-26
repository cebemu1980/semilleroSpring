package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.dto.RegionDTO;
import com.semilleroSpring.semilleroSpring.maper.MaperJobs;
import com.semilleroSpring.semilleroSpring.maper.MaperRegion;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionDaoImple implements RegionDao{
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<RegionDTO> listRegion() {
        String sql = "SELECT region_id, region_name FROM regions";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(RegionDTO.class));
    }

    @Override
    public int findById(int id) {
        String sql = "SELECT COUNT(1) AS NRO FROM regions WHERE region_id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,id);
    }
    @Override
    public int exist(int id) {
        int cantidad =0;
        try{
            String sql = "SELECT COUNT(1) AS NRO FROM regions WHERE region_id = ?";
            cantidad = jdbcTemplate.queryForObject(sql,Integer.class,id);

        }catch (IncorrectResultSetColumnCountException e){
            return 0;
        }
        return cantidad;
    }

    @Override
    public int saveRegion(RegionDTO regionDTO) {
        System.out.println("entro al dao a guardar"+regionDTO);
        String sql = "INSERT INTO regions(region_id,region_name) VALUES(?,?)";
        return jdbcTemplate.update(sql, new Object[]{
                regionDTO.getRegion_id(),
                regionDTO.getRegion_name()
        });
    }

    @Override
    public int updateRegion(RegionDTO regionDTO) {
        System.out.println("entro al dao actualizar"+regionDTO);
        String sql = "UPDATE regions SET region_name = ? WHERE region_id = ?";
        return jdbcTemplate.update(sql, new Object[]{
                regionDTO.getRegion_name(),
                regionDTO.getRegion_id()
        });
    }

    @Override
    public int deleteRegion(int id) {
        String sql = "DELETE FROM regions WHERE region_id = ?";
        return jdbcTemplate.update(sql,id);
    }
}
