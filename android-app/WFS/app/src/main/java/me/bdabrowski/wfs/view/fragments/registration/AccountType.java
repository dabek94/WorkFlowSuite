package me.bdabrowski.wfs.view.fragments.registration;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.view.fragments.MainMenu;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class AccountType extends Fragment {

    private Button mEmployer, mEmployee;
    private UserViewModel userViewModel;

    private static final String ACCOUNT_TYPE_USER_ARG=
            "me.bdabrowski.wfs.view.fragments.registration";

    protected static AccountType newInstance(User user){
        Bundle args = new Bundle();
        args.putSerializable(ACCOUNT_TYPE_USER_ARG, user);
        AccountType fragment = new AccountType();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        User newUser = (User) getArguments().getSerializable(ACCOUNT_TYPE_USER_ARG);

        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);

        View view = inflater.inflate(R.layout.user_type_selector, container, false);
        mEmployer = view.findViewById(R.id.registerAsEmployer);
        System.out.println(newUser.getEmail());
        mEmployer.setOnClickListener(v -> {
            newUser.setUserType("unemployeed");

            userViewModel.addNewUser(newUser).observe(getActivity(), user -> {
                System.out.println(newUser);
                FragmentNavigator.get().changeView(this, new MainMenu());
            });
        });

        mEmployee = view.findViewById(R.id.registerAsEmployee);
        mEmployee.setOnClickListener(v ->{
            newUser.setUserType("owner");

            String json = new Gson().toJson(newUser);
            System.out.println(json);
            userViewModel.addNewUser(newUser).observe(getActivity(), user -> {
                FragmentNavigator.get().changeView(this, new MainMenu());
            });
        });

        return view;

    }
}
