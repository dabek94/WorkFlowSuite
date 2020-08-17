package me.bdabrowski.wfs.restservice.security;

import me.bdabrowski.wfs.restservice.model.User;
import me.bdabrowski.wfs.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WfsUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findUserByEmail(userEmail);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found :" + userEmail));
        return user.map(WfsUserDetails::new).get();
    }
}
