package me.bdabrowski.wfs.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private UserViewModel userViewModel;
    private NavController navController;
    private EditText mUserName;
    private EditText mUserPassword;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        navController = Navigation.findNavController(view);
        mUserName = view.findViewById(R.id.userEmail);
        mUserPassword = view.findViewById(R.id.userPassword);

        view.findViewById(R.id.confirmLogin).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String login = mUserName.getText().toString();
        String password = mUserPassword.getText().toString();

        userViewModel.getUser(login, password).observe(getActivity(), user-> {
            //error with connection
            if (user == null) {
                Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_LONG).show();
                return;
            }
            //given information doesn't match remote database
            else if (user.getEmail() == null) {
                Toast.makeText(getContext(), "Invalid information", Toast.LENGTH_LONG).show();
                return;
            }
            //if success
            else {
                if (user.getUserType().equalsIgnoreCase("employee")) {
                    navController.navigate(R.id.action_login_to_employeeMainMenu);
                }
                else {
                    navController.navigate(R.id.action_login_to_employerMainMenu);
                }
                return;
            }
        });
    }
}
