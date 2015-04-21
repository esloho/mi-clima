package com.autentia.prueba.miclima.managedbean;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.model.ClimateRecord;
import com.autentia.prueba.miclima.model.DayType;
import com.autentia.prueba.miclima.service.ClimateRecordService;
import com.autentia.prueba.miclima.util.MiClimaConstants;

/**
 * Managed bean for the creation and insertion of new climate records in the
 * data source.
 * 
 * @author esloho
 *
 */
@ManagedBean
@Controller
@ViewScoped
public class RegisterManagedBean {

    @Autowired
    private ClimateRecordService climateRecordService;

    private List<City> cities;
    private List<DayType> dayTypes;
    private ClimateRecord climateRecord;

    /**
     * Reset the form data and updates the list with the latest data from the
     * data source.
     * 
     * @param event
     */
    public void cleanAndUpdateData(ComponentSystemEvent event) {
        this.cities = this.climateRecordService.getCities();
        this.dayTypes = this.climateRecordService.getDayTypes();
        this.climateRecord = new ClimateRecord();
        // By default, recordDate is current date
        this.climateRecord.setRecordDate(Calendar.getInstance().getTime());
    }

    /**
     * Add a new climate record to the data source.
     * 
     * @return the view to navigate next.
     */
    public final String addClimateRecord() {

        this.climateRecordService.addClimateRecord(this.climateRecord);

        return MiClimaConstants.INDEX_PATH;
    }

    /**
     * @return the list of cities
     */
    public final List<City> getCities() {
        return this.cities;
    }

    /**
     * @param cityList
     *            the cities to set
     */
    public final void setCityList(List<City> cityList) {
        this.cities = cityList;
    }

    /**
     * @return the list of dayTypes
     */
    public final List<DayType> getDayTypes() {
        return this.dayTypes;
    }

    /**
     * @param dayTypeList
     *            the dayTypes to set
     */
    public final void setDayTypes(List<DayType> dayTypeList) {
        this.dayTypes = dayTypeList;
    }

    /**
     * @return the climateRecord
     */
    public final ClimateRecord getClimateRecord() {
        return this.climateRecord;
    }

    /**
     * @param climateRecord
     *            the climateRecord to set
     */
    public final void setClimateRecord(ClimateRecord climateRecord) {
        this.climateRecord = climateRecord;
    }

}
