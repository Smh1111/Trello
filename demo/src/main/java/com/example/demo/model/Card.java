package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Card extends TimeModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    private Integer position;

    private Integer status;

    @JsonIgnoreProperties("cards")
    @JoinColumn(name = "list_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private List list;

    // between account and card
    @ManyToMany
    @JoinTable(
            name = "card_member",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "account_username")
    )
    private Set<Account> mem;





    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Set<Account> getMem() {
        return mem;
    }

    public void setMem(Set<Account> mem) {
        this.mem = mem;
    }
}
