package com.example.Pyramidions.Repositories;

import android.os.StrictMode;
import com.example.Pyramidions.Models.Employee;
import com.example.Pyramidions.Retrofit.ApiRequest;
import com.example.Pyramidions.Retrofit.RetrofitRequest;

import java.io.IOException;
import java.util.List;
public class EmployeeRepository {

    private static EmployeeRepository instance;
    private ApiRequest apiRequest;
    public EmployeeRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }
    public static EmployeeRepository getInstance(){
        if(instance == null){
            instance = new EmployeeRepository();
        }
        return instance;
    }
    public List<Employee>  getEmployeeDetails(){
        avoidNetworkOSThreadException();
        List<Employee> response = null;
        try {
            response= apiRequest.getEmployeeList().execute().body().getData();
            System.out.println(response.get(0).getEmployee_name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    public static void avoidNetworkOSThreadException() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
