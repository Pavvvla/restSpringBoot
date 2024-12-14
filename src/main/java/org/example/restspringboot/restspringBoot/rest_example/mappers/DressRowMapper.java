package org.example.restspringboot.restspringBoot.rest_example.mappers;

import org.example.restspring.entities.DRESS;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DressRowMapper<DRESS> implements RowMapper<DRESS> {
    @Override
    public DRESS mapRow(ResultSet resultSet, int i) throws SQLException{
        final DRESS dress = new DRESS();

        dress.setNAME(resultSet.getString("NAME"));
        dress.setBRAND(resultSet.getString("BRAND"));

        return dress;
    }
}
