package me.bdabrowski.wfs.view.fragments.registration;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.view.utils.FragmentNavigator;

public class UserPersonalInfo extends Fragment {


    private EditText mFirstName, mLastName, mAddress, mCity;
    private Button mSubmitButton;

    private static final String USER_PERSONAL_INFO_ARG
            = "me.bdabrowski.wfs.view.fragment.UserPersonalInfo";

    public static UserPersonalInfo newInstance(User user) {
        Bundle args = new Bundle();
        args.putSerializable(USER_PERSONAL_INFO_ARG, user);
        UserPersonalInfo fragment = new UserPersonalInfo();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.user_personal_info, container, false);
        User user = (User) getArguments().get(USER_PERSONAL_INFO_ARG);

        initComponents(view);
        mSubmitButton.setOnClickListener(v -> {
            User.UserDetails userDetails = new User.UserDetails();

            userDetails.setFirstName(mFirstName.getText().toString());
            userDetails.setLastName(mLastName.getText().toString());
            userDetails.setAddress(mAddress.getText().toString());
            userDetails.setCity(mCity.getText().toString());
            userDetails.setEmail(user.getEmail());
            user.setUserDetails(userDetails);
            FragmentNavigator.get().changeViewBackStack(this, AccountType.newInstance(user));
        });
        return view;
    }

    private void initComponents(View view){
        mFirstName = view.findViewById(R.id.newUserFirstName);
        mLastName = view.findViewById(R.id.newUserLastName);
        mAddress = view.findViewById(R.id.newUserAddress);
        mCity = view.findViewById(R.id.newUserCity);
        mSubmitButton = view.findViewById(R.id.newUserSubmit);
    }

}
