package me.bdabrowski.wfs.restservice.security.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt){
        this.jwt = jwt;
    }

}
