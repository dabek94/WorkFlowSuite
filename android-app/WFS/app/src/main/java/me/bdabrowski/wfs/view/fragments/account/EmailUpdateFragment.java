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

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmailUpdateFragment extends Fragment implements View.OnClickListener {

    private UserViewModel userViewModel;
    private EditText mNewEmail, mNewEmailReenter;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        return inflater.inflate(R.layout.fragment_update_email, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        navController = Navigation.findNavController(view);
        mNewEmail = view.findViewById(R.id.editText_update_email);
        mNewEmailReenter = view.findViewById(R.id.editText_update_email_reenter);
        view.findViewById(R.id.update_email_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String updatedEmail = mNewEmail.getText().toString();
        String updatedEmailReInput = mNewEmailReenter.getText().toString();

        if(isEmailsMatching(updatedEmail, updatedEmailReInput)){
            User updatedUser = userViewModel.getUser().getValue();
            updatedUser.setEmail(updatedEmail);
            userViewModel.updateEmail(updatedUser, updatedUser.getId()).observe(getActivity(), user -> {
                if(user.getEmail().equalsIgnoreCase(updatedEmail)){
                    Toast.makeText(getContext(), "Email updated", Toast.LENGTH_LONG).show();
                    navController.navigate(R.id.action_emailUpdate_to_accountIndex);
                }else {
                    Toast.makeText(getContext(), "An error occured", Toast.LENGTH_LONG).show();
                }
            });
        }
        else {
            Toast.makeText(getContext(), "Emails are not matching", Toast.LENGTH_LONG).show();
        }

    }

    private boolean isEmailsMatching(String first,String second){
        if(first.equals(second)){
            return true;
        }
        return false;
    }
}
