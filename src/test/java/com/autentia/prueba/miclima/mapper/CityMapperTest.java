/**
 * 
 */
package com.autentia.prueba.miclima.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autentia.prueba.miclima.config.AppConfig;
import com.autentia.prueba.miclima.model.City;

/**
 * Test Case for the interface CityMapper.
 * 
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CityMapperTest {

    @Autowired
    CityMapper cityMapper;

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.mapper.CityMapper#getAllCities()}.
     */
    @Test
    public void testGetAllCities() {
        final List<City> cities = this.cityMapper.getAllCities();
        Assert.assertNotNull(cities);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.mapper.CityMapper#getCityById(java.lang.Long)}
     * .
     */
    @Test
    public void testGetCityById() {
        final City city = this.cityMapper.getCityById(new Long(1));
        Assert.assertNotNull(city);
        Assert.assertEquals("Madrid", city.getName());
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.mapper.CityMapper#getCityById()}.
     */
    @Test
    public void testGetCityByFakeId() {
        final City selectedCity = this.cityMapper.getCityById(new Long(1025));
        Assert.assertNull(selectedCity);
    }

}
