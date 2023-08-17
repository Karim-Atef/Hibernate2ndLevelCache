package com.devtalkers.hibernate2levelcache.service;

import com.devtalkers.hibernate2levelcache.entity.City;
import com.devtalkers.hibernate2levelcache.repository.CityRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(cacheNames = "city", key = "#id")
    public City getCityById(Integer id) {
        return cityRepository.findById(id).get();
    }

    // remove this line to see the difference
    @CachePut(cacheNames = "city", key = "#city.id")
    public City saveCity(City city) {

        return cityRepository.save(city);
    }

    // remove this line to see the difference
    @CacheEvict(cacheNames = "city", key = "#id")
    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
        Cache citiesCache = cacheManager.getCache("cities");
        if (citiesCache != null) {
            citiesCache.clear();
        }
    }

    @Cacheable(cacheNames = "cities")
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }
}
