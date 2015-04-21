package com.autentia.prueba.miclima.managedbean;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autentia.prueba.miclima.config.AppConfig;
import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.model.ClimateRecord;
import com.autentia.prueba.miclima.service.ClimateRecordService;

/**
 * Test Case for the class ClimateRecordManagedBean.
 * 
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ClimateRecordManagedBeanTest {

    @InjectMocks
    private ClimateRecordManagedBean climateRecordManagedBean;

    @Mock
    private ClimateRecordService climateServiceMock;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.managedbean.ClimateRecordManagedBean#updateLatestData()}
     * .
     */
    @Test
    public void testUpdateLatestData() {
        Mockito.when(this.climateServiceMock.getCities()).thenReturn(
                new ArrayList<City>());
        Mockito.when(this.climateServiceMock.getClimateRecords()).thenReturn(
                new ArrayList<ClimateRecord>());

        this.climateRecordManagedBean.updateLatestData(null);

        Mockito.verify(this.climateServiceMock, Mockito.times(1)).getCities();
        Mockito.verify(this.climateServiceMock, Mockito.times(1))
                .getClimateRecords();

        Assert.assertNotNull(this.climateRecordManagedBean.getCityNames());
        Assert.assertNotNull(this.climateRecordManagedBean.getClimateRecords());
    }

}
