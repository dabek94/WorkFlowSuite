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

public class AccountTypeFragment extends Fragment implements View.OnClickListener {

    private UserViewModel userViewModel;
    private NavController navController;

    private User userBundleArg;

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
        userBundleArg = (User) getArguments().getSerializable("user");
        navController = Navigation.findNavController(view);
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);

        view.findViewById(R.id.registerAsEmployer).setOnClickListener(this);
        view.findViewById(R.id.registerAsEmployee).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerAsEmployer:
                userBundleArg.setUserType("employer");
                userBundleArg.setCompanyId(0L);
                break;
            case R.id.registerAsEmployee:
                //TODO Work on owner will start after user is finished
                userBundleArg.setUserType("employee");
                userBundleArg.setCompanyId(0L);
                break;
        }
        userViewModel.addNewUser(userBundleArg).observe(getActivity(), user -> {
            navController.navigate(R.id.action_accountType_to_newEmployeeWelcome);
        });
    }
}
