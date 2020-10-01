package com.example.Pyramidions.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.Pyramidions.Models.Employee;
import com.example.Pyramidions.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Employee> mEmployee = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context context, List<Employee> employees) {
        mEmployee = employees;
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder)viewHolder).mName.setText(mEmployee.get(position).getEmployee_name());
        ((ViewHolder)viewHolder).mAge.setText(String.valueOf(mEmployee.get(position).getEmployee_age()));
        ((ViewHolder)viewHolder).mSalary.setText(String.valueOf(mEmployee.get(position).getEmployee_salary()));
        // Set the image
        System.out.println(mEmployee.get(position).getEmployee_name());
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mEmployee.get(position).getProfile_image())
                .into(((ViewHolder)viewHolder).mImage);
    }

    @Override
    public int getItemCount() {
        return mEmployee.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView mImage;
        private TextView mName;
        private TextView mAge;
        private TextView mSalary;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.image_name);
            mAge = itemView.findViewById(R.id.image_age);
            mSalary = itemView.findViewById(R.id.image_salary);
        }
    }

}
