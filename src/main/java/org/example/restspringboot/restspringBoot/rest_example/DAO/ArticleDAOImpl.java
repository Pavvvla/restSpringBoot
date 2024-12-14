package org.example.restspringboot.restspringBoot.rest_example.DAO;

import org.example.restspring.dao.DAO.DAO;
import org.example.restspring.dao.mappers.ArticleRowMapper;
import org.example.restspringboot.restspringBoot.rest_example.model.ARTICLE;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleDAOImpl implements DAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final static String SQL_POST_ALL_ARTICLE = "INSERT*INTO (ARTICLE,NAME) VALUES( :ARTICLE,:NAME)";
    private final static String SQL_GET_ALL_ARTICLE = "SELECT*FROM ARTICLE";
    private final static String SQL_PUT_ALL_ARTICLE = "UPDATE ARTICLE SET ARTICLE = ?,NAME = ?";
    private final static String SQL_DELETE_ALL_ARTICLE = "DELETE*FROM ARTICLE where ARTICLE = ?,NAME = ?";



    @Autowired
    public void setDataSource(DataSource dataSource){
        namedParameterJdbcTemplate = new NamedParameterSpec(dataSource);
    }

    @Override
    public void create(ARTICLE article) {
        ArticleRowMapper mapper = new ArticleRowMapper();
        try {
            return namedParameterJdbcTemplate.query(SQL_POST_ALL_ARTICLE,mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean read(ARTICLE article) {
        Map<String,Object> params = new HashMap<>();
        params.put("ARTICLE", article.getARTICLE());
        params.put("NAME", article.getNAME());

        return namedParameterJdbcTemplate.read(SQL_GET_ALL_ARTICLE, params);
    }

    @Override
    public boolean update(ARTICLE article) {
        Map<String,Object> params = new HashMap<>();
        params.put("ARTICLE", article.getARTICLE());
        params.put("NAME", article.getNAME());

        return namedParameterJdbcTemplate.update(SQL_PUT_ALL_ARTICLE, params);
    }

    @Override
    public boolean delete(ARTICLE article) {
        Map<String,Object> params = new HashMap<>();
        params.put("ARTICLE", article.getARTICLE());
        params.put("NAME", article.getNAME());

        return namedParameterJdbcTemplate.delete(SQL_DELETE_ALL_ARTICLE, params);
    }
}