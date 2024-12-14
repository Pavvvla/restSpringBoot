package org.example.restspringboot.restspringBoot.rest_example.DAO;

import org.example.restspring.dao.DAO.DAO;
import org.example.restspring.dao.mappers.ArticleRowMapper;
import org.example.restspringboot.restspringBoot.rest_example.model.SALAS10000;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class Salas10000DAOImpl implements DAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final static String SQL_POST_ALL_SALAS10000 = "INSERT*INTO (NAME,MANY) VALUES( :NAME,:MANY)";
    private final static String SQL_GET_ALL_SALAS10000 = "SELECT*FROM SALAS10000";
    private final static String SQL_PUT_ALL_SALAS10000 = "UPDATE SALAS10000 SET NAME = ?,MANY = ?";
    private final static String SQL_DELETE_ALL_SALAS10000 = "DELETE*FROM SALAS10000 where NAME = ?,MANY = ?";


    @Autowired
    public void setDataSource(DataSource dataSource){
        namedParameterJdbcTemplate = new NamedParameterSpec(dataSource);
    }

    @Override
    public void create(SALAS10000 salas10000) {
        ArticleRowMapper mapper = new ArticleRowMapper();
        try {
            return namedParameterJdbcTemplate.query(SQL_POST_ALL_SALAS10000,mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean read(SALAS10000 salas10000) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", salas10000.getNAME());
        params.put("MANY", salas10000.getMANY());

        return namedParameterJdbcTemplate.read(SQL_GET_ALL_SALAS10000, params);
    }

    @Override
    public boolean update(SALAS10000 salas10000) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", salas10000.getNAME());
        params.put("MANY", salas10000.getMANY());

        return namedParameterJdbcTemplate.update(SQL_PUT_ALL_SALAS10000, params);
    }

    @Override
    public boolean delete(SALAS10000 salas10000) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", salas10000.getNAME());
        params.put("MANY", salas10000.getMANY());

        return namedParameterJdbcTemplate.delete(SQL_DELETE_ALL_SALAS10000, params);
    }
}
