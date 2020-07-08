package me.bdabrowski.wfs.view.fragments.menu.employee.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.FragmentEmployeeCompanyBinding;
import me.bdabrowski.wfs.service.model.Company;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployeeCompanyFragment extends Fragment {

    private UserViewModel userViewModel;
    private NavController navController;
    private FragmentEmployeeCompanyBinding employeeCompanyBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        int viewId = createCompanyViewId(userViewModel.getUser().getValue());
        if (viewId == R.layout.fragment_employee_company_none) {
            return inflater.inflate(viewId, container, false);
        }

        employeeCompanyBinding = DataBindingUtil.inflate(inflater, viewId, container, false);

        Company userCompany = userViewModel.getUser().getValue().getCompany();
        if (userCompany == null) {
            employeeCompanyBinding.setCompany(new Company());
        } else {
            employeeCompanyBinding.setCompany(userCompany);
        }
        return employeeCompanyBinding.getRoot();
    }

    private int createCompanyViewId(User user) {
        if (user.isUserEmployed()) {
            return R.layout.fragment_employee_company;
        } else {
            return R.layout.fragment_employee_company_none;
        }
    }

}
