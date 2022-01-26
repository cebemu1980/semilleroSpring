package com.semilleroSpring.semilleroSpring.maper;

import com.semilleroSpring.semilleroSpring.dto.RegionDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaperRegion implements RowMapper<RegionDTO> {
    @Override
    public RegionDTO mapRow(ResultSet rs, int i) throws SQLException {
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setRegion_id(rs.getInt("region_id"));
        regionDTO.setRegion_name(rs.getString("region_name"));
        return regionDTO;
    }
}
