package me.bdabrowski.wfs.view.fragments.menu.employer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.databinding.FragmentNewEmployerBinding;
import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class NewEmployerFragment extends Fragment implements View.OnClickListener {

    UserViewModel userViewModel;
    FragmentNewEmployerBinding employerBinding;
    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        employerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_employer,
                container, false);
        User _user = userViewModel.getUser().getValue();
        employerBinding.setUser(_user);
        View view = employerBinding.getRoot();
        view.findViewById(R.id.button_new_employer_next).setOnClickListener(this);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onClick(View v) {
        navController.navigate(R.id.action_newEmployeeWelcome_to_main_menu);
    }
}
