package com.validation.validate;

import android.widget.CheckBox;

public abstract class CheckBoxValidatorTest<T extends CheckBox> extends Validator<T> {


    public CheckBoxValidatorTest(T view, String errorMessage) {
        super(view, errorMessage);
    }

    @Override
    public void showError(String s) {
//        getView().setErrorEnabled(true);
        getView().setError(s);
    }

    public void hideError() {

//        getView().setErrorEnabled(false);
        getView().setError(null);
    }
}