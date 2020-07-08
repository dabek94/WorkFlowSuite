package me.bdabrowski.wfs.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.bdabrowski.wfs.service.model.Company;
import me.bdabrowski.wfs.service.model.JobOpening;
import me.bdabrowski.wfs.service.repository.CompanyRepository;
import me.bdabrowski.wfs.service.repository.UserRepository;

public class CompanyViewModel extends ViewModel {

    private MutableLiveData<Company> userCompany;
    private MutableLiveData<List<JobOpening>> jobOpenings;

    private CompanyRepository companyRepository;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();


    public void init(){
        if(companyRepository != null){
            return;
        }
        companyRepository = CompanyRepository.getInstance();
    }

    //TODO NullCheck
    public LiveData<Company> getCompany(){
        return userCompany;
    }

    public LiveData<Company> getCompany(Long id){
        userCompany = companyRepository.getCompany(id);
        return userCompany;
    }

    public LiveData<List<JobOpening>> getJobOpenings(){
        jobOpenings = companyRepository.getAllJobOpenings();
        return jobOpenings;
    }
    public LiveData<List<JobOpening>> getJobOpeningsByPhrase(String phrase){
        jobOpenings = companyRepository.getJobOpeningsByPhrase(phrase);
        return jobOpenings;
    }
}
