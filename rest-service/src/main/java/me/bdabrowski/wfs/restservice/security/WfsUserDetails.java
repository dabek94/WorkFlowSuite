package me.bdabrowski.wfs.restservice.security;

import me.bdabrowski.wfs.restservice.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WfsUserDetails implements UserDetails {

    private String userEmail;
    private String userPassword;
    private List<GrantedAuthority> authorities;

    public WfsUserDetails(User user){
        this.userEmail = user.getEmail();
        this.userPassword = user.getPassword();
        this.authorities = Arrays.stream(
                user.getUserType().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        authorities.forEach(System.out::print);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
