package com.codegym.service.impl;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.repository.CityRepository;
import com.codegym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.delete(id);
    }

    @Override
    public Page<City> findByCountry(Country country, Pageable pageable) {
        return cityRepository.findByCountry(country,pageable);
    }

    @Override
    public City findById(Long id) {
        return (City) cityRepository.findOne(id);
    }
}
