package com.autentia.prueba.miclima.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Model class representing a climate record.
 * 
 * @author esloho
 *
 */
public class ClimateRecord {

    private Long id;

    @NotNull
    private City city;

    @NotNull
    @Past
    private Date recordDate;

    @NotNull
    private float temperature;

    @NotNull
    @Min(0)
    @Max(100)
    private int humidity;

    @NotNull
    private int precipitation;

    @NotNull
    private DayType dayType;

    @NotNull
    private boolean validated;

    /**
     * @return the city
     */
    public final City getCity() {
        return this.city;
    }

    /**
     * @param city
     *            the city to set
     */
    public final void setCity(City city) {
        this.city = city;
    }

    /**
     * @return the record_date
     */
    public final Date getRecordDate() {
        return this.recordDate;
    }

    /**
     * @param record_date
     *            the record_date to set
     */
    public final void setRecordDate(Date date) {
        this.recordDate = date;
    }

    /**
     * @return the temperature
     */
    public final float getTemperature() {
        return this.temperature;
    }

    /**
     * @param temperature
     *            the temperature to set
     */
    public final void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the humidity
     */
    public final int getHumidity() {
        return this.humidity;
    }

    /**
     * @param humidity
     *            the humidity to set
     */
    public final void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the precipitation
     */
    public final int getPrecipitation() {
        return this.precipitation;
    }

    /**
     * @param precipitation
     *            the precipitation to set
     */
    public final void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * @return the dayType
     */
    public final DayType getDayType() {
        return this.dayType;
    }

    /**
     * @param dayType
     *            the dayType to set
     */
    public final void setDayType(DayType dayType) {
        this.dayType = dayType;
    }

    /**
     * @return the validated
     */
    public final boolean isValidated() {
        return this.validated;
    }

    /**
     * @param validated
     *            the validated to set
     */
    public final void setValidated(boolean validated) {
        this.validated = validated;
    }

    /**
     * @return the id
     */
    public final Long getId() {
        return this.id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
