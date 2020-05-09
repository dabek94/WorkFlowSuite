package me.bdabrowski.wfs.view.activity;

import androidx.fragment.app.Fragment;

import me.bdabrowski.wfs.view.fragments.Index;
import me.bdabrowski.wfs.viewmodel.UserViewModel;

public class MainActivity extends PrimaryFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new Index();
    }

}
