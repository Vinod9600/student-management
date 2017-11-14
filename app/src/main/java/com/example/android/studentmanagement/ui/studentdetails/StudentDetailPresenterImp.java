package com.example.android.studentmanagement.ui.studentdetails;

import android.content.Intent;
import android.os.AsyncTask;

import com.example.android.studentmanagement.data.db.Model.Student;
import com.example.android.studentmanagement.data.db.StudentDatabase;

/**
 * Created by Vinod on 11/13/2017.
 */

public class StudentDetailPresenterImp implements StudentDetailContract.Presenter{

    private StudentDetailContract.View view;

    private StudentDatabase studentDatabase;

    public StudentDetailPresenterImp(StudentDetailContract.View view, StudentDatabase studentDatabase) {
        this.view = view;
        this.studentDatabase = studentDatabase;
    }

    @Override
    public void deleteStudentData(Student student) {
        DeleteInDB deleteInDB = new DeleteInDB();
        deleteInDB.execute(student);
    }

    private class DeleteInDB extends AsyncTask<Student, Void, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showDialog();
        }

        @Override
        protected Integer doInBackground(Student... students) {
            Student student = students[0];
            studentDatabase.studentDao().deleteStudent(student);
            return 1;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            view.showMsg("Delete successfully.");
            view.hideDialog();
            view.onDeleteSuccessful();
        }
    }
}
