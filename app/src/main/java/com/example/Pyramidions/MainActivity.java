package com.example.Pyramidions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.example.Pyramidions.Adapters.RecyclerAdapter;
import com.example.Pyramidions.Models.Employee;
import com.example.Pyramidions.ViewModels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private MainActivityViewModel mMainActivityViewModel;
    private FloatingActionButton fab;
    private EditText searchField;
    private boolean sorting=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        fab=findViewById(R.id.fabAscending);
        searchField=findViewById(R.id.edit_query);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                updateRecyclerView(mMainActivityViewModel.filter(s.toString()));
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final List<Employee> employeesList=mMainActivityViewModel.getEmployeeDetail();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    if (sorting) {
                        sorting=false;
                        employeesList.sort(new Comparator<Employee>() {
                            @Override
                            public int compare(Employee employee, Employee t1) {
                                return employee.getEmployee_name().compareTo(t1.getEmployee_name());
                            }
                        });
                    } else {
                        sorting=true;
                        employeesList.sort(new Comparator<Employee>() {
                            @Override
                            public int compare(Employee employee, Employee t1) {
                                return t1.getEmployee_name().compareTo(employee.getEmployee_name());
                            }
                        });
                    }
                }
                updateRecyclerView(employeesList);
            }
        });
        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new RecyclerAdapter(this, mMainActivityViewModel.getEmployeeDetail());
        mRecyclerView.setAdapter(mAdapter);
    }
    private void updateRecyclerView(List<Employee> employees){
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new RecyclerAdapter(this, employees);
        mRecyclerView.setAdapter(mAdapter);
    }
}