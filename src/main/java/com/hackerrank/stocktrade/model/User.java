package com.hackerrank.stocktrade.model;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@SQLDelete(sql = "UPDATE users SET status=false WHERE id=?")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    public User() {
    }
    
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
