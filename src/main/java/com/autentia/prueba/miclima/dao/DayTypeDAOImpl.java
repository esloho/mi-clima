package com.autentia.prueba.miclima.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autentia.prueba.miclima.mapper.DayTypeMapper;
import com.autentia.prueba.miclima.model.DayType;

/**
 * Implementation of DAO for DayType objects.
 * 
 * @author esloho
 *
 */
@Component
public class DayTypeDAOImpl implements DayTypeDAO {

    @Autowired
    private DayTypeMapper dayTypeMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.autentia.prueba.miclima.dao.DayTypeDAO#getDayTypes()
     */
    @Override
    public List<DayType> getDayTypes() {
        List<DayType> dayTypes = this.dayTypeMapper.getAllDayTypes();

        if (dayTypes == null) {
            dayTypes = new ArrayList<DayType>();
        }

        return dayTypes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.autentia.prueba.miclima.dao.DayTypeDAO#getDayTypeById(java.lang.Long)
     */
    @Override
    public DayType getDayTypeById(Long id) {
        return this.dayTypeMapper.getDayTypeById(id);
    }
}
