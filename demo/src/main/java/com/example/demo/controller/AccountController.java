package com.example.demo.controller;


import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;


    @GetMapping
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @GetMapping("{username}")
    public Account getById(@PathVariable String username)
    {
        return accountRepository.getOne(username);
    }


    @PostMapping()
    public Account save(@RequestBody Account accountModel)
    {
        return accountRepository.saveAndFlush(accountModel);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Account update(@RequestBody Account accountModel)
    {
        Account existingAcc = accountRepository.getOne(accountModel.getUsername());
        BeanUtils.copyProperties(accountModel, existingAcc, "id", "username", "verified" );
        return accountRepository.saveAndFlush(existingAcc);
    }

    @RequestMapping(value = "{username}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String  username)
    {

        accountRepository.deleteById(username);
    }
}
