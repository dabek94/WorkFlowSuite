package me.bdabrowski.wfs.view.fragments.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.view.fragments.Index;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class Register extends Fragment {

    private EditText mNewUserEmail, mNewUserPassword, mNewUserRePassword;
    private CheckBox mToSAgreement;
    private ProgressBar mLoadingBar;
    private TextView mCancelRegistration;
    private Button mSubmitUserData;

    private UserViewModel userViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.init();

        View view = inflater.inflate(R.layout.register_fragment, container, false);
        initializeComponents(view);

        return view;
    }

    private void initializeComponents(View view) {
        //form
        mNewUserEmail = view.findViewById(R.id.newUserEmail);
        mNewUserPassword = view.findViewById(R.id.newUserPassword);
        mNewUserRePassword = view.findViewById(R.id.newUserPasswordReentered);
        mToSAgreement = view.findViewById(R.id.ToSCheck);
        mLoadingBar = view.findViewById(R.id.loading_bar);

        //action buttons
        mCancelRegistration = view.findViewById(R.id.cancel_registration);
        mCancelRegistration.setOnClickListener(v
                -> FragmentNavigator.get().changeView(this, new Index())
        );

        mSubmitUserData = view.findViewById(R.id.newUserSubmit);
        mSubmitUserData.setOnClickListener(v -> {
            if (isFormConditionsMet()) {
                User user = createUser();
                FragmentNavigator.get().changeView(this, UserPersonalInfo.newInstance(user));
            }
        });
    }

    private boolean isFormConditionsMet(){
        if (!mToSAgreement.isChecked()) {
            Toast.makeText(getContext(), "Accept Terms of Service", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (!mNewUserPassword.getText().toString().equals(mNewUserRePassword.getText().toString())) {
            Toast.makeText(getContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            return true;
        }
    }

    private User createUser() {
        String email = mNewUserEmail.getText().toString();
        String password = mNewUserPassword.getText().toString();
        User user = new User(email, password);
        return user;
    }
}
