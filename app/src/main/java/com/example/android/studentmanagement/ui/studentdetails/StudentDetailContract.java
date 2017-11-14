package com.example.android.studentmanagement.ui.studentdetails;

import com.example.android.studentmanagement.data.db.Model.Student;

/**
 * Created by Vinod on 11/13/2017.
 */

public interface StudentDetailContract {

    interface View {
        void onDeleteSuccessful();

        void showDialog();

        void hideDialog();

        void showMsg(String msg);
    }

    interface Presenter {
        void deleteStudentData(Student student);
    }
}
