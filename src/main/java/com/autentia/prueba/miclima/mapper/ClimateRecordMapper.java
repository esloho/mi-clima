package com.autentia.prueba.miclima.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.model.ClimateRecord;
import com.autentia.prueba.miclima.model.DayType;

/**
 * Mapper of objects from the table climate_record in the data source to the
 * model class ClimateRecord.
 * 
 * @author esloho
 *
 */
public interface ClimateRecordMapper {

    /**
     * Select all the climate records from the climate_record table in the data
     * source. The associated City and DayType objects are recovered as well.
     * 
     * @return
     */
    @Select("SELECT * FROM climate_record WHERE validated = true")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "recordDate", column = "record_date", javaType = Date.class),
            @Result(property = "city", column = "city_id", javaType = City.class, one = @One(select = "com.autentia.prueba.miclima.mapper.CityMapper.getCityById")),
            @Result(property = "dayType", column = "day_type_id", javaType = DayType.class, one = @One(select = "com.autentia.prueba.miclima.mapper.DayTypeMapper.getDayTypeById")) })
    public List<ClimateRecord> getAllClimateRecords();

    /**
     * Insert a new climate record in the table climate_record. The associated
     * city and day type values must already exist in the data source
     * 
     * @param climateRecord
     * @return
     */
    @Insert("INSERT INTO climate_record (city_id, record_date, temperature, "
            + "humidity, precipitation, day_type_id, validated) "
            + "VALUES (#{city.id}, #{recordDate}, #{temperature}, #{humidity}, "
            + "#{precipitation}, #{dayType.id}, #{validated}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insertClimateRecord(ClimateRecord climateRecord);
}
