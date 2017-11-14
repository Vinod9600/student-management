package com.example.android.studentmanagement.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.android.studentmanagement.data.db.Model.Student;

import java.util.List;

/**
 * Created by Vinod on 11/12/2017.
 */

@Dao
public interface StudentDao {

    @Query("SELECT * FROM student ORDER BY percentage DESC")
    List<Student> getStudent();

    @Query("SELECT * FROM student WHERE id = :sId")
    Student getStudent(int sId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Student student);

    @Update
    int updateStudent(Student student);

    @Delete
    int deleteStudent(Student student);

}
