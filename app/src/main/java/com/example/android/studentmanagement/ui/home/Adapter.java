package com.example.android.studentmanagement.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.studentmanagement.R;
import com.example.android.studentmanagement.data.db.Model.Student;
import com.example.android.studentmanagement.ui.studentdetails.StudentDetailScreen;

import java.util.List;

/**
 * Created by Vinod on 11/12/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.StudentHolder> {


    private List<Student> studentList;

    private Context context;

    private HomeScreenContract.View view;

    public Adapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
        view = (HomeScreenContract.View) context;
    }

    @Override
    public Adapter.StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_single_row_card, parent, false);
        return new StudentHolder(itemView);
    }


    @Override
    public void onBindViewHolder(Adapter.StudentHolder holder, int position) {
        final Student student = studentList.get(position);
        holder.tvName.setText(student.getFirstName() + " " + student.getLastName());
        holder.tvPercentage.setText(context.getString(R.string.percentage) + student.getPercentage() + " %");
        holder.singleRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StudentDetailScreen.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("student", student);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvPercentage;
        public ImageView imageView;
        public LinearLayout singleRowContainer;

        public StudentHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPercentage = itemView.findViewById(R.id.tv_persentag);
            singleRowContainer= itemView.findViewById(R.id.ll_single_row);
        }
    }
}
