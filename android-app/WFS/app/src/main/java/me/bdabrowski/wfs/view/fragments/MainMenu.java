package me.bdabrowski.wfs.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class MainMenu extends Fragment {

    private UserViewModel userViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        System.out.println(userViewModel.getUser().getValue().getEmail());
        userViewModel.getUser().observe(getActivity(), user -> {

        });
        View view = inflater.inflate(R.layout.menu, container, false);

        return view;
    }
}
