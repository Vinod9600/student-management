package com.example.android.studentmanagement.ui.addstudent;

import android.os.AsyncTask;

import com.example.android.studentmanagement.data.db.Model.Student;
import com.example.android.studentmanagement.data.db.StudentDatabase;

/**
 * Created by Vinod on 11/12/2017.
 */

public class AddStudentPresenterImp implements AddStudentContract.Presenter {

    private AddStudentContract.View view;

    private StudentDatabase studentDatabase;

    public AddStudentPresenterImp(AddStudentContract.View view, StudentDatabase studentDatabase) {
        this.view = view;
        this.studentDatabase = studentDatabase;
    }

    @Override
    public void onClickSubmit(boolean isValidDataEntered) {
        if (isValidDataEntered) {
            Student student = view.getData();
            InsertInDB insertInDB = new InsertInDB();
            insertInDB.execute(student);
        }
    }

    private class InsertInDB extends AsyncTask<Student, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showDialog();
        }

        @Override
        protected Integer doInBackground(Student... students) {
            Student student = students[0];
            float sum = student.getEnglish() + student.getMarathi()
                    + student.getHindi() + student.getScience() +
                    student.getMathematics() + student.getHistory();
            float percentage = (sum / 6.0f) ;
            student.setPercentage(percentage);
            studentDatabase.studentDao().insertStudent(student);
            return 1;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            view.showSnackBar();
            view.clearField();
            view.dismissDial();
        }
    }
}
