package org.example.restspringboot.restspringBoot.rest_example.mappers;

import org.example.restspring.entities.ARTICLE;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper<ARTICLE> implements RowMapper<ARTICLE> {

    @Override
    public ARTICLE mapRow(ResultSet resultSet, int i) throws SQLException{
        final ARTICLE article = new ARTICLE();

        article.setARTICLE(resultSet.getInt("ARTICLE"));
        article.setNAME(resultSet.getString("NAME"));

        return article;
    }

}
