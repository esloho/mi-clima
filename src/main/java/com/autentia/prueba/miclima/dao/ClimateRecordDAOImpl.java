package com.autentia.prueba.miclima.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.prueba.miclima.mapper.ClimateRecordMapper;
import com.autentia.prueba.miclima.model.ClimateRecord;

/**
 * Implementation of DAO for ClimateRecord objects.
 * 
 * @author esloho
 *
 */
@Component
public class ClimateRecordDAOImpl implements ClimateRecordDAO {

    @Autowired
    private ClimateRecordMapper climateRecordMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.autentia.prueba.miclima.dao.ClimateRecordDAO#getClimateRecords()
     */
    @Override
    public List<ClimateRecord> getClimateRecords() {
        List<ClimateRecord> climateRecords = this.climateRecordMapper
                .getAllClimateRecords();

        if (climateRecords == null) {
            climateRecords = new ArrayList<ClimateRecord>();
        }

        return climateRecords;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.autentia.prueba.miclima.dao.ClimateRecordDAO#addClimateRecord(com
     * .autentia.prueba.miclima.model.ClimateRecord)
     */
    @Override
    @Transactional
    public void addClimateRecord(ClimateRecord climateRecord) {
        this.climateRecordMapper.insertClimateRecord(climateRecord);
    }
}
