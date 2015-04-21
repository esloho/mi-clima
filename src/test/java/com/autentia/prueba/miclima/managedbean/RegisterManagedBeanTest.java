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
import com.autentia.prueba.miclima.model.DayType;
import com.autentia.prueba.miclima.service.ClimateRecordService;
import com.autentia.prueba.miclima.util.MiClimaConstants;

/**
 * Test Case for the class RegisterManagedBean.
 * 
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class RegisterManagedBeanTest {

    @InjectMocks
    private RegisterManagedBean registerManagedBean;

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
     * {@link com.autentia.prueba.miclima.managedbean.RegisterManagedBean#init()}
     * .
     */
    @Test
    public void testCleanAndUpdateData() {
        Mockito.when(this.climateServiceMock.getCities()).thenReturn(
                new ArrayList<City>());
        Mockito.when(this.climateServiceMock.getDayTypes()).thenReturn(
                new ArrayList<DayType>());

        this.registerManagedBean.cleanAndUpdateData(null);

        Mockito.verify(this.climateServiceMock, Mockito.times(1)).getCities();
        Mockito.verify(this.climateServiceMock, Mockito.times(1)).getDayTypes();

        Assert.assertNotNull(this.registerManagedBean.getCities());
        Assert.assertNotNull(this.registerManagedBean.getDayTypes());
        Assert.assertNotNull(this.registerManagedBean.getClimateRecord());
        ;
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.managedbean.RegisterManagedBean#addClimateRecord()}
     * .
     */
    @Test
    public void testAddClimateRecord() {
        this.registerManagedBean.addClimateRecord();

        Mockito.verify(this.climateServiceMock, Mockito.times(1))
                .addClimateRecord(Mockito.any(ClimateRecord.class));
        Mockito.verifyNoMoreInteractions(this.climateServiceMock);
    }

    /**
     * Test method for
     * {@link com.autentia.prueba.miclima.managedbean.RegisterManagedBean#addClimateRecord()}
     * .
     */
    @Test(expected = RuntimeException.class)
    public void testAddClimateRecordException() {
        Mockito.doThrow(RuntimeException.class).when(this.climateServiceMock)
                .addClimateRecord(Mockito.any(ClimateRecord.class));

        final String result = this.registerManagedBean.addClimateRecord();

        Assert.assertNotEquals(MiClimaConstants.INDEX_PATH, result);
    }
}
