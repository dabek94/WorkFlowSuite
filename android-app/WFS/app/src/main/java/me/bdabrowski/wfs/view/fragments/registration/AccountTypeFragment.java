package me.bdabrowski.wfs.view.fragments.registration;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

import static me.bdabrowski.wfs.view.fragments.registration.RegisterFragment.NEW_USER_ARG;

public class AccountTypeFragment extends Fragment implements View.OnClickListener {

    private UserViewModel userViewModel;
    private NavController navController;

    private User newUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_register_account_type, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newUser = (User) getArguments().getSerializable(NEW_USER_ARG);
        navController = Navigation.findNavController(view);
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);

        view.findViewById(R.id.registerAsEmployer).setOnClickListener(this);
        view.findViewById(R.id.registerAsEmployee).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerAsEmployee:
                newUser.setUserType("employee");
                userViewModel.addNewUser(newUser).observe(getActivity(), user -> {
                    navController.navigate(R.id.action_accountType_to_newEmployeeWelcome);
                });
                break;
            case R.id.registerAsEmployer:
                newUser.setUserType("employer");
                userViewModel.addNewUser(newUser).observe(getActivity(), user -> {
                    navController.navigate(R.id.action_accountType_to_newEmployerFragment);
                });
                break;
        }
    }
}
