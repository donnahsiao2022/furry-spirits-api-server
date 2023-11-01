package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {

    @Autowired
    IAccountRepository accountRepository;

    public boolean isAccountAdmin() {

        boolean isAdmin = false;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {

            isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        }

        return isAdmin;
    }

    public boolean isAccountAdminByAccountName(String accountName) {
        return accountRepository.findAccountByName(accountName).isAdmin();
    }

    public Account register(String name, String password, boolean isAdmin) {

        Account account;

        account = findAccountByName(name);
        if (account != null) {
            return null;
        }

        account = new Account();
        account.setName(name);
        account.setPassword(password);
        account.setCreateDatetime(new Date());
        account.setAdmin(isAdmin);

        accountRepository.save(account);

        return account;
    }

    public Account findAccountByName(String name) {
        return accountRepository.findAccountByName(name);
    }
}
