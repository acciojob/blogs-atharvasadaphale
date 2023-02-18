package com.driver.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    private String password;

    private String fname;

    private String lname;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> blogsWritten;

    public User() {
    }

    public User(int id, String username, String password, String fname, String lname, List<Blog> blogsWritten) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.blogsWritten = blogsWritten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public List<Blog> getBlogsWritten() {
        return blogsWritten;
    }

    public void setBlogsWritten(List<Blog> blogsWritten) {
        this.blogsWritten = blogsWritten;
    }
}