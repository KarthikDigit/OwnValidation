package com.validation.validate;

import android.support.design.widget.TextInputLayout;

public abstract class EditTextValidatorTest<T extends TextInputLayout> extends Validator<T> {


    public EditTextValidatorTest(T view, int errorMessageId) {
        super(view, errorMessageId);
    }

    public T getEditText() {
        return view;
    }

    public void setEditText(T editText) {
        this.view = editText;
    }

    public String getText() {
        return this.view.getEditText().getText().toString();
    }

    protected int getErrorMessageId() {
        return errorMessageId;
    }

    protected void setErrorMessageId(int errorMessageId) {
        this.errorMessageId = errorMessageId;
    }

    public String buildErrorMessage() {
        if (view == null || view.getContext() == null) {
            return "";
        }
        return errorMessage == null ? view.getContext().getString(errorMessageId) : errorMessage;
    }

    public EditTextValidatorTest setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public void enableError(boolean isEnabled) {

        if (isEnabled) {
            view.setErrorEnabled(true);
            view.setError(buildErrorMessage());
        } else {
            view.setErrorEnabled(false);
            view.setError(null);
        }
    }
}