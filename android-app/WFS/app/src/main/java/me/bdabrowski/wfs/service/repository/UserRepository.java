package me.bdabrowski.wfs.service.repository;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import me.bdabrowski.wfs.service.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static UserRepository userRepository;
    private UserAPI userAPI;

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    private UserRepository() {
        //TODO if user exists in the saved state
        userAPI = RetrofitService.createService(UserAPI.class);
    }

    public MutableLiveData<User> getUser(@NotNull String email, @NotNull String password) {
        MutableLiveData<User> user = new MutableLiveData<>();
        userAPI.getUser(email, password).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user.setValue(response.body());
                    return;
                }
                user.setValue(new User());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                user.setValue(null);
            }
        });
        return user;
    }

    public MutableLiveData<User> createUser(@NotNull User newUser) {
        MutableLiveData<User> user = new MutableLiveData<>();
        userAPI.createUser(newUser).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    user.setValue(new User());
                }
                user.setValue(newUser);
                return;
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                user.setValue(null);
            }
        });
        return user;
    }

    public MutableLiveData<User> updateEmail(@NotNull User updatedUser, @NotNull Long id){
        MutableLiveData<User> user = new MutableLiveData<>();
        userAPI.updateEmail(updatedUser, id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    user.setValue(new User());
                }
                user.setValue(updatedUser);
                return;
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                user.setValue(null);
            }
        });
        return user;
    }

}
