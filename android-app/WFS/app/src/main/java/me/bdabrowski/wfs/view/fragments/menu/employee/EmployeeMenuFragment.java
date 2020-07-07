package me.bdabrowski.wfs.view.fragments.menu.employee;

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
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.FragmentEmployeeMenuBinding;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployeeMenuFragment extends Fragment{

    private UserViewModel userViewModel;
    private FragmentEmployeeMenuBinding employeeMenuBinding;
    private BottomNavigationView bottomNavigationView;

    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);

        employeeMenuBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_employee_menu, container, false);
        employeeMenuBinding.setUser(userViewModel.getUser().getValue());

        View view = employeeMenuBinding.getRoot();
        //profile icon

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view.findViewById(R.id.menu_body_nav));
        bottomNavigationView = view.findViewById(R.id.employee_menu_bottom_navigation);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

}
