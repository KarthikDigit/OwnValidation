package com.validation.validate;

import android.widget.CheckBox;
import android.widget.Spinner;

public class SpinnerValidation extends SpinnerValidatorTest {

    private ValidationStrategy strategy;

    public SpinnerValidation(Spinner view, String errorMessage, ValidationStrategy strategy) {
        super(view, errorMessage);
        this.strategy = strategy;
    }

    @Override
    public boolean validate() {
        return strategy.validate(getView().getSelectedItemPosition());
    }


}
