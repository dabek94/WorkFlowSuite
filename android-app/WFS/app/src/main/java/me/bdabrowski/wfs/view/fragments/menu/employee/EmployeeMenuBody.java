package me.bdabrowski.wfs.view.fragments.menu.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.EmployeeMenuBodyBinding;
import me.bdabrowski.wfs.view.fragments.account.AccountContainer;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployeeMenuBody extends Fragment {


    private UserViewModel userViewModel;
    private EmployeeMenuBodyBinding employeeMenuBodyBinding;
    private ImageButton profilePicture;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        employeeMenuBodyBinding = DataBindingUtil.inflate(inflater, R.layout.employee_menu_body, container, false);
        employeeMenuBodyBinding.setUser(userViewModel.getUser().getValue());


        View view = employeeMenuBodyBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        profilePicture = view.findViewById(R.id.profile_picture);
        profilePicture.setOnClickListener(v -> {
            navController.navigate(R.id.action_employee_home_to_accountContainer2);
        });
    }
}
