package com.autentia.prueba.miclima.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autentia.prueba.miclima.config.AppConfig;
import com.autentia.prueba.miclima.dao.CityDAO;
import com.autentia.prueba.miclima.dao.ClimateRecordDAO;
import com.autentia.prueba.miclima.dao.DayTypeDAO;
import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.model.ClimateRecord;
import com.autentia.prueba.miclima.model.DayType;

/**
 * Test Case for the class ClimateRecordService.
 * 
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ClimateRecordServiceTest {

    @Autowired
    @InjectMocks
    private ClimateRecordService climateRecordService;

    @Mock
    private ClimateRecordDAO climateDAOMock;

    @Mock
    private CityDAO cityDAOMock;

    @Mock
    private DayTypeDAO dayTypeDAOMock;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.service.ClimateRecordService#getClimateRecords()}
     * .
     */
    @Test
    public void testGetClimateRecords() {
        final ClimateRecord record = new ClimateRecord();
        final List<ClimateRecord> recordsMock = new ArrayList<ClimateRecord>();
        recordsMock.add(record);

        Mockito.when(this.climateDAOMock.getClimateRecords()).thenReturn(
                recordsMock);

        final List<ClimateRecord> records = this.climateRecordService
                .getClimateRecords();

        Assert.assertNotNull(records);
        Assert.assertTrue(records.size() == 1);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.service.ClimateRecordService#addClimateRecords()}
     * .
     */
    @Test
    public void testAddClimateRecordClimateRecord() {
        final ClimateRecord climateRecord = new ClimateRecord();
        this.climateRecordService.addClimateRecord(climateRecord);

        Mockito.verify(this.climateDAOMock, Mockito.times(1)).addClimateRecord(
                climateRecord);
        Mockito.verifyNoMoreInteractions(this.climateDAOMock);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.service.ClimateRecordService#getCities()}
     * .
     */
    @Test
    public void testGetCities() {
        final List<City> citiesMock = new ArrayList<City>();
        final City cityTest = new City();
        citiesMock.add(cityTest);

        Mockito.when(this.cityDAOMock.getCities()).thenReturn(citiesMock);

        final List<City> cities = this.climateRecordService.getCities();

        Assert.assertNotNull(cities);
        Assert.assertEquals(1, cities.size());
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.service.ClimateRecordService#getCityById()}
     * .
     */
    @Test
    public void testGetCityById() {
        Mockito.when(this.cityDAOMock.getCityById(Mockito.anyLong()))
                .thenReturn(new City());

        Assert.assertNotNull(this.climateRecordService.getCityById(new Long(1)));
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.service.ClimateRecordService#getDayTypes()}
     * .
     */
    @Test
    public void testGetDayTypes() {
        final List<DayType> dayTypesMock = new ArrayList<DayType>();
        final DayType dayTypeTest = new DayType();
        dayTypesMock.add(dayTypeTest);

        Mockito.when(this.dayTypeDAOMock.getDayTypes())
                .thenReturn(dayTypesMock);

        final List<DayType> dayTypes = this.climateRecordService.getDayTypes();

        Assert.assertNotNull(dayTypes);
        Assert.assertEquals(1, dayTypes.size());
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.service.ClimateRecordService#getDayTypeById()}
     * .
     */
    @Test
    public void testGetDayTypeById() {
        Mockito.when(this.dayTypeDAOMock.getDayTypeById(Mockito.anyLong()))
                .thenReturn(new DayType());

        Assert.assertNotNull(this.climateRecordService.getDayTypeById(new Long(
                1)));
    }

}
