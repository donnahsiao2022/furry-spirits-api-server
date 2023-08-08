package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void save(Account account) {
        accountRepository.save(account);
    }

    public List<Account> getAccoutList() {
        return accountRepository.findAll();
    }

    public Account findAccountById(int accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public void deleteAccount(Account account) {
        if (account != null) {
            accountRepository.delete(account);
        }
    }

}
