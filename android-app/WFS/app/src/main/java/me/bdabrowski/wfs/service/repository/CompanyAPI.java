package me.bdabrowski.wfs.service.repository;

import me.bdabrowski.wfs.service.model.Company;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CompanyAPI {

    @GET("company/{companyName}")
    Call<Company> getCompany(@Path("companyName") String companyName);

    @GET("company/{userId}")
    Call<Company> getCompanyByUserId(@Path("userId") int userId);

    @POST("company/")
    Call<Boolean> createCompany(@Body Company company);


}
