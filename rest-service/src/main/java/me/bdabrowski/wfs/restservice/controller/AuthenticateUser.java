package me.bdabrowski.wfs.restservice.controller;

import me.bdabrowski.wfs.restservice.security.jwt.AuthenticateRequest;
import me.bdabrowski.wfs.restservice.security.WfsUserDetailsService;
import me.bdabrowski.wfs.restservice.security.jwt.AuthenticationResponse;
import me.bdabrowski.wfs.restservice.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateUser {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private WfsUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping()
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(), authenticateRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect credentials", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getEmail());
        final String jwt =jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
