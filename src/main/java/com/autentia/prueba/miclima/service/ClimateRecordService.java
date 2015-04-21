package com.autentia.prueba.miclima.service;

import java.util.List;

import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.model.ClimateRecord;
import com.autentia.prueba.miclima.model.DayType;

/**
 * Service for getting data from the data source and inserting climate records.
 * 
 * @author esloho
 *
 */
public interface ClimateRecordService {

    /**
     * Recover the list of current climate records. If no records exist yet,
     * return an empty list.
     * 
     * @return
     */
    public List<ClimateRecord> getClimateRecords();

    /**
     * Service for adding a new climate record to the data source.
     * 
     * @param climateRecord
     */
    public void addClimateRecord(ClimateRecord climateRecord);

    /**
     * Recover the list of available cities. If no city exist, return an empty
     * list.
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

    /**
     * Recover the list of available day types. If no type exist, return an
     * empty list.
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
