package me.bdabrowski.wfs.view.fragments.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.EmailUpdateBinding;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmailUpdate extends Fragment implements View.OnClickListener {

    private EmailUpdateBinding emailUpdateBinding;
    private UserViewModel userViewModel;
    private EditText newEmail, newEmailRe_input;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        emailUpdateBinding = DataBindingUtil.inflate(inflater, R.layout.email_update, container, false);
        emailUpdateBinding.setUser(userViewModel.getUser().getValue());
        return emailUpdateBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.update_email_btn).setOnClickListener(this);
        navController = Navigation.findNavController(view);
        newEmail = view.findViewById(R.id.editTextTextEmailAddress2);
        newEmailRe_input = view.findViewById(R.id.editTextTextEmailAddress3);
    }

    @Override
    public void onClick(View v) {
        String updatedEmail = newEmail.getText().toString();
        String updatedEmailReInput = newEmailRe_input.getText().toString();

        if(isEmailsMatching(updatedEmail, updatedEmailReInput)){
            User updatedUser = userViewModel.getUser().getValue();
            updatedUser.setEmail(updatedEmail);
            userViewModel.updateEmail(updatedUser, updatedUser.getId()).observe(getActivity(), user -> {
                if(user.getEmail().equalsIgnoreCase(updatedEmail)){
                    Toast.makeText(getContext(), "Email updated", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getContext(), "An error occured", Toast.LENGTH_LONG).show();
                }
                navController.navigate(R.id.action_emailUpdate_to_accountIndex);
            });

        }else {
            Toast.makeText(getContext(), "Emails are not matching", Toast.LENGTH_LONG).show();
        }

    }

    private boolean isEmailsMatching(String emailOne,String emailTwo){
        if(emailOne.equals(emailOne)){
            return true;
        }
        return false;
    }



}
