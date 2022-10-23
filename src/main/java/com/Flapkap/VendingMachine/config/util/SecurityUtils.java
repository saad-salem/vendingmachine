package com.Flapkap.VendingMachine.config.util;

import com.Flapkap.VendingMachine.user.dto.TokenUser;
import com.Flapkap.VendingMachine.user.dto.UserDetailsDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    static public TokenUser getTokenUser() {
        UsernamePasswordAuthenticationToken tokenUser = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsDto userDetails = (UserDetailsDto) tokenUser.getPrincipal();
        return new TokenUser(userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getRole().toString());
    }
}
