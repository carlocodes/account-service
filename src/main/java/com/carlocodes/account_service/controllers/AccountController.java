package com.carlocodes.account_service.controllers;

import com.carlocodes.account_service.dtos.AccountDto;
import com.carlocodes.account_service.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create-account/{name}")
    public ResponseEntity<String> createAccount(@PathVariable String name) throws Exception {
        accountService.createAccount(name);
        return ResponseEntity.ok("Account created!");
    }

    @GetMapping("/get-account/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(accountService.getAccount(id));
    }
}
