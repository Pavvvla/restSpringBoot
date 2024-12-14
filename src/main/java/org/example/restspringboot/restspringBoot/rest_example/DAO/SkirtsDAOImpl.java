package org.example.restspringboot.restspringBoot.rest_example.DAO;

import org.example.restspring.dao.DAO.DAO;
import org.example.restspring.dao.mappers.ArticleRowMapper;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class SkirtsDAOImpl implements DAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final static String SQL_POST_ALL_SKIRTS = "INSERT*INTO (NAME,BRAND) VALUES(:NAME,:BRAND)";
    private final static String SQL_GET_ALL_SKIRTS = "SELECT*FROM SKIRTS";
    private final static String SQL_PUT_ALL_SKIRTS = "UPDATE SKIRTS SET NAME = ?, BRAND= ?";
    private final static String SQL_DELETE_ALL_SKIRTS = "DELETE*FROM SKIRTS where NAME = ?,BRAND = ?";


    @Autowired
    public void setDataSource(DataSource dataSource){
        namedParameterJdbcTemplate = new NamedParameterSpec(dataSource);
    }

    @Override
    public void create(SKIRTS skirts) {
        ArticleRowMapper mapper = new ArticleRowMapper();
        try {
            return namedParameterJdbcTemplate.query(SQL_POST_ALL_SKIRTS,mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean read(SKIRTS skirts) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", skirts.getNAME());
        params.put("BRAND", skirts.getBRAND());

        return namedParameterJdbcTemplate.read(SQL_GET_ALL_SKIRTS, params);
    }

    @Override
    public boolean update(SKIRTS skirts) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", skirts.getNAME());
        params.put("BRAND", skirts.getBRAND());

        return namedParameterJdbcTemplate.update(SQL_PUT_ALL_SKIRTS, params);
    }

    @Override
    public boolean delete(SKIRTS skirts) {
        Map<String, Object> params = new HashMap<>();
        params.put("NAME", skirts.getNAME());
        params.put("BRAND", skirts.getBRAND());

        return namedParameterJdbcTemplate.delete(SQL_DELETE_ALL_SKIRTS, params);

    }
}
