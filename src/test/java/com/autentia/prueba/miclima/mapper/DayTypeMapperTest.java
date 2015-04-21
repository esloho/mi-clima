/**
 * 
 */
package com.autentia.prueba.miclima.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autentia.prueba.miclima.config.AppConfig;
import com.autentia.prueba.miclima.model.DayType;

/**
 * Test Case for the interface DayTypeMapper.
 * 
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class DayTypeMapperTest {

    @Autowired
    private DayTypeMapper dayTypeMapper;

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.mapper.DayTypeMapper#getAllDayTypes()}
     * .
     */
    @Test
    public void testGetAllDayTypes() {
        final int size = this.dayTypeMapper.getAllDayTypes().size();
        Assert.assertEquals(4, size);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.mapper.DayTypeMapper#getDayTypeById(java.lang.Long)}
     * .
     */
    @Test
    public void testGetDayTypeById() {
        final DayType dayType = this.dayTypeMapper.getDayTypeById(new Long(1));
        Assert.assertNotNull(dayType);
        Assert.assertEquals("Soleado", dayType.getType());
    }

}
