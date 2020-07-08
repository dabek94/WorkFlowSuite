package me.bdabrowski.wfs.view.fragments.menu.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.FragmentNewEmployeeBinding;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class NewEmployeeFragment extends Fragment implements View.OnClickListener {

    UserViewModel userViewModel;
    FragmentNewEmployeeBinding newEmployeeBinding;
    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        newEmployeeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_employee, container, false);
        User _user = userViewModel.getUser().getValue();
        newEmployeeBinding.setUser(_user);
        View view = newEmployeeBinding.getRoot();
        view.findViewById(R.id.welcome_submit).setOnClickListener(this);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onClick(View v) {
        navController.navigate(R.id.action_newEmployeeWelcome_to_employeeMainMenu);
    }
}
