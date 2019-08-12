package com.codegym.service;

import com.codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {
    Page<Country> findAll(Pageable pageable);
    void save(Country country);
    void remove(Long id);
    Country findByName(String name);
    Country findById(Long id);
}
