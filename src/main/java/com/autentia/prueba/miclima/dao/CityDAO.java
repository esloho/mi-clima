package com.autentia.prueba.miclima.dao;

import java.util.List;

import com.autentia.prueba.miclima.model.City;

/**
 * DAO for City objects.
 * 
 * @author esloho
 *
 */
public interface CityDAO {

    /**
     * Get list of available cities. If no cities exist, return an empty list.
     * 
     * @return
     */
    public List<City> getCities();

    /**
     * Get a city given its id.
     * 
     * @param id
     * @return
     */
    public City getCityById(Long id);
}
