package com.solanaexchange.project.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="attr1")
    private String attr1;
    @Column(name="attr2")
    private String attr2;

    public Users() {
        super();
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users(String id, String email, String password, String attr1, String attr2) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.attr1 = attr1;
        this.attr2 = attr2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", attr1='" + attr1 + '\'' +
                ", attr2='" + attr2 + '\'' +
                '}';
    }
}
