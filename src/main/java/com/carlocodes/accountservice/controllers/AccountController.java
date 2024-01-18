package com.carlocodes.accountservice.controllers;

import com.carlocodes.accountservice.services.AccountService;
import org.springframework.http.ResponseEntity;
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
}
