package org.quecode.backoffice.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quecode.backoffice.common.contants.ErrorCode;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        log.info("authenticate() called with: auth = [" + auth + "]");

        String username = auth.getName();
        String password = auth.getCredentials().toString();

        CustomUserDetails user = (CustomUserDetails) customUserDetailsService.loadUserByUsername(username);

        log.info("authenticate() user = " + user.toString());

        if(!password.equals(user.getPassword())){
            throw new BadCredentialsException(ErrorCode.USERNAME_OR_PASSWORD_NOT_FOUND_EXCEPTION.getMessage());
        }

        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
