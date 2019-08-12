package com.codegym.repository;

import com.codegym.model.City;
import com.codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Page<City> findByCountry(Country country, Pageable pageable);

}
