package me.bdabrowski.wfs.view.fragments.registration;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.Address;
import me.bdabrowski.wfs.service.model.User;

public class UserDetailsFragment extends Fragment implements View.OnClickListener {

    private EditText mFirstName, mLastName, mStreet, mCity;
    private NavController navController;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_register_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        instantiateComponents(view);
        }

    private void instantiateComponents(View view){
        //form
        mFirstName = view.findViewById(R.id.newUserFirstName);
        mLastName = view.findViewById(R.id.newUserLastName);
        mStreet = view.findViewById(R.id.newUserAddress);
        mCity = view.findViewById(R.id.newUserCity);
        //submit button
        view.findViewById(R.id.newUserSubmit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        navController.navigate(R.id.action_userPersonalInfo_to_accountType, createUserBundle());
    }

    private Bundle createUserBundle(){
        User user = (User) getArguments().get("user");
        user.setFirstName(mFirstName.getText().toString());
        user.setLastName(mLastName.getText().toString());
        Address _address = new Address();
        _address.setStreet(mStreet.getText().toString());
        _address.setCity(mCity.getText().toString());
        user.setAddress(_address);

        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        return bundle;
    }
}
