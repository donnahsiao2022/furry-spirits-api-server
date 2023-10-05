package com.example.demo.config.context;

import com.example.demo.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailContext implements UserDetails {

    private final Account account;
    private final Collection<? extends GrantedAuthority> grantedAuthorityList;

    public UserDetailContext(Account account, Collection<? extends GrantedAuthority> grantedAuthorityList) {
        this.account = account;
        this.grantedAuthorityList = grantedAuthorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getName();
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
