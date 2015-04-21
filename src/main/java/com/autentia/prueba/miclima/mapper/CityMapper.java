package com.autentia.prueba.miclima.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.autentia.prueba.miclima.model.City;

/**
 * Mapper of objects from the City table in the data source to the model class
 * City.
 * 
 * @author esloho
 *
 */
public interface CityMapper {

    /**
     * Select all the cities form the city table in the data source.
     * 
     * @return
     */
    @Select("SELECT * FROM city")
    public List<City> getAllCities();

    /**
     * Select the city corresponding to the given id from the city table in the
     * data source.
     * 
     * @param cityId
     * @return
     */
    @Select("SELECT * FROM city WHERE id = #{cityId}")
    public City getCityById(long cityId);
}
