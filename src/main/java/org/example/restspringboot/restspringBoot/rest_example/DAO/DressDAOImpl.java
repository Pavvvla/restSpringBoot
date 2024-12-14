package org.example.restspringboot.restspringBoot.rest_example.DAO;

import org.example.restspring.dao.DAO.DAO;
import org.example.restspring.dao.mappers.ArticleRowMapper;
import javax.sql.DataSource;
import org.example.restspringboot.restspringBoot.rest_example.model.DRESS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class DressDAOImpl implements DAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final static String SQL_POST_ALL_DRESS = "INSERT*INTO (NAME,BRAND) VALUES(:NAME,:BRAND)";
    private final static String SQL_GET_ALL_DRESS = "SELECT*FROM DRESS";
    private final static String SQL_PUT_ALL_DRESS = "UPDATE DRESS SET NAME = ?, BRAND= ?";
    private final static String SQL_DELETE_ALL_DRESS = "DELETE*FROM DRESS where NAME = ?,BRAND = ?";


    @Autowired
    public void setDataSource(DataSource dataSource){
        namedParameterJdbcTemplate = new NamedParameterSpec(dataSource);
    }

    @Override
    public void create(DRESS dress) {
        ArticleRowMapper mapper = new ArticleRowMapper();
        try {
            return namedParameterJdbcTemplate.query(SQL_POST_ALL_DRESS,mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean read(DRESS dress) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", dress.getNAME());
        params.put("BRAND", dress.getBRAND());

        return namedParameterJdbcTemplate.read(SQL_GET_ALL_DRESS, params);
    }

    @Override
    public boolean update(DRESS dress) {
        Map<String,Object> params = new HashMap<>();
        params.put("NAME", dress.getNAME());
        params.put("BRAND", dress.getBRAND());

        return namedParameterJdbcTemplate.update(SQL_PUT_ALL_DRESS, params);
    }

    @Override
    public boolean delete(DRESS dress) {
        Map<String, Object> params = new HashMap<>();
        params.put("NAME", dress.getNAME());
        params.put("BRAND", dress.getBRAND());

        return namedParameterJdbcTemplate.delete(SQL_DELETE_ALL_DRESS, params);
    }
}
