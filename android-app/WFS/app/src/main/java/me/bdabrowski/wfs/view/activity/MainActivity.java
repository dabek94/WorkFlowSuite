package me.bdabrowski.wfs.view.activity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.viewmodel.CompanyViewModel;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private CompanyViewModel companyViewModel;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewModels();
        setFullScreen();
        setContentView(R.layout.activity_main);
    }

    private void setViewModels(){
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.init();

        companyViewModel = new ViewModelProvider(this).get(CompanyViewModel.class);
        companyViewModel.init();
    }

    private void setFullScreen(){
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
