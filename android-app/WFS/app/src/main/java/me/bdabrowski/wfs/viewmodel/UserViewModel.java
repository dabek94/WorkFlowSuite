package me.bdabrowski.wfs.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import me.bdabrowski.wfs.service.repository.UserRepository;
import me.bdabrowski.wfs.service.model.User;

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> mApplicationUser;
    private UserRepository userRepository;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if (mApplicationUser != null) {
            return;
        }
        userRepository = UserRepository.getInstance();
    }

    //get user from MutableLiveData object
    public LiveData<User> getUser() {
        return mApplicationUser;
    }

    //Get user from rest service
    public LiveData<User> getUser(String email, String password) {
        mApplicationUser = userRepository.getUser(email, password);
        return mApplicationUser;    }

    public LiveData<User> addNewUser(User user) {
        mApplicationUser = userRepository.createUser(user);
        return mApplicationUser;
    }
    public LiveData<User> updateEmail(User user, Long id){
        mApplicationUser = userRepository.updateEmail(user, id);
        return mApplicationUser;
    }
    public LiveData<User> updatePassword(User user, Long id){
        mApplicationUser = userRepository.updatePassword(user, id);
        return mApplicationUser;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }

}
