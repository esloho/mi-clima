package com.autentia.prueba.miclima.dao;

import java.util.List;

import com.autentia.prueba.miclima.model.ClimateRecord;

/**
 * DAO for ClimateRecord objects.
 * 
 * @author esloho
 *
 */
public interface ClimateRecordDAO {

    /**
     * Get a List of all climate records from the data source. If no records
     * exist, return an empty list.
     * 
     * @return
     */
    public List<ClimateRecord> getClimateRecords();

    /**
     * Add a new record to the data source.
     * 
     * @param climateRecord
     */
    public void addClimateRecord(ClimateRecord climateRecord);
}
