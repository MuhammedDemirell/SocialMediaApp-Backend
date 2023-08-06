package com.demirel.socialmedia.model.exception;

import lombok.Getter;

@Getter
public class BusinessValidationException extends RuntimeException {

    private final IBusinessValidationRule validationRule;

    public BusinessValidationException(IBusinessValidationRule validationRule) {
        super(validationRule.getMessage());
        this.validationRule = validationRule;
    }

    public BusinessValidationException(IBusinessValidationRule validationRule, Object... params) {
        super(String.format(validationRule.getMessage(), params));
        this.validationRule = validationRule;
    }

}
