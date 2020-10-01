package com.example.Pyramidions.ViewModels;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.Pyramidions.Models.Employee;
import com.example.Pyramidions.Repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Employee>> mLiveData;
    private List<Employee> employeeList;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();
    private EmployeeRepository mRepo;
    public List<Employee> getEmployeeDetail(){
        return  employeeList;
    }
    public void init(){
        if(employeeList != null){
            return;
        }
        mRepo = mRepo.getInstance();
        mIsUpdating.setValue(true);
        employeeList = mRepo.getEmployeeDetails();
        mIsUpdating.setValue(false);
    }
   public List<Employee> filter(String text){
        List<Employee> temp = new ArrayList();
        for(Employee d: employeeList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getEmployee_name().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        return temp;
    }
}
