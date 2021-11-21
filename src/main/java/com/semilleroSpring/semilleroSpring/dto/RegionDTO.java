package com.semilleroSpring.semilleroSpring.dto;

import java.io.Serializable;

public class RegionDTO implements Serializable {
    private int region_id;
    private String region_name;

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    @Override
    public String toString() {
        return "RegionDTO{" +
                "region_id=" + region_id +
                ", region_name='" + region_name + '\'' +
                '}';
    }
}
