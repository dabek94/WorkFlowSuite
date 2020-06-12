package me.bdabrowski.wfs.view.utils;

import androidx.fragment.app.Fragment;

import me.bdabrowski.wfs.service.model.User;
import me.bdabrowski.wfs.view.fragments.menu.employee.EmployeeJobFinder;
import me.bdabrowski.wfs.view.fragments.menu.employee.EmployeeMenuBody;

public class FragmentContentFactory {

    public static Fragment createEmployeeMenuBody(User user){
        if(user.isUserEmployed()){
            return new EmployeeMenuBody();
        } else {
            return new EmployeeJobFinder();
        }
    }



}
