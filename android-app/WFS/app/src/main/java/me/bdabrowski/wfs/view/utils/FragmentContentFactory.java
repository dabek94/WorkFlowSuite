package me.bdabrowski.wfs.view.utils;

import androidx.fragment.app.Fragment;

import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.view.fragments.Login;
import me.bdabrowski.wfs.view.fragments.menu.employee.EmployeeJobInterest;
import me.bdabrowski.wfs.view.fragments.menu.employee.EmployeeMenuBody;
import me.bdabrowski.wfs.view.fragments.menu.employee.NewEmployeeWelcome;

public class FragmentContentFactory {

    public static Fragment createEmployeeMenuBody(User user){
        if(user.isUserEmployed()){
            return new EmployeeMenuBody();
        } else {
            return new EmployeeJobInterest();
        }
    }



}
