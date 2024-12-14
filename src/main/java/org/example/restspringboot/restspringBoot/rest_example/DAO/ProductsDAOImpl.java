package org.example.restspringboot.restspringBoot.rest_example.DAO;

import org.example.restspring.dao.DAO.DAO;
import org.example.restspring.dao.mappers.ArticleRowMapper;
import org.example.restspringboot.restspringBoot.rest_example.model.PRODUCTS;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductsDAOImpl implements DAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final static String SQL_POST_ALL_PRODUCTS = "INSERT*INTO (ARTICLE,PRODUCTS) VALUES( :ARTICLE,:PRODUCTS)";
    private final static String SQL_GET_ALL_PRODUCTS = "SELECT*FROM PRODUCTS";
    private final static String SQL_PUT_ALL_PRODUCTS = "UPDATE PRODUCTS SET ARTICLE = ?,PRODUCTS = ?";
    private final static String SQL_DELETE_ALL_PRODUCTS = "DELETE*FROM PRODUCTS where ARTICLE = ?,PRODUCTS = ?";


    @Autowired
    public void setDataSource(DataSource dataSource){
        namedParameterJdbcTemplate = new NamedParameterSpec(dataSource);
    }

    @Override
    public void create(PRODUCTS products) {
        ArticleRowMapper mapper = new ArticleRowMapper();
        try {
            return namedParameterJdbcTemplate.query(SQL_POST_ALL_PRODUCTS,mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean read(PRODUCTS products) {
        Map<String,Object> params = new HashMap<>();
        params.put("ARTICLE", products.getARTICLE());
        params.put("PRODUCTS", products.getPRODUCTS());

        return namedParameterJdbcTemplate.read(SQL_GET_ALL_PRODUCTS, params);
    }

    @Override
    public boolean update(PRODUCTS products) {
        Map<String,Object> params = new HashMap<>();
        params.put("ARTICLE", products.getARTICLE());
        params.put("PRODUCTS", products.getPRODUCTS());

        return namedParameterJdbcTemplate.update(SQL_PUT_ALL_PRODUCTS, params);
    }

    @Override
    public boolean delete(PRODUCTS products) {
        Map<String,Object> params = new HashMap<>();
        params.put("ARTICLE", products.getARTICLE());
        params.put("PRODUCTS", products.getPRODUCTS());

        return namedParameterJdbcTemplate.delete(SQL_DELETE_ALL_PRODUCTS, params);

    }
}
