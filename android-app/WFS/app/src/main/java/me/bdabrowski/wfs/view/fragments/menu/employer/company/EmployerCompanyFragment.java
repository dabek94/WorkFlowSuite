package me.bdabrowski.wfs.view.fragments.menu.employer.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployerCompanyFragment extends Fragment implements View.OnClickListener{

    private UserViewModel userViewModel;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        int viewId = createCompanyViewId(userViewModel.getUser().getValue());
        return inflater.inflate(viewId, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.button_employer_company_create).setOnClickListener(this);
    }

    private int createCompanyViewId(User user) {
        if (user.isUserEmployed()) {
            return R.layout.fragment_employer_company;
        } else {
            return R.layout.fragment_employer_company_none;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_employer_company_create:
                navController.navigate(R.id.action_employer_company_to_companyCreatorFragment);
                break;
        }
    }
}
