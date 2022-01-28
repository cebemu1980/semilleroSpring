package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dto.CountriesDTO;

import java.util.List;

public interface CountryService {
    public int save(CountriesDTO id);
    public int update(CountriesDTO id);
    public int delete(String id);
    public int createOrUpdate(CountriesDTO id);
    public List<CountriesDTO> list();
}
