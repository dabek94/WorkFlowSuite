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

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.AccountSettingsBinding;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class AccountSettings extends Fragment {

    AccountSettingsBinding accountSettingsBinding;
    UserViewModel userViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        accountSettingsBinding = DataBindingUtil.inflate(
                                                 inflater, R.layout.account_settings,
                                                 container, false);
        accountSettingsBinding.setUser(userViewModel.getUser().getValue());

        View view = accountSettingsBinding.getRoot();
        return view;

    }
}
