package me.bdabrowski.wfs.view.fragments.menu.employer.job;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class EmployerJob extends Fragment {

    private UserViewModel userViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        int viewId = createJobViewId(userViewModel.getUser().getValue());

        return inflater.inflate(viewId, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    private int createJobViewId(User user) {
        if (user.isUserEmployed()) {
            return R.layout.fragment_employer_job;
        } else {
            return R.layout.fragment_employer_company_none;
        }
    }
}
