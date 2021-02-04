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

import java.io.Serializable;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.Address;
import me.bdabrowski.wfs.service.model.Company;
import me.bdabrowski.wfs.service.model.User;

import static me.bdabrowski.wfs.view.fragments.registration.RegisterFragment.NEW_USER_ARG;

public class UserDetailsFragment extends Fragment implements View.OnClickListener {

    private EditText mName, mStreet, mCity, mCountry;
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
        mName = view.findViewById(R.id.newCompanyName);
        mStreet = view.findViewById(R.id.newCompanyStreet);
        mCity = view.findViewById(R.id.newCompanyCity);
        mCountry = view.findViewById(R.id.newCompanyCountry);

        view.findViewById(R.id.newUserSubmit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        navController.navigate(R.id.action_userPersonalInfo_to_newEmployeeWelcome, createUserBundle());
    }

    private Bundle createUserBundle(){
        Company company = new Company();
        User user = (User) getArguments().get(NEW_USER_ARG);
        company.setName(mName.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putSerializable(NEW_USER_ARG, (Serializable) user);
        return bundle;
    }
}
