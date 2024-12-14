package org.example.restspringboot.restspringBoot.rest_example.DAO;

import java.util.List;

public interface DAO <T, String>{

     void create(T t);

     List<T> readAll();

     boolean read(T t);

     boolean update(T t);

     boolean delete(T t);

}
