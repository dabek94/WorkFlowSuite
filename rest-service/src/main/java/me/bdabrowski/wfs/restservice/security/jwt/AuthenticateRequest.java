package me.bdabrowski.wfs.restservice.security.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthenticateRequest {

    private String email;
    private String password;

    public AuthenticateRequest(){}
    public AuthenticateRequest(String email, String password){
        this.email = email;
        this.password = password;
    }
    
}
