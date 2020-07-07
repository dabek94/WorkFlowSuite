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
import me.bdabrowski.wfs.databinding.FragmentNewUserWelcomeBinding;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class NewEmployeeWelcomeFragment extends Fragment implements View.OnClickListener {

    UserViewModel userViewModel;
    FragmentNewUserWelcomeBinding userWelcomeBinding;
    NavController navController;

    private Button mStartButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        userWelcomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_user_welcome, container, false);
        User _user = userViewModel.getUser().getValue();
        userWelcomeBinding.setUser(_user);
        View view = userWelcomeBinding.getRoot();
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
        User user = userViewModel.getUser().getValue();
        if(user.getUserType().equals("employee")){
            navController.navigate(R.id.action_newEmployeeWelcome_to_employeeMainMenu);
        } else {
            navController.navigate(R.id.action_newEmployeeWelcome_to_employerMainMenu);
        }
    }
}
