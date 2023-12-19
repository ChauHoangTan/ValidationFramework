package validation.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import validation.Validation;
import validation.annotation.IsNumber;

public class IsNumberValidation extends Validation {

    public IsNumberValidation(Validation chValidation){
        this.childValidation = chValidation;
    }

    @Override
    protected String getReason(Field field) {
        IsNumber isNumber = field.getAnnotation(IsNumber.class);
        return isNumber.message();
    }

    @Override
    protected Boolean isValid(String value, Field field) {
        try {
            // Sử dụng BigDecimal để kiểm tra số âm, số thập phân
            new BigDecimal(value);
            return true;
        } catch (NumberFormatException e) {
            // Nếu có lỗi NumberFormatException, chuỗi không phải là số
            return false;
        }
    }
    
}
