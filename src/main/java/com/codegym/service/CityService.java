package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityService {
    Page<City> findAll(Pageable pageable);
    void save(City city);
    void remove(Long id);
    Page<City> findByCountry(Country country, Pageable pageable);
    City findById(Long id);

}
