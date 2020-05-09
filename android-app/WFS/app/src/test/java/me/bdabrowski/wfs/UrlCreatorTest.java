package me.bdabrowski.wfs;


import org.junit.Test;

import me.bdabrowski.wfs.service.utils.RESTConsts;
import me.bdabrowski.wfs.service.utils.UrlCreator;

import static me.bdabrowski.wfs.service.utils.RESTConsts.*;
import static org.junit.Assert.*;

public class UrlCreatorTest {

    @Test
    public void shouldCreateValidDefaultUsersPath(){
        UrlCreator.begin()
                .path(RESTConsts.Users.PATH)
                .create();
        String given = UrlCreator.getUrl().toString();
        assertEquals("http://192.168.0.171:9090/users", given);
    }

    @Test
    public void shouldCreateValidDefaultUsersPathWithParameters(){
        UrlCreator.begin()
                .path(RESTConsts.Users.PATH)
                .parameters("parameter1", "parameter2")
                .create();
        String given = UrlCreator.getUrl().toString();
        assertEquals("http://192.168.0.171:9090/users/parameter1/parameter2", given);
    }

    @Test
    public void shouldCreateValidHttpsUsersPath(){
        UrlCreator.begin()
                .protocol(HTTPS)
                .path(RESTConsts.Users.PATH)
                .method(GET)
                .create();
        String given = UrlCreator.getUrl().toString();
        assertEquals("https://192.168.0.171:9090/users", given);
    }


}
