package com.autentia.prueba.miclima.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba.miclima.model.City;
import com.autentia.prueba.miclima.service.ClimateRecordService;

/**
 * Converter of City objects using the id as unique String representation.
 * 
 * @author esloho
 *
 */
@Service
public class CityConverter implements Converter {

    @Autowired
    private ClimateRecordService climateRecordService;

    /**
     * Given a City id as String, return the corresponding City object from the
     * data source.
     */
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }

        final Long cityId = Long.valueOf(id);
        return this.climateRecordService.getCityById(cityId);

    }

    /**
     * Given a City object, return its id as String.
     */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object city) {
        if (city == null && !(city instanceof City)) {
            return null;
        }

        return ((City) city).getId().toString();
    }

}
