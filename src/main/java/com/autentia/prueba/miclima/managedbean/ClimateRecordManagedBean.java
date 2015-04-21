package com.autentia.prueba.miclima.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.model.ClimateRecord;
import com.autentia.prueba.miclima.service.ClimateRecordService;

/**
 * Managed bean for listing the climate records in the corresponding view.
 * 
 * @author esloho
 *
 */
@ManagedBean
@Controller
@ViewScoped
public class ClimateRecordManagedBean {

    @Autowired
    private ClimateRecordService climateRecordService;

    private List<String> cityNames;
    private List<ClimateRecord> climateRecords;
    private List<ClimateRecord> filteredRecords;

    /**
     * Update the lists of climate records and city names with latest data from
     * data source.
     */
    public void updateLatestData(ComponentSystemEvent event) {
        this.climateRecords = this.climateRecordService.getClimateRecords();

        this.cityNames = new ArrayList<String>();
        for (final City c : this.climateRecordService.getCities()) {
            this.cityNames.add(c.getName());
        }
    }

    /**
     * @return the list of climate records
     */
    public final List<ClimateRecord> getClimateRecords() {
        return this.climateRecords;
    }

    /**
     * @param climateRecords
     *            the climateRecordList to set
     */
    public final void setClimateRecords(List<ClimateRecord> records) {
        this.climateRecords = records;
    }

    /**
     * @return the list of city names
     */
    public final List<String> getCityNames() {
        return this.cityNames;
    }

    /**
     * @param cityNames
     *            the cityNames to set
     */
    public void setCityNames(List<String> cityNames) {
        this.cityNames = cityNames;
    }

    /**
     * @return the filteredRecords
     */
    public final List<ClimateRecord> getFilteredRecords() {
        return this.filteredRecords;
    }

    /**
     * @param filteredRecords
     *            the filteredRecords to set
     */
    public final void setFilteredRecords(List<ClimateRecord> filteredRecords) {
        this.filteredRecords = filteredRecords;
    }
}
