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
    private FragmentEmployeeMenuBinding menuBinding;
    private BottomNavigationView bottomNavigationView;

    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        menuBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_employee_menu, container, false);
        menuBinding.setUser(userViewModel.getUser().getValue());
        return menuBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view.findViewById(R.id.nav_body_employee));
        bottomNavigationView = view.findViewById(R.id.bottom_navigation_employee);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

}
