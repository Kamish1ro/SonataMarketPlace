package com.sonata.model;

import java.util.List;
/**
 * @author Kam1shiro
 * */
public interface ClothesService {
    /**
     * CRUD операции
     * */
    void create(Clothes clothes);
    List<Clothes> readAll();
    Clothes read(int id);
    boolean update(Clothes clothes, int id);
    boolean delete(int id);
}
