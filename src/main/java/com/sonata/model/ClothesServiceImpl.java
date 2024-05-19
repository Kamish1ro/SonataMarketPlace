package com.sonata.model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService{

    private final ClothesRepository clothesRepository;

    public ClothesServiceImpl(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    /**
     * CRUD операции
     * */
    @Override
    public void create(Clothes clothes) {
        clothesRepository.save(clothes);
    }

    @Override
    public List<Clothes>  readAll() {
        return clothesRepository.findAll();
    }

    @Override
    public Clothes read(int id) {
        return clothesRepository.getOne(id);
    }

    @Override
    public boolean update(Clothes clothes, int id) {
        if (clothesRepository.existsById(id)) {
            clothes.setId(id);
            clothesRepository.save(clothes);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (clothesRepository.existsById(id)) {
            clothesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
