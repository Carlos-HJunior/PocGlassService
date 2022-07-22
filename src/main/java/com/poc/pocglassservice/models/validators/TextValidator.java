package com.poc.pocglassservice.models.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class TextValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value instanceof String) {
            if (!((String) value).trim().isEmpty()) {
                return;
            }
        }

        throw new ValidatorException(new FacesMessage("Value is invalid!"));
    }
}
