package com.autentia.prueba.miclima.mapper;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.prueba.miclima.config.AppConfig;
import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.model.ClimateRecord;
import com.autentia.prueba.miclima.model.DayType;

/**
 * Test Case for the interface ClimateRecordMapper.
 * 
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ClimateRecordMapperTest {

    @Autowired
    private ClimateRecordMapper climateMapper;

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.mapper.ClimateRecordMapper#getAllClimateRecords()}
     * .
     */
    @Test
    public void testGetAllClimateRecords() {
        final List<ClimateRecord> records = this.climateMapper
                .getAllClimateRecords();
        Assert.assertNotNull(records);

        for (final ClimateRecord record : records) {
            System.out.println(record);
        }
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.mapper.ClimateRecordMapper#insertClimateRecord()}
     * .
     */
    @Test
    public void testInsertClimateRecord() {
        final int initialSize = this.climateMapper.getAllClimateRecords()
                .size();

        this.climateMapper.insertClimateRecord(createClimateRecordMock());

        Assert.assertEquals(initialSize + 1, this.climateMapper
                .getAllClimateRecords().size());
    }

    /**
     * Create a Climate Record mock object for testing purposes.
     * 
     * @return
     */
    private ClimateRecord createClimateRecordMock() {
        final City cityMadrid = new City();
        cityMadrid.setId(new Long(1));
        cityMadrid.setName("Cerdanyola del Vallès");

        final DayType dayType = new DayType();
        dayType.setId(new Long(1));
        dayType.setType("Soleado");

        final ClimateRecord record = new ClimateRecord();
        record.setCity(cityMadrid);
        record.setDayType(dayType);

        final Calendar calendar = Calendar.getInstance();
        record.setRecordDate(new Timestamp(calendar.getTime().getTime()));

        record.setTemperature(13.5f);
        record.setHumidity(70);
        record.setPrecipitation(14);
        record.setValidated(true);
        return record;
    }
}
