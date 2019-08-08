package com.validation.validate;

import android.text.TextUtils;
import android.util.Patterns;

public enum ValidationStrategy {


    EMAIL(ValidationType.EMAIL) {
        public boolean validate(String s) {

            return !TextUtils.isEmpty(s) && Patterns.EMAIL_ADDRESS.matcher(s).matches();
        }
    };


    public ValidationType validationType;

    ValidationStrategy(ValidationType validationStrategy) {

        this.validationType = validationStrategy;
    }
}
