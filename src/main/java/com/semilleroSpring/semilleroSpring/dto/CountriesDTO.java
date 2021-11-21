package com.semilleroSpring.semilleroSpring.dto;

import java.io.Serializable;

public class CountriesDTO implements Serializable {
    private String country_id;
    private String country_name;
    private RegionDTO region_ID;

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public RegionDTO getRegion_ID() {
        return region_ID;
    }

    public void setRegion_ID(RegionDTO region_ID) {
        this.region_ID = region_ID;
    }

    @Override
    public String toString() {
        return "CountriesDTO{" +
                "country_id='" + country_id + '\'' +
                ", country_name='" + country_name + '\'' +
                ", region_ID=" + region_ID +
                '}';
    }
}
