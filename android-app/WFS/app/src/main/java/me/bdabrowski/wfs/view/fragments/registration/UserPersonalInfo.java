package me.bdabrowski.wfs.view.fragments.registration;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;

public class UserPersonalInfo extends Fragment {

    private static final String USER_PERSONAL_INFO_ARG =
            "me.bdabrowski.wfs.view.fragment.UserPersonalInfo";

    public static UserPersonalInfo newInstance(User user) {
        Bundle args = new Bundle();
        args.putSerializable(USER_PERSONAL_INFO_ARG, user);
        UserPersonalInfo fragment = new UserPersonalInfo();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        View view = inflater.inflate(R.layout.user_personal_info, container, false);

        return view;
    }


}
