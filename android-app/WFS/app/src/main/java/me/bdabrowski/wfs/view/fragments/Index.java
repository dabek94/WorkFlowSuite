package me.bdabrowski.wfs.view.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.view.fragments.registration.Register;

public class Index extends Fragment implements View.OnClickListener {

    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.index_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.signUp).setOnClickListener(this);
        view.findViewById(R.id.signInTextView).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signInTextView:
                navController.navigate(R.id.action_index_to_login);
                break;
            case R.id.signUp:
                navController.navigate(R.id.action_index_to_register);
        }
    }
}