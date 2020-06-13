package me.bdabrowski.wfs.view.activity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.viewmodel.CompanyViewModel;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public abstract class PrimaryFragmentActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private CompanyViewModel companyViewModel;

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.init();

        companyViewModel = new ViewModelProvider(this).get(CompanyViewModel.class);
        companyViewModel.init();

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        PrimaryFragmentActivity.this.displayFragment();
    }

    private void displayFragment() {
        FragmentManager fManager = getSupportFragmentManager();
        Fragment fragment = fManager.findFragmentById(R.id.nav_host_fragment);

        if (fragment == null) {
            fragment = createFragment();
            fManager.beginTransaction()
                    .add(R.id.nav_host_fragment, fragment)
                    .commit();
        } else {
            fManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
        }
    }

}
