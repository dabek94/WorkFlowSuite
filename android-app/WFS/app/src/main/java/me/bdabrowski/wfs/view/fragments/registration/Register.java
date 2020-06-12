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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.view.fragments.Index;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class Register extends Fragment implements View.OnClickListener {

    private EditText mNewUserEmail, mNewUserPassword, mNewUserRePassword;
    private CheckBox mToSAgreement;
    private ProgressBar mLoadingBar;
    private TextView mCancelRegistration;
    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
        return inflater.inflate(R.layout.register_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        instantiateComponents(view);
        navController = Navigation.findNavController(view);
    }

    private void instantiateComponents(View view) {
        //form
        mNewUserEmail = view.findViewById(R.id.newUserEmail);
        mNewUserPassword = view.findViewById(R.id.newUserPassword);
        mNewUserRePassword = view.findViewById(R.id.newUserPasswordReentered);
        mToSAgreement = view.findViewById(R.id.ToSCheck);
        mLoadingBar = view.findViewById(R.id.loading_bar);

        //action buttons
        view.findViewById(R.id.cancel_registration).setOnClickListener(this);
        view.findViewById(R.id.newUserSubmit).setOnClickListener(this);
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

    private Bundle createUserBundle() {
        String email = mNewUserEmail.getText().toString();
        String password = mNewUserPassword.getText().toString();
        User user = new User(email, password);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        return bundle;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.newUserSubmit:
                if(isFormConditionsMet()){
                    navController.navigate(R.id.action_register_to_userPersonalInfo, createUserBundle());
                    break;
                }
            case R.id.cancel_registration:
                //tood
                break;
        }
    }
}
