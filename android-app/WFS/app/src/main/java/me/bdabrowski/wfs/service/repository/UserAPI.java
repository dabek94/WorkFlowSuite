package me.bdabrowski.wfs.service.repository;

import java.util.List;
import java.util.UUID;

import me.bdabrowski.wfs.service.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserAPI {

    @GET("users/duplicate/{email}")
    Call<Boolean> isEmailDuplicate(@Path("email") String email);

    @POST("users/")
    Call<User> createUser(@Body User user);

    @POST("users/{email}/{password}")
    Call<User> getUser(@Path("email") String email, @Path("password") String password);

    @POST("users/{companyId}")
    Call<List<User>> getUsersByCompanyUUID(@Path("companyId")UUID uuid);

    @GET("users/delete")
    Call<User> deleteUser(@Body User user);

    @PUT("users/update/email/{id}")
    Call<User> updateEmail(@Body User user, @Path("id")Long id);

    @PUT("users/update/password/{id}")
    Call<User> updatePassword(@Body User user, @Path("id")Long id);
}
