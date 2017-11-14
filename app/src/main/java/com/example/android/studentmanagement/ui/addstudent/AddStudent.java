package com.example.android.studentmanagement.ui.addstudent;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.android.studentmanagement.R;
import com.example.android.studentmanagement.data.db.Model.Student;
import com.example.android.studentmanagement.data.db.StudentDatabase;
import com.example.android.studentmanagement.ui.base.BaseActivity;
import com.google.common.collect.Range;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddStudent extends BaseActivity implements AddStudentContract.View, View.OnClickListener {

    @BindView(R.id.editText)
    public EditText etFirstName;
    @BindView(R.id.editText2)
    public EditText etLastName;
    @BindView(R.id.et_subject_1)
    public EditText etEnglish;
    @BindView(R.id.et_subject_2)
    public EditText etMarathi;
    @BindView(R.id.et_subject_3)
    public EditText etHindi;
    @BindView(R.id.et_subject_4)
    public EditText etScience;
    @BindView(R.id.et_subject_5)
    public EditText etMathematics;
    @BindView(R.id.et_subject_6)
    public EditText etHistory;
    @BindView(R.id.btn_submit)
    public Button btnSubmit;
    @BindView(R.id.rb_male)
    public RadioButton rbMale;
    @BindView(R.id.rb_female)
    public RadioButton rbFemale;


    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;

    private AddStudentPresenterImp addStudentPresenter;

    private StudentDatabase studentDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        ButterKnife.bind(this);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.editText, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.name_error);
        awesomeValidation.addValidation(this, R.id.editText2, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.name_error);
        awesomeValidation.addValidation(this, R.id.et_subject_1, Range.closed(0, 100), R.string.marks_error);
        awesomeValidation.addValidation(this, R.id.et_subject_2, Range.closed(0, 100), R.string.marks_error);
        awesomeValidation.addValidation(this, R.id.et_subject_3, Range.closed(0, 100), R.string.marks_error);
        awesomeValidation.addValidation(this, R.id.et_subject_4, Range.closed(0, 100), R.string.marks_error);
        awesomeValidation.addValidation(this, R.id.et_subject_5, Range.closed(0, 100), R.string.marks_error);
        awesomeValidation.addValidation(this, R.id.et_subject_6, Range.closed(0, 100), R.string.marks_error);
        btnSubmit.setOnClickListener(AddStudent.this);

        studentDatabase = StudentDatabase.getInstance(this);
        addStudentPresenter = new AddStudentPresenterImp((AddStudentContract.View) AddStudent.this, studentDatabase);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                hideKeyboard();
                addStudentPresenter.onClickSubmit(awesomeValidation.validate());
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public Student getData() {
        String firstName = String.valueOf(etFirstName.getText());
        String lastName = String.valueOf(etLastName.getText());
        int english = Integer.parseInt(String.valueOf(etEnglish.getText()));
        int marathi = Integer.parseInt(String.valueOf(etMarathi.getText()));
        int hindi = Integer.parseInt(String.valueOf(etHindi.getText()));
        int science = Integer.parseInt(String.valueOf(etScience.getText()));
        int mathematics = Integer.parseInt(String.valueOf(etMathematics.getText()));
        int history = Integer.parseInt(String.valueOf(etHistory.getText()));
        boolean gender = rbMale.isChecked();
        Student student = new Student(firstName, lastName, gender, english, marathi, hindi, science, mathematics, history);
        return student;
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void dismissDial() {
        hideLoading();
    }

    @Override
    public void showSnackBar() {
        super.showSnackBar(getString(R.string.success));
    }

    @Override
    public void clearField() {
        etFirstName.setText("");
        etLastName.setText("");
        etEnglish.setText("");
        etHindi.setText("");
        etMarathi.setText("");
        etScience.setText("");
        etMathematics.setText("");
        etHistory.setText("");
    }
}
