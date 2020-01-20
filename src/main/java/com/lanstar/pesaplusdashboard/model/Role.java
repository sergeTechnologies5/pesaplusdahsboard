package com.lanstar.pesaplusdashboard.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends AbstractModel<Long> {

    private String name;

    public Role(){

    }
    public Role(String name){
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<Users> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}