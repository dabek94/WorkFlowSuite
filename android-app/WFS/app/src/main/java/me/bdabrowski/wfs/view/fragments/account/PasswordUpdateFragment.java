package me.bdabrowski.wfs.view.fragments.account;

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

import java.util.Comparator;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class PasswordUpdateFragment extends Fragment implements View.OnClickListener {

    private UserViewModel userViewModel;
    private EditText mNewPassword, mNewPasswordReenter;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_update_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        mNewPassword = view.findViewById(R.id.editText_update_password);
        mNewPasswordReenter = view.findViewById(R.id.editText_update_password_reenter);
        view.findViewById(R.id.button_action_update_password).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String updatedPassword = mNewPassword.getText().toString();
        String updatedPasswordReenter = mNewPasswordReenter.getText().toString();

        if (isPasswordMatching(updatedPassword, updatedPasswordReenter)) {
            User updatingUser = userViewModel.getUser().getValue();
            updatingUser.setPassword(updatedPassword);
            userViewModel.updatePassword(updatingUser, updatingUser.getId())
                    .observe(getActivity(), user -> {
                        if (user.getPassword().equalsIgnoreCase(updatedPassword)) {
                            Toast.makeText(getContext(), "Password updated", Toast.LENGTH_LONG).show();
                            navController.navigate(R.id.action_passwordUpdateFragment_to_accountIndex);
                        } else {
                            Toast.makeText(getContext(), "An error occured", Toast.LENGTH_LONG).show();
                        }
                    });
        } else {
            Toast.makeText(getContext(), "Emails are not matching", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isPasswordMatching(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        return false;
    }

}
