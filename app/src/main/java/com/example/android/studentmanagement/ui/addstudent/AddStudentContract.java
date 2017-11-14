package com.example.android.studentmanagement.ui.addstudent;

import com.example.android.studentmanagement.data.db.Model.Student;

/**
 * Created by Vinod on 11/12/2017.
 */

public interface AddStudentContract {

    interface View {

        Student getData();

        void showDialog();

        void dismissDial();

        void showSnackBar();

        void clearField();
    }

    interface Presenter {

        void onClickSubmit(boolean isValidDataEntered);
    }

}
