package com.example.android.studentmanagement.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.studentmanagement.R;
import com.example.android.studentmanagement.data.db.Model.Student;
import com.example.android.studentmanagement.data.db.StudentDatabase;
import com.example.android.studentmanagement.ui.addstudent.AddStudent;
import com.example.android.studentmanagement.ui.base.BaseActivity;
import com.example.android.studentmanagement.ui.studentdetails.StudentDetailScreen;

import java.util.List;

public class HomeScreen extends BaseActivity implements HomeScreenContract.View {

    public RecyclerView recyclerView;

    private FloatingActionButton fab;

    private StudentDatabase studentDatabase;

    private HomeScreenContract.Presenter homeScreenPresenter;

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen2);

        recyclerView = findViewById(R.id.recyclerView);


        studentDatabase = StudentDatabase.getInstance(this);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewData();
            }
        });
        homeScreenPresenter = new HomeScreenPresenterImp((HomeScreenContract.View) this, studentDatabase);

    }

    @Override
    protected void onResume() {
        super.onResume();
        homeScreenPresenter.PopulateData();
    }

    void addNewData(){
        Intent intent = new Intent(this, AddStudent.class);
        startActivity(intent);
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
    public void updateRecyclerView(List<Student> studentList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(studentList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void startStudentDetailsScreen(Student student) {
        Intent intent = new Intent(this, StudentDetailScreen.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("student", student);
        startActivity(intent);
    }
}
