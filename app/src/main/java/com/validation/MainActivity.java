package com.validation;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.adapter.ViewDataAdapter;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.exception.ConversionException;
import com.validation.jobscheduler.MyJobService;
import com.validation.validate.EmailValid;
import com.validation.validate.Range;
import com.validation.validate.SpinnerValidate;
import com.validation.validate.Validate;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @NotEmpty
    @Email
    private TextInputLayout email;
    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC_MIXED_CASE_SYMBOLS)
    private TextInputLayout password;
    @NotEmpty
    private TextInputLayout name;
    @Checked(message = "You must agree to the terms.")
    private CheckBox checkBox;

    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }


    private void findViews() {

        email = (TextInputLayout) findViewById(R.id.email);
        password = (TextInputLayout) findViewById(R.id.password);
        name = (TextInputLayout) findViewById(R.id.name);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);


    }

    private static final int MYJOBID = 1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startJobSchedule() {


        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName jobService =
                new ComponentName(getPackageName(), MyJobService.class.getName());
        JobInfo jobInfo =
                new JobInfo.Builder(MYJOBID, jobService).setPeriodic(6000 * 60 * 5).build();

        /*
         * setPeriodic(long intervalMillis)
         * Specify that this job should recur with the provided interval,
         * not more than once per period.
         */

        int jobId = 0;
        if (jobScheduler != null) {
            jobId = jobScheduler.schedule(jobInfo);

            if (jobScheduler.schedule(jobInfo) > 0) {
                Toast.makeText(MainActivity.this,
                        "Successfully scheduled job: " + jobId,
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "RESULT_FAILURE: " + jobId,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void onValidateClick(View view) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            startJobSchedule();
//        }
//
//        Validator validator = new Validator(this);
//
//        validator.registerAdapter(TextInputLayout.class, new TextInputLayoutData());
//        validator.setViewValidatedAction(new Validator.ViewValidatedAction() {
//            @Override
//            public void onAllRulesPassed(View view) {
//
//                if (view instanceof TextInputLayout) {
//
//                    ((TextInputLayout) view).setErrorEnabled(false);
//                    ((TextInputLayout) view).setError(null);
//                }
//
//            }
//        });
//        validator.setValidationListener(new Validator.ValidationListener() {
//            @Override
//            public void onValidationSucceeded() {
//
//                Toast.makeText(MainActivity.this, "Valid", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onValidationFailed(List<ValidationError> errors) {
//
//                for (ValidationError error : errors) {
//                    View view = error.getView();
//                    String message = error.getCollatedErrorMessage(MainActivity.this);
//
//                    // Display error messages ;)
//                    if (view instanceof TextInputLayout) {
//                        ((TextInputLayout) view).setError(message);
//                    } else {
//                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//        });

//        validator.validate(true);

        Validate validate = new Validate(new Validate.ValidationErrorListener() {
            @Override
            public void onError(List<com.validation.validate.Validator> validates) {


                for (com.validation.validate.Validator error : validates) {

                    View view = error.getView();
                    String message = error.getErrorMessage();

                    // Display error messages ;)
                    if (view instanceof TextInputLayout) {
                        ((TextInputLayout) view).setError(message);
                    } else {


                        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();

//                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        validate.addValidator(new EmailValid(email, "Please enter a valid email"));
        validate.addValidator(new com.validation.validate.CheckBox(checkBox, "Please accept terms and conditions"));
        validate.addValidator(new Range(name, "Please enter above 400"));
        validate.addValidator(new SpinnerValidate(mySpinner, "Please select aleast any one product  "));
//
//        validate.addValidator(new EditTextEmailValidator(email, R.string.error_email));
//        validate.addValidator(new EditTextPasswordValidator(password, 6, R.string.error_password));
//        validate.addValidator(new EditTextEmptylValidator(name, R.string.error_name_empty));
//        validate.addValidator(new CheckBoxTrueValidator(checkBox, R.string.error_select_check_box));
//
        if (validate.validate()) {

            Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Not valid", Toast.LENGTH_SHORT).show();

        }


    }


    private class TextInputLayoutData implements ViewDataAdapter<TextInputLayout, String> {
        @Override
        public String getData(TextInputLayout view) throws ConversionException {
            return view.getEditText().getText().toString();
        }
    }
}
