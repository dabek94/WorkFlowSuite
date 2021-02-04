package me.bdabrowski.wfs.view.fragments.registration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import androidx.fragment.app.Fragment
import me.bdabrowski.wfs.R
import me.bdabrowski.wfs.viewmodel.RegisterUserViewModel

class RegisterFragment : Fragment(){

    private val registrationViewModel by navGraphViewModels<RegisterUserViewModel>(R.id.registration_nav_graph);

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}