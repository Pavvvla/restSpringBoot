package org.example.restspringboot.restspringBoot.rest_example.mappers;

import org.example.restspring.entities.SALAS;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesRowMapper<SALAS> implements RowMapper<SALAS> {
    @Override
    public SALAS mapRow(ResultSet resultSet, int i) throws SQLException{
        final SALAS sale = new SALAS();

        sale.setNAME(resultSet.getString("NAME"));
        sale.setMANY(resultSet.getInt("MANY"));

        return sale;
    }
}
