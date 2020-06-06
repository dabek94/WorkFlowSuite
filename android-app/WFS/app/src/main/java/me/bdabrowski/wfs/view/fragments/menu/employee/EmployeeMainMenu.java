package me.bdabrowski.wfs.view.fragments.menu.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.EmployeeMenuBinding;
import me.bdabrowski.wfs.view.fragments.account.AccountSettings;
import me.bdabrowski.wfs.view.utils.FragmentContentFactory;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployeeMainMenu extends Fragment {

    private UserViewModel userViewModel;
    private EmployeeMenuBinding employeeMenuBinding;
    private ImageButton profilePicture;

    private BottomNavigationView bottomNavigationView;

    private Fragment bodyFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        employeeMenuBinding = DataBindingUtil.inflate(inflater, R.layout.employee_menu, container, false);
        employeeMenuBinding.setUser(userViewModel.getUser().getValue());
        View view = employeeMenuBinding.getRoot();

        bodyFragment = getFragmentManager().findFragmentById(R.id.employee_menu_body);

        //profile icon
        profilePicture = view.findViewById(R.id.profile_picture);
        profilePicture.setOnClickListener(v -> {
            FragmentNavigator.get().changeViewBackStack(this, new AccountSettings());
        });

        //bottom navigation view
        bottomNavigationView = view.findViewById(R.id.employee_menu_bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.employee_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.employee_home:
                    return changeHomeView();
                case R.id.employee_company:
                    //TODO FRAGMENT
                    return true;
                case R.id.employee_jobs:
                    //TODO FRAGMENT
                    return true;
            }
            return false;
        });
        return view;
    }

    private boolean changeHomeView(){
        this.bodyFragment = FragmentContentFactory.createEmployeeMenuBody(userViewModel.getUser().getValue());
        return true;
    }

}
