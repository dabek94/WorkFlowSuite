package me.bdabrowski.wfs.view.fragments.menu.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.NewUserWelcomeBinding;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class NewEmployeeWelcome extends Fragment {

    UserViewModel userViewModel;
    NewUserWelcomeBinding userWelcomeBinding;

    private Button mStartButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        userWelcomeBinding = DataBindingUtil.inflate(inflater, R.layout.new_user_welcome, container, false);
        User _user = userViewModel.getUser().getValue();
        userWelcomeBinding.setUser(_user);
        View view = userWelcomeBinding.getRoot();
        mStartButton = view.findViewById(R.id.welcome_submit);
        mStartButton.setOnClickListener((v -> {
            FragmentNavigator.get().changeView(this, new EmployeeJobInterest());
        }));


        return view;
    }


}
