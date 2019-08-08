package com.validation.validate;

import android.widget.CheckBox;
import android.widget.Spinner;

public abstract class SpinnerValidatorTest extends Validator<Spinner> {


    public SpinnerValidatorTest(Spinner view, String errorMessage) {
        super(view, errorMessage);
    }

    @Override
    public void showError(String s) {
//        getView().setErrorEnabled(true);
//        getView().setError(s);
    }

    public void hideError() {

//        getView().setErrorEnabled(false);
//        getView().setError(null);
    }
}