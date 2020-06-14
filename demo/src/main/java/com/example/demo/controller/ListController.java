package com.example.demo.controller;

import com.example.demo.model.List;
import com.example.demo.repository.ListRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("list")
public class ListController {

    @Autowired
    ListRepository listRepository;

    @GetMapping
    public java.util.List<List> getAll() {
        return listRepository.findAll();
    }

    @GetMapping("{id}")
    public List getById(@PathVariable Long id) {
        return listRepository.getOne(id);
    }

    @PostMapping
    public List save(@RequestBody List list) {
        return listRepository.saveAndFlush(list);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List update(@RequestBody List list) {
        List oldList = listRepository.getOne(list.getId());
        BeanUtils.copyProperties(list, oldList, "id", "status", "position");
        return listRepository.saveAndFlush(oldList);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        listRepository.deleteById(id);
    }
}
