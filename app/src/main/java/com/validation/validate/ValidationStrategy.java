package com.validation.validate;

import android.support.annotation.IntegerRes;
import android.text.TextUtils;
import android.util.Patterns;

public enum ValidationStrategy {


    EMAIL(ValidationType.EMAIL) {
        public <T> boolean validate(T s) {

            return !TextUtils.isEmpty((CharSequence) s) && Patterns.EMAIL_ADDRESS.matcher((CharSequence) s).matches();
        }
    },

    NON_EMPTY(ValidationType.NON_EMPTY) {
        public <T> boolean validate(T s) {

            return !TextUtils.isEmpty((CharSequence) s);
        }
    },

    RANGE(ValidationType.RANGE) {
        public <T> boolean validate(T s) {

            return !TextUtils.isEmpty((CharSequence) s) && Integer.parseInt(String.valueOf(s)) > 400;
        }
    },

    CHECK(ValidationType.CHECK) {
        @Override
        public <T> boolean validate(T s) {
            return Integer.parseInt(String.valueOf(s)) > 0;
        }
    },

    SELECT(ValidationType.SELECT) {
        @Override
        public <T> boolean validate(T s) {
            return Integer.parseInt(String.valueOf(s)) > 0;
        }
    };


    public ValidationType validationType;

    private ValidationStrategy(ValidationType validationStrategy) {

        this.validationType = validationStrategy;
    }

    public abstract <T> boolean validate(T s);

//    public abstract boolean validate(boolean s);
//
//    public abstract boolean validate(int pos);


}
