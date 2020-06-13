package me.bdabrowski.wfs.view.fragments.menu.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import java.util.List;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.EmployeeCompanyBinding;
import me.bdabrowski.wfs.service.model.Company;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.CompanyViewModel;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployeeCompany extends Fragment {

    private UserViewModel userViewModel;
    private NavController navController;
    private EmployeeCompanyBinding companyBinding;
    private CompanyViewModel companyViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        int viewId = createCompanyViewId(userViewModel.getUser().getValue());
        if (viewId == R.layout.employee_company_unemployeed) {
            return inflater.inflate(viewId, container, false);
        }

        companyBinding = DataBindingUtil.inflate(inflater, viewId, container, false);

        Long companyId = userViewModel.getUser().getValue().getCompanyId();
        companyViewModel = new ViewModelProvider(getActivity()).get(CompanyViewModel.class);
        companyViewModel.getCompany(companyId).observe(getActivity(), company -> {
            if (company == null) {
                Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_LONG).show();
                return;
            }
            //given information doesn't match remote database
            else if (company.getName() == null) {
                Toast.makeText(getContext(), "Invalid information", Toast.LENGTH_LONG).show();
                return;
            }
            //if success
            else {
                companyBinding.setCompany(company);
            }
        });
            return companyBinding.getRoot();
    }

    private int createCompanyViewId(User user) {
        if (user.isUserEmployed()) {
            return R.layout.employee_company;
        } else {
            return R.layout.employee_company_unemployeed;
        }
    }

}
