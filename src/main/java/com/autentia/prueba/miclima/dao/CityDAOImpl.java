package com.autentia.prueba.miclima.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autentia.prueba.miclima.mapper.CityMapper;
import com.autentia.prueba.miclima.model.City;

/**
 * Implementation of DAO for City objects.
 * 
 * @author esloho
 *
 */
@Component
public class CityDAOImpl implements CityDAO {

    @Autowired
    private CityMapper cityMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.autentia.prueba.miclima.dao.CityDAO#getCities()
     */
    @Override
    public List<City> getCities() {
        List<City> cities = this.cityMapper.getAllCities();

        if (cities == null) {
            cities = new ArrayList<City>();
        }

        return cities;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.autentia.prueba.miclima.dao.CityDAO#getCityById(java.lang.Long)
     */
    @Override
    public City getCityById(Long id) {
        return this.cityMapper.getCityById(id);
    }
}
