package com.validation.validate;

public class CheckBox extends CheckBoxValidatorTest<android.widget.CheckBox> {


    public CheckBox(android.widget.CheckBox view, String errorMessage) {
        super(view, errorMessage);
    }

    @Override
    public boolean validate() {
        return getView().isChecked();
    }


}
