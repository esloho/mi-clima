package com.autentia.prueba.miclima.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.validate.ClientValidator;

/**
 * Validator to check that the input record date is not a future one.
 * 
 * @author esloho
 *
 */
@FacesValidator("dateValidator")
public class DateValidator implements Validator, ClientValidator {

    /*
     * (non-Javadoc)
     * 
     * @see org.primefaces.validate.ClientValidator#getValidatorId()
     */
    @Override
    public String getValidatorId() {
        return "dateValidator";
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.validator.Validator#validate(javax.faces.context.FacesContext
     * , javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object value)
            throws ValidatorException {

        if (value == null || !(value instanceof Date)) {
            return;
        }

        final Date inputDate = (Date) value;

        if (inputDate.after(Calendar.getInstance().getTime())) {
            throw new ValidatorException(
                    new FacesMessage("La fecha " + inputDate.toString()
                            + " es posterior a la fecha actual;"));
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.primefaces.validate.ClientValidator#getMetadata()
     */
    @Override
    public Map<String, Object> getMetadata() {
        return null;
    }
}
