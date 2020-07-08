package me.bdabrowski.wfs.view.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.viewmodel.CompanyViewModel;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private static UserViewModel userViewModel;
    private static CompanyViewModel companyViewModel;
    private static NavController navController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewModels();
        setFullScreen();
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        View view = findViewById(R.id.nav_host_fragment);

        setViewModels();
        navController = Navigation.findNavController(view);
        if(userViewModel.getUser().getValue() == null){
            if(userViewModel.getUser().getValue().getUserType().equals("employee")){
                navController.navigate(R.id.action_index_to_employee_menu);
            } else {
                navController.navigate(R.id.action_index_to_employer_menu);
            }
        }
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

    public static UserViewModel getUserViewModel() {
        return userViewModel;
    }
    public static CompanyViewModel getCompanyViewModel(){
        return companyViewModel;
    }

}
