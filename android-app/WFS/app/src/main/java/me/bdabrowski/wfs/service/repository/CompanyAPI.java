package me.bdabrowski.wfs.service.repository;

import java.util.List;

import me.bdabrowski.wfs.service.model.Company;
import me.bdabrowski.wfs.service.model.JobOpening;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 */
public interface CompanyAPI {

    @GET("companies/{id}")
    Call<Company> getCompany(@Path("id") Long id);

    @POST("company/")
    Call<Boolean> createCompany(@Body Company company);

    @GET("jobs/")
    Call<List<JobOpening>> getJobOpenings();

    @GET("jobs/{phrase}")
    Call<List<JobOpening>> getJobOpeningsByPhrase(@Path("phrase") String phrase);

}
