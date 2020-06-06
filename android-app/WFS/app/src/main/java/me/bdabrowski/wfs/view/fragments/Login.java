package me.bdabrowski.wfs.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.view.fragments.menu.employee.EmployeeMainMenu;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class Login extends Fragment {
    private UserViewModel userViewModel;

    private EditText mUserName;
    private EditText mUserPassword;
    private Button mSignIn;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        View loginView = inflater.inflate(R.layout.login_fragment, container, false);
        mUserName = loginView.findViewById(R.id.userEmail);
        mUserPassword = loginView.findViewById(R.id.userPassword);

        mSignIn = loginView.findViewById(R.id.confirmLogin);
        mSignIn.setOnClickListener(v -> {
            String login = mUserName.getText().toString();
            String password = mUserPassword.getText().toString();

            userViewModel.getUser(login, password).observe(getActivity(), user -> {

                if (user == null) {
                    Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_LONG).show();
                    return;
                } else if (login.equals(user.getEmail()) && password.equals(user.getPassword())) {

                    FragmentNavigator.get().changeView(this, new EmployeeMainMenu());

                    Toast.makeText(getContext(), "OK", Toast.LENGTH_LONG).show();
                    return;
                }
                //given information doesn't match remote database
                else if (user.getEmail() == null) {
                    Toast.makeText(getContext(), "Invalid information", Toast.LENGTH_LONG).show();
                    return;
                }
            });
        });

        return loginView;
    }
}
