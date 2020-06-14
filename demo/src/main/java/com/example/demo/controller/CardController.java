package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Card;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

@RestController
@CrossOrigin
@RequestMapping("card")

public class CardController {


    @Autowired
    CardRepository cardRepository;
    @Autowired
    AccountRepository accountRepository;

    @GetMapping
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @GetMapping("{id}")
    public Card getById(@PathVariable Long id) {
        return cardRepository.getOne(id);
    }



    @PostMapping
    public Card save(@RequestBody Card card_model) {
        return cardRepository.save(card_model);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Card update(@RequestBody Card card_model) {
        Card oldCard = cardRepository.getOne(card_model.getId());
        BeanUtils.copyProperties(card_model, oldCard, "id", "position", "status");
        return cardRepository.saveAndFlush(oldCard);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        cardRepository.deleteById(id);
    }

    @RequestMapping(value="member"  ,method = RequestMethod.POST)
    public  Card addmember(@RequestBody Map<String , Object> payload)
    {
        Card card = cardRepository.getOne(Long.parseLong(payload.get("cardId").toString()));
        Set<Account> member = card.getMem();
        member.add(accountRepository.getOne(payload.get("accountUserName").toString()));
        card.setMem(member);
        return cardRepository.saveAndFlush(card);
    }

    @RequestMapping(value = "member", method = RequestMethod.DELETE)
    public  Card deletemember(@RequestBody Map<String, Object> payload)
    {
        Card card = cardRepository.getOne(Long.parseLong(payload.get("cardId").toString()));
        Set<Account> member = card.getMem();
        member.removeIf(account ->  account.getUsername().equals(payload.get("accountUsername").toString()));
        card.setMem(member);
        return cardRepository.saveAndFlush(card);
    }

}
