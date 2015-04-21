package com.autentia.prueba.miclima.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.prueba.miclima.model.DayType;
import com.autentia.prueba.miclima.service.ClimateRecordService;

/**
 * Converter of DayType objects using the id as unique String representation.
 * 
 * @author esloho
 *
 */
@Service
public class DayTypeConverter implements Converter {

    @Autowired
    private ClimateRecordService climateRecordService;

    /**
     * Given a DayType id as String, return the corresponding DayType object
     * from the data source.
     */
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }

        final Long dayTypeId = Long.valueOf(id);
        return this.climateRecordService.getDayTypeById(dayTypeId);

    }

    /**
     * Given a DayType object, return its id as String.
     */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object dayType) {
        if (dayType == null && !(dayType instanceof DayType)) {
            return null;
        }

        return ((DayType) dayType).getId().toString();
    }
}
