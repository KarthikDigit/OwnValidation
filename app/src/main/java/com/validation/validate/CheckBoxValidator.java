package com.validation.validate;
import android.widget.CheckBox;
import android.widget.Toast;

public abstract class CheckBoxValidator<T extends CheckBox> extends Validator<T> {


    public CheckBoxValidator(T view, int errorMessageId) {
        super(view, errorMessageId);
    }

    public T getEditText() {
        return view;
    }

    public void setEditText(T editText) {
        this.view = editText;
    }

    public String getText() {
        return this.view.getText().toString();
    }


    public boolean isChecked() {
        return this.view.isChecked();
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

    public CheckBoxValidator setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public void enableError(boolean isEnabled) {

        if (isEnabled) {
            Toast.makeText(view.getContext(), buildErrorMessage(), Toast.LENGTH_SHORT).show();
            view.setError(buildErrorMessage());
        } else {
            view.setError(null);
        }
    }
}