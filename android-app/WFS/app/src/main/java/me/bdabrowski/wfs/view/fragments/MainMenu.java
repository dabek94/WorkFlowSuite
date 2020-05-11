package me.bdabrowski.wfs.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class MainMenu extends Fragment {

    private UserViewModel userViewModel;

    private TextView mHeaderUserName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu, container, false);

        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);

        mHeaderUserName = view.findViewById(R.id.header_userName);

        String userName = userViewModel.getUser().getValue().getUserDetails().getFirstName();
        mHeaderUserName.setText("Welcome " + userName);


        return view;
    }
}
