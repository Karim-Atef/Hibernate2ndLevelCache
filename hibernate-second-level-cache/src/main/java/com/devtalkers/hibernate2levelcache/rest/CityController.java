package com.devtalkers.hibernate2levelcache.rest;

import com.devtalkers.hibernate2levelcache.entity.City;
import com.devtalkers.hibernate2levelcache.service.CityService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable(name = "id") Integer id) {
        return cityService.getCityById(id);
    }

    @PutMapping("/cities")
    public City saveCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable(name = "id") Integer id) {
        cityService.deleteCity(id);
    }

    @GetMapping("cities")
    public List<City> findAllCities() {
        return cityService.findAllCities();
    }

}
