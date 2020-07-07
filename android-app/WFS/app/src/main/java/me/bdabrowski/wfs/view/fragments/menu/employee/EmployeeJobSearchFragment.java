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
import me.bdabrowski.wfs.view.activity.MainActivity;
import me.bdabrowski.wfs.viewmodel.CompanyViewModel;

public class EmployeeJobSearchFragment extends Fragment implements View.OnClickListener {

    private EditText jobSearchBox;
    private RecyclerView recyclerView;
    private JobAdapter jobAdapter;
    private CompanyViewModel companyViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_btm_nav_employee_job_search, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jobSearchBox = view.findViewById(R.id.job_search_box);
        jobSearchBox.setOnClickListener(this);

        companyViewModel = MainActivity.getCompanyViewModel();

        recyclerView = view.findViewById(R.id.job_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<JobOpenings> jobOpeningsList = new ArrayList<>();
        jobAdapter = new JobAdapter(getContext(), jobOpeningsList);
        recyclerView.setAdapter(jobAdapter);

        companyViewModel.getJobOpenings().observe(getActivity(), jobOpenings -> {
            if(jobOpenings == null){

            }
            else if(jobOpenings.size() == 0){
                jobAdapter.setItems(jobOpenings);
                jobAdapter.notifyDataSetChanged();
            }
            else{
                jobAdapter.setItems(jobOpenings);
                jobAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.job_search_box:
                String searedPhrase = jobSearchBox.getText().toString();
                companyViewModel.getJobOpeningsByPhrase(searedPhrase)
                        .observe(getActivity(), jobOpenings -> {
                            if(jobOpenings == null){

                            }
                            else if(jobOpenings.size() == 0){
                                jobAdapter.setItems(jobOpenings);
                                jobAdapter.notifyDataSetChanged();
                            }
                            else{
                                jobAdapter.setItems(jobOpenings);
                                jobAdapter.notifyDataSetChanged();
                            }
                });
                break;
        }
    }
}
