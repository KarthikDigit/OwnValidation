package com.validation.validate;

import android.view.View;

public abstract class Validator<T extends View> implements ValidInterface {

    protected T view;
    protected String errorMessage;

    public Validator(T view, String errorMessage) {
        this.view = view;
        this.errorMessage = errorMessage;
    }


    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
