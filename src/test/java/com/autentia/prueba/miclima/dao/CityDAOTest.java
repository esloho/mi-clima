package com.autentia.prueba.miclima.dao;

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
import com.autentia.prueba.miclima.mapper.CityMapper;
import com.autentia.prueba.miclima.model.City;

/**
 * Test case for the class CityDAO.
 * 
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CityDAOTest {

    @Autowired
    @InjectMocks
    private CityDAO cityDAO;

    @Mock
    private CityMapper cityMapperMock;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.dao.CityDAO#getCities()}.
     */
    @Test
    public void testGetCities() {
        final City city = new City();
        final List<City> citiesMock = new ArrayList<City>();
        citiesMock.add(city);

        Mockito.when(this.cityMapperMock.getAllCities()).thenReturn(citiesMock);

        final List<City> cities = this.cityDAO.getCities();

        Assert.assertNotNull(cities);
        Assert.assertEquals(1, cities.size());
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.dao.CityDAO#getCityById()}.
     */
    @Test
    public void testGetCityById() {
        Mockito.when(this.cityMapperMock.getCityById(Mockito.anyLong()))
                .thenReturn(new City());

        final City selectedCity = this.cityDAO.getCityById(new Long(1));

        Assert.assertNotNull(selectedCity);
    }

}
