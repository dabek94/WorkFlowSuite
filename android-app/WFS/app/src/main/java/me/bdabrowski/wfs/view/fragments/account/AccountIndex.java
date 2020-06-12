package me.bdabrowski.wfs.view.fragments.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.AccountSettingsIndexBinding;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class AccountIndex extends Fragment implements View.OnClickListener {

    private AccountSettingsIndexBinding accountSettingsIndexBinding;
    private UserViewModel userViewModel;
    private NavController navController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        accountSettingsIndexBinding = DataBindingUtil.inflate(inflater, R.layout.account_settings_index, container, false);
        accountSettingsIndexBinding.setUser(userViewModel.getUser().getValue());
        return accountSettingsIndexBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.edit_email).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_email:
                navController.navigate(R.id.action_accountIndex_to_emailUpdate);
        }
    }
}
