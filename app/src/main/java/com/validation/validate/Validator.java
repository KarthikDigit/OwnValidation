package com.validation.validate;

public abstract class Validator<T> {

    protected T view;
    protected int errorMessageId;
    protected String errorMessage;

    public Validator(T view, int errorMessageId) {
        this.view = view;
        this.errorMessageId = errorMessageId;
    }


    public abstract boolean isValid();
}
