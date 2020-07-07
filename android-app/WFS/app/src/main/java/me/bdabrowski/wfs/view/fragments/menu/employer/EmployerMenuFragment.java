package me.bdabrowski.wfs.view.fragments.menu.employer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployerMenuFragment extends Fragment {

    private UserViewModel userViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employer_menu, container, false);
        return view;
    }
}