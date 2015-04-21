package com.autentia.prueba.miclima.dao;

import java.util.List;

import com.autentia.prueba.miclima.model.DayType;

/**
 * DAO for DayType objects.
 * 
 * @author esloho
 *
 */
public interface DayTypeDAO {

    /**
     * Get a list of all possible types of day from the data source. If no types
     * exist, return an empty list.
     * 
     * @return
     */
    public List<DayType> getDayTypes();

    /**
     * Get a day type given its id.
     * 
     * @param id
     * @return
     */
    public DayType getDayTypeById(Long id);
}
