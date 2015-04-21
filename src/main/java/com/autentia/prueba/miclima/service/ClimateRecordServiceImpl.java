package com.autentia.prueba.miclima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba.miclima.dao.CityDAO;
import com.autentia.prueba.miclima.dao.ClimateRecordDAO;
import com.autentia.prueba.miclima.dao.DayTypeDAO;
import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.model.ClimateRecord;
import com.autentia.prueba.miclima.model.DayType;

/**
 * Implementation of the service ClimateRecordService.
 * 
 * @author esloho
 *
 */
@Service
public class ClimateRecordServiceImpl implements ClimateRecordService {

    @Autowired
    private ClimateRecordDAO climateRecordDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private DayTypeDAO dayTypeDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.autentia.prueba.miclima.service.ClimateRecordService#getClimateRecords
     * ()
     */
    @Override
    public final List<ClimateRecord> getClimateRecords() {
        return this.climateRecordDAO.getClimateRecords();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.autentia.prueba.miclima.service.ClimateRecordService#addClimateRecord
     * (com.autentia.prueba.miclima.model.ClimateRecord)
     */
    @Override
    public final void addClimateRecord(ClimateRecord climateRecord) {
        this.climateRecordDAO.addClimateRecord(climateRecord);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.autentia.prueba.miclima.service.ClimateRecordService#getCities()
     */
    @Override
    public final List<City> getCities() {
        return this.cityDAO.getCities();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.autentia.prueba.miclima.service.ClimateRecordService#getDayTypes()
     */
    @Override
    public final List<DayType> getDayTypes() {
        return this.dayTypeDAO.getDayTypes();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.autentia.prueba.miclima.service.ClimateRecordService#getCityById(
     * java.lang.Long)
     */
    @Override
    public City getCityById(Long id) {
        return this.cityDAO.getCityById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.autentia.prueba.miclima.service.ClimateRecordService#getDayTypeById
     * (java.lang.Long)
     */
    @Override
    public DayType getDayTypeById(Long id) {
        return this.dayTypeDAO.getDayTypeById(id);
    }
}
