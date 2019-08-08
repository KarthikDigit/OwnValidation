package com.validation.validate;

import android.support.design.widget.TextInputLayout;

public abstract class EditTextValidatorTest<T extends TextInputLayout> extends Validator<T> {


    public EditTextValidatorTest(T view, String errorMessage) {
        super(view, errorMessage);
    }

    public String getText() {
        return getView().getEditText().getText().toString();
    }

    @Override
    public void showError(String s) {
        getView().setErrorEnabled(true);
        getView().setError(s);
    }

    public void hideError() {

        getView().setErrorEnabled(false);
        getView().setError(null);
    }

}