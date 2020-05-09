package me.bdabrowski.wfs.view.fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.view.fragments.registration.Register;

public class Index extends Fragment {

    private Button mSignUp;
    private TextView mSignIn;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.index_fragment, container, false);
        mSignUp = view.findViewById(R.id.signIn);
        mSignUp.setOnClickListener(v -> {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Register()).addToBackStack(null).commit();
        });

        mSignIn = view.findViewById(R.id.signInTextView);
        mSignIn.setOnClickListener(v -> {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Login()).addToBackStack(null).commit();
        });
        return view;


    }
}