package com.tri.leksono.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by tri on 5/14/16.
 */
@Component
public class UserAuth extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    AkunDetailService akunDetailService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
        if(token.getCredentials() == null){
            throw new BadCredentialsException("Ga bisa masuk ");
        }
    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {

        return akunDetailService.loadUserByUsername(userName);
    }
}
