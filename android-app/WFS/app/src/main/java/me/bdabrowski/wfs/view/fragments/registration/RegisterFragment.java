package me.bdabrowski.wfs.view.fragments.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    protected static final String NEW_USER_ARG = "me.bdabrowski.wfs.view.fragments.registration";

    private EditText mNewUserEmail, mNewUserPassword, mNewUserRePassword;
    private CheckBox mToSAgreement;
    private ProgressBar mLoadingBar;
    private TextView mCancelRegistration;
    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
        return inflater.inflate(R.layout.fragment_register_core, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        instantiateComponents(view);
        navController = Navigation.findNavController(view);
    }

    private void instantiateComponents(View view) {
        //form
        mNewUserEmail = view.findViewById(R.id.editText_register_core_email);
        mNewUserPassword = view.findViewById(R.id.editText_register_core_password);
        mNewUserRePassword = view.findViewById(R.id.editText_register_core_reenter_password);
        mToSAgreement = view.findViewById(R.id.checkBox_register_core_tos);
        mLoadingBar = view.findViewById(R.id.progressBar_register_core_loading);

        //action buttons
        view.findViewById(R.id.text_register_core_cancel).setOnClickListener(this);
        view.findViewById(R.id.button_register_core_next).setOnClickListener(this);
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
        bundle.putSerializable(NEW_USER_ARG, user);
        return bundle;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_register_core_next:
                if(isFormConditionsMet()){
                    navController.navigate(R.id.action_register_to_userPersonalInfo, createUserBundle());
                    break;
                }
            case R.id.text_register_core_cancel:
                navController.navigate(R.id.action_register_to_index);
                break;
        }
    }
}
