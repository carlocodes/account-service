package com.carlocodes.account_service.services;

import com.carlocodes.account_service.dtos.AccountDto;
import com.carlocodes.account_service.entities.Account;
import com.carlocodes.account_service.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public AccountDto getAccount(Long id) throws Exception {
        try {
            Account account = accountRepository.findById(id)
                    .orElseThrow(() -> new Exception("Account does not exist!"));

            // TODO: Move to another method or use a mapper
            AccountDto accountDto = new AccountDto();
            accountDto.setId(account.getId());
            accountDto.setName(account.getName());
            accountDto.setBalance(account.getBalance());

            return accountDto;
        } catch (Exception e) {
            throw new Exception(String.format("Get account failed for id: %d due to %s",
                    id, e.getMessage()), e);
        }
    }
}
