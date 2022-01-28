package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.CountriesDTO;

import java.util.List;

public interface CountryDao {
    public int save(CountriesDTO id);
    public int update(CountriesDTO id);
    public int delete(String id);
    public int exist(String id);
    public List<CountriesDTO> list();

}
