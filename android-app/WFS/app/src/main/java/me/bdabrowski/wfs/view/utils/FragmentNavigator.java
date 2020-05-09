package me.bdabrowski.wfs.view.utils;

import androidx.fragment.app.Fragment;
import me.bdabrowski.wfs.R;

public class FragmentNavigator {

    private static FragmentNavigator instance;

    private FragmentNavigator() {
    }

    public static FragmentNavigator get() {
        if (instance == null) {
            instance = new FragmentNavigator();
        }
        return instance;
    }

    public void changeView(Fragment fragment, Object newFragment) {
        fragment.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, (Fragment) newFragment)
                .commit();

    }

    public void changeViewBackStack(Fragment fragment, Object newFragment) {
        fragment.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, (Fragment) newFragment)
                .addToBackStack(null)
                .commit();
    }
}
