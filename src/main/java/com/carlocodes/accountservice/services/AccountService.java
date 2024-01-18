package com.carlocodes.accountservice.services;

import com.carlocodes.accountservice.entities.Account;
import com.carlocodes.accountservice.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String name) throws Exception {
        try {
            Account account = new Account();
            account.setName(name);
            accountRepository.save(account);
        } catch (Exception e) {
            throw new Exception(String.format("Create account failed for name: %s due to: %s",
                    name, e.getMessage()), e);
        }
    }
}
