package com.example.android.studentmanagement.ui.studentdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.studentmanagement.R;
import com.example.android.studentmanagement.data.db.Model.Student;
import com.example.android.studentmanagement.data.db.StudentDatabase;
import com.example.android.studentmanagement.ui.base.BaseActivity;

public class StudentDetailScreen extends BaseActivity implements View.OnClickListener, StudentDetailContract.View {

    private TextView mName;
    private TextView mEnglish;
    private TextView mHindi;
    private TextView mMarathi;
    private TextView mScience;
    private TextView mMathematics;
    private TextView mHistory;
    private TextView mPercentage;

    private StudentDetailContract.Presenter presenter;

    private StudentDatabase studentDatabase;

    private Button button;

    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail_screen);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        mName = findViewById(R.id.tv_name);
        mEnglish = findViewById(R.id.tv_english);
        mMarathi = findViewById(R.id.tv_marathi);
        mHindi = findViewById(R.id.tv_hindi);
        mScience = findViewById(R.id.tv_science);
        mMathematics = findViewById(R.id.tv_mathematics);
        mHistory = findViewById(R.id.tv_history);
        button = findViewById(R.id.btn_delete);
        mPercentage = findViewById(R.id.tv_percentage);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        student = (Student) bundle.getSerializable("student");

        mName.setText(student.getFirstName() + " " + student.getLastName());
        mEnglish.setText(student.getEnglish() + "");
        mMarathi.setText(student.getMarathi() + "");
        mHindi.setText(student.getHindi() + "");
        mScience.setText(student.getScience() + "");
        mMathematics.setText(student.getMathematics() + "");
        mHistory.setText(student.getHistory() + "");
        mPercentage.setText((int) student.getPercentage() + " %");
        button.setOnClickListener(this);

        studentDatabase = StudentDatabase.getInstance(this);
        presenter = (StudentDetailContract.Presenter) new StudentDetailPresenterImp((StudentDetailContract.View) this, studentDatabase);
    }

    @Override
    public void onClick(View view) {
        presenter.deleteStudentData(student);
    }

    @Override
    public void onDeleteSuccessful() {
        onBackPressed();
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
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        hideLoading();
    }

    @Override
    public void showMsg(String msg) {
        showMessage(msg);
    }
}
