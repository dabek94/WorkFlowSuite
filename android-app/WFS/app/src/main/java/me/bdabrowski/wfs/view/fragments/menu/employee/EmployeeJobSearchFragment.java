package me.bdabrowski.wfs.view.fragments.menu.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.Company.JobOpenings;
import me.bdabrowski.wfs.viewmodel.CompanyViewModel;

public class EmployeeJobSearchFragment extends Fragment implements View.OnClickListener {

    private EditText jobSearchBox;
    private CompanyViewModel companyViewModel;
    private RecyclerView recyclerView;
    private JobAdapter jobAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_btm_nav_employee_job_search, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        companyViewModel = new ViewModelProvider(getActivity()).get( CompanyViewModel.class);
        jobSearchBox = view.findViewById(R.id.job_search_box);
        jobSearchBox.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.job_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<JobOpenings> jobOpeningsList = new ArrayList<>();

        companyViewModel.getJobOpenings().observe(getActivity(), jobOpenings -> {
            if(jobOpenings == null){
                jobAdapter = new JobAdapter(getContext(), jobOpeningsList);

            }
            else if(jobOpenings.size() == 0){
                jobAdapter = new JobAdapter(getContext(), jobOpeningsList);
            }
            else{
                jobAdapter = new JobAdapter(getContext(), jobOpenings);
            }
            recyclerView.setAdapter(jobAdapter);
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.job_search_box:
                Toast.makeText(getContext(), jobSearchBox.getText(), Toast.LENGTH_LONG).show();
                break;
        }
    }
}
