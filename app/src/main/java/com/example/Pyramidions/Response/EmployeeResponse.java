package com.example.Pyramidions.Response;

import com.example.Pyramidions.Models.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeResponse {

    @SerializedName("data")
    @Expose
    private List<Employee> data;
    @SerializedName("status")
    @Expose
    private String status;

    public List<Employee> getData ()
    {
        return data;
    }

    public void setData (List<Employee> data)
    {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+"]";
    }
}
