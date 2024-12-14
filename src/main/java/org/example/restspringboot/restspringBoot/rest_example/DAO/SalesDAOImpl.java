package org.example.restspringboot.restspringBoot.rest_example.DAO;

import org.example.restspring.dao.DAO.DAO;
import org.example.restspring.dao.mappers.ArticleRowMapper;
import org.example.restspringboot.restspringBoot.rest_example.model.SALAS;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class SalesDAOImpl implements DAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final static String SQL_POST_ALL_SALAS = "INSERT*INTO (NAME,MANY) VALUES( :NAME,:MANY)";
    private final static String SQL_GET_ALL_SALAS = "SELECT*FROM SALAS10000";
    private final static String SQL_PUT_ALL_SALAS = "UPDATE SALAS10000 SET NAME = ?,MANY = ?";
    private final static String SQL_DELETE_ALL_SALAS = "DELETE*FROM SALAS10000 where NAME = ?,MANY = ?";


    @Autowired
    public void setDataSource(DataSource dataSource){
        namedParameterJdbcTemplate = new NamedParameterSpec(dataSource);
    }

    @Override
    public void create(SALAS salas) {
        ArticleRowMapper mapper = new ArticleRowMapper();
        try {
            return namedParameterJdbcTemplate.query(SQL_POST_ALL_SALAS,mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean read(SALAS salas) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", salas.getNAME());
        params.put("MANY", salas.getMANY());

        return namedParameterJdbcTemplate.read(SQL_GET_ALL_SALAS, params);
    }

    @Override
    public boolean update(SALAS salas) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", salas.getNAME());
        params.put("MANY", salas.getMANY());

        return namedParameterJdbcTemplate.update(SQL_PUT_ALL_SALAS, params);
    }

    @Override
    public boolean delete(SALAS salas) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", salas.getNAME());
        params.put("MANY", salas.getMANY());

        return namedParameterJdbcTemplate.delete(SQL_DELETE_ALL_SALAS, params);

    }
}
