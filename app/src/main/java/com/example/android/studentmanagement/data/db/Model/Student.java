package com.example.android.studentmanagement.data.db.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by Vinod on 11/12/2017.
 */

@Entity(tableName = "student")
public class Student implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "gender")
    private boolean gender;

    @ColumnInfo(name = "english")
    private int english;

    @ColumnInfo(name = "marathi")
    private int marathi;

    @ColumnInfo(name = "hindi")
    private int hindi;

    @ColumnInfo(name = "science")
    private int science;

    @ColumnInfo(name = "mathematics")
    private int mathematics;

    @ColumnInfo(name = "history")
    private int history;

    @ColumnInfo(name = "percentage")
    private float percentage;

    public Student(int id, String firstName, String lastName, boolean gender, int english, int marathi, int hindi, int science, int mathematics, int history, float percentage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.english = english;
        this.marathi = marathi;
        this.hindi = hindi;
        this.science = science;
        this.mathematics = mathematics;
        this.history = history;
        this.percentage = percentage;
    }

    @Ignore
    public Student(String firstName, String lastName, boolean gender, int english, int marathi, int hindi, int science, int mathematics, int history) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.english = english;
        this.marathi = marathi;
        this.hindi = hindi;
        this.science = science;
        this.mathematics = mathematics;
        this.history = history;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMarathi() {
        return marathi;
    }

    public void setMarathi(int marathi) {
        this.marathi = marathi;
    }

    public int getHindi() {
        return hindi;
    }

    public void setHindi(int hindi) {
        this.hindi = hindi;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getMathematics() {
        return mathematics;
    }

    public void setMathematics(int mathematics) {
        this.mathematics = mathematics;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
