package me.bdabrowski.wfs.view.fragments.menu.employee.home;

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
import me.bdabrowski.wfs.databinding.FragmentEmployeeHomeBinding;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployeeHomeFragment extends Fragment {


    private UserViewModel userViewModel;
    private FragmentEmployeeHomeBinding homeBinding;
    private ImageButton profilePicture;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_employee_home, container, false);
        homeBinding.setUser(userViewModel.getUser().getValue());


        View view = homeBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        profilePicture = view.findViewById(R.id.profile_picture);
        profilePicture.setOnClickListener(v -> {
            navController.navigate(R.id.action_employee_home_to_account);
        });
    }
}
