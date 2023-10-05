package com.example.demo.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

public class UserAuthorityUtils {

    public static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils
            .createAuthorityList("ROLE_ADMIN", "ROLE_USER");

    public static final List<GrantedAuthority> USER_ROLES = AuthorityUtils
            .createAuthorityList("ROLE_USER");

}
