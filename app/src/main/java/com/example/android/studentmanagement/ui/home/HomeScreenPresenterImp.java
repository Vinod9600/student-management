package com.example.android.studentmanagement.ui.home;

import android.os.AsyncTask;

import com.example.android.studentmanagement.data.db.Model.Student;
import com.example.android.studentmanagement.data.db.StudentDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinod on 11/13/2017.
 */

public class HomeScreenPresenterImp implements HomeScreenContract.Presenter {

    private HomeScreenContract.View view;

    public StudentDatabase studentDatabase;

    public HomeScreenPresenterImp(HomeScreenContract.View view, StudentDatabase studentDatabase) {
        this.view = view;
        this.studentDatabase = studentDatabase;
    }

    @Override
    public void PopulateData() {
        PopulateDataFromDb populateDataFromDb = new PopulateDataFromDb();
        populateDataFromDb.execute();
    }

    public class PopulateDataFromDb extends AsyncTask<Void, Void, List<Student>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showDialog();
        }

        @Override
        protected List<Student> doInBackground(Void... voids) {
            List<Student> studentList = new ArrayList<>();
            studentList = studentDatabase.studentDao().getStudent();
            return studentList;
        }

        @Override
        protected void onPostExecute(List<Student> studentList) {
            super.onPostExecute(studentList);
            view.hideDialog();
            view.updateRecyclerView(studentList);
        }
    }
}
