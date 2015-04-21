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
import com.autentia.prueba.miclima.mapper.DayTypeMapper;
import com.autentia.prueba.miclima.model.DayType;

/**
 * Test Case for the class DayTypeDAO.
 * 
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class DayTypeDAOTest {

    @Autowired
    @InjectMocks
    private DayTypeDAO dayTypeDAO;

    @Mock
    private DayTypeMapper dayTypeMapperMock;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.dao.DayTypeDAO#getDayTypes()}.
     */
    @Test
    public void testGetDayTypes() {
        final List<DayType> dayTypesMock = new ArrayList<DayType>();
        final DayType dayType = new DayType();
        dayTypesMock.add(dayType);

        Mockito.when(this.dayTypeMapperMock.getAllDayTypes()).thenReturn(
                dayTypesMock);

        final List<DayType> dayTypes = this.dayTypeDAO.getDayTypes();

        Assert.assertNotNull(dayTypes);
        Assert.assertEquals(1, dayTypes.size());
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.dao.DayTypeDAO#getDayTypeById(java.lang.Long)}
     * .
     */
    @Test
    public void testGetDayTypeById() {
        Mockito.when(this.dayTypeMapperMock.getDayTypeById(Mockito.anyLong()))
                .thenReturn(new DayType());

        final DayType dayType = this.dayTypeDAO.getDayTypeById(new Long(1));

        Assert.assertNotNull(dayType);
    }

}
