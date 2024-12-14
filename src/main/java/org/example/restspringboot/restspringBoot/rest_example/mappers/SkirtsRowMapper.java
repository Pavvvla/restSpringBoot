package org.example.restspringboot.restspringBoot.rest_example.mappers;

import org.example.restspring.entities.SKIRTS;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkirtsRowMapper<SKIRTS> implements RowMapper<SKIRTS> {
    @Override
    public SKIRTS mapRow(ResultSet resultSet, int i) throws SQLException{
        final SKIRTS skirts = new SKIRTS();

        skirts.setNAME(resultSet.getString("NAME"));
        skirts.setBRAND(resultSet.getString("BRAND"));

        return skirts;
    }
}
