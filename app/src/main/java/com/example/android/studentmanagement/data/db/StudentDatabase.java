package com.example.android.studentmanagement.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.android.studentmanagement.data.db.Model.Student;


/**
 * The Room Database that contains the Student table.
 */
@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase INSTANCE;

    public abstract StudentDao studentDao();

    private static final Object sLock = new Object();

    public static StudentDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        StudentDatabase.class, "Student.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
