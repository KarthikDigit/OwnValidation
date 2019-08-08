package com.validation.validate;

import android.widget.Spinner;

public class SpinnerValidate extends SpinnerValidatorTest {

    public SpinnerValidate(Spinner view, String errorMessage) {
        super(view, errorMessage);
    }

    @Override
    public boolean validate() {
        return getView().getSelectedItemPosition() > 0;
    }
}
