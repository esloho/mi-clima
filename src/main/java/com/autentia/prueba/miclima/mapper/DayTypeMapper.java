package com.autentia.prueba.miclima.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.autentia.prueba.miclima.model.DayType;

/**
 * Mapper of objects from the day_type table in the data source to the model
 * class DayType.
 * 
 * @author esloho
 *
 */
public interface DayTypeMapper {

    /**
     * Select all the day types from the table day_types in the data source.
     * 
     * @return
     */
    @Select("SELECT * FROM day_type")
    public List<DayType> getAllDayTypes();

    /**
     * Select the dayType corresponding to the given id from the table day_type
     * in the data source.
     * 
     * @param dayTypeId
     * @return
     */
    @Select("SELECT * FROM day_type WHERE id = #{dayTypeId}")
    public DayType getDayTypeById(long dayTypeId);
}
