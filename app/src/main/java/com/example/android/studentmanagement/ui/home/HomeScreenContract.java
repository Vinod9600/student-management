package com.example.android.studentmanagement.ui.home;

import com.example.android.studentmanagement.data.db.Model.Student;

import java.util.List;

/**
 * Created by Vinod on 11/11/2017.
 */

public interface HomeScreenContract {

    interface View {

        void showDialog();

        void hideDialog();

        void updateRecyclerView(List<Student> studentList);

        void startStudentDetailsScreen(Student student);

    }

    interface Presenter {

        void PopulateData();
    }
}
