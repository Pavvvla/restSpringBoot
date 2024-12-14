package org.example.restspringboot.restspringBoot.rest_example.mappers;

import org.example.restspring.entities.PRODUCTS;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsRowMapper<PRODUCTS> implements RowMapper<PRODUCTS> {
    @Override
    public PRODUCTS mapRow(ResultSet resultSet, int i) throws SQLException{
        final PRODUCTS products = new PRODUCTS();

        products.setARTICLE(resultSet.getInt("ARTICLE"));
        products.setPRODUCTS(resultSet.getString("PRODUCTS"));

        return products;
    }
}
