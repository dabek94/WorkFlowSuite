package me.bdabrowski.wfs.service.repository;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import me.bdabrowski.wfs.service.model.Company;
import me.bdabrowski.wfs.service.model.JobOpening;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class CompanyRepository {

    private static CompanyRepository companyRepository;
    private CompanyAPI companyAPI;


    public static CompanyRepository getInstance(){
        if(companyRepository == null){
            companyRepository = new CompanyRepository();
        }
        return companyRepository;
    }

    private CompanyRepository(){
        companyAPI = RetrofitService.createService(CompanyAPI.class);
    }

    public MutableLiveData<Company> getCompany(@NotNull ("id") Long id){
        MutableLiveData<Company> company = new MutableLiveData<>();
        companyAPI.getCompany(id).enqueue(new Callback<Company>() {
            @Override
            public void onResponse(Call<Company> call, Response<Company> response) {
                if(response.isSuccessful()){
                    company.setValue(response.body());
                    return;
                }
                company.setValue(new Company());
            }
            @Override
            public void onFailure(Call<Company> call, Throwable t) {
                company.setValue(null);
            }
        });
        return company;
    }
    public MutableLiveData<List<JobOpening>> getAllJobOpenings(){
        MutableLiveData<List<JobOpening>> jobs = new MutableLiveData<>();
        companyAPI.getJobOpenings().enqueue(new Callback<List<JobOpening>>() {
            @Override
            public void onResponse(Call<List<JobOpening>> call, Response<List<JobOpening>> response) {
                if(response.isSuccessful()){
                    jobs.setValue(response.body());
                    return;
                }
                jobs.setValue(new ArrayList<>());
            }
            @Override
            public void onFailure(Call<List<JobOpening>> call, Throwable t) {
                jobs.setValue(null);
            }
        });
        return jobs;
    }
    public MutableLiveData<List<JobOpening>> getJobOpeningsByPhrase(String phrase){
        MutableLiveData<List<JobOpening>> jobs = new MutableLiveData<>();
        companyAPI.getJobOpeningsByPhrase(phrase).enqueue(new Callback<List<JobOpening>>() {
            @Override
            public void onResponse(Call<List<JobOpening>> call, Response<List<JobOpening>> response) {
                if(response.isSuccessful()){
                    jobs.setValue(response.body());
                    return;
                }
                jobs.setValue(new ArrayList<>());
            }

            @Override
            public void onFailure(Call<List<JobOpening>> call, Throwable t) {
                jobs.setValue(null);
            }
        });
        return jobs;
    }
}
