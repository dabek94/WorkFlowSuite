package me.bdabrowski.wfs.view.fragments.menu.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployeeCompany extends Fragment {

    private UserViewModel userViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
            int viewId = createCompanyViewId(userViewModel.getUser().getValue());
            return inflater.inflate(viewId, container, false);
    }
    private int createCompanyViewId(User user){
        if(user.isUserEmployed()){
            return R.layout.employee_company;
        }
        else{
            return R.layout.employee_company_unemployeed;
        }
    }
}
