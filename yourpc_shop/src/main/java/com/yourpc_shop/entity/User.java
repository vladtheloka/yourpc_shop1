package com.yourpc_shop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User extends AbstractEntity implements UserDetails
{
    @Column(name="userName")
    @Getter @Setter
    private String name;

    @Column(name="userEmail")
    @Getter @Setter
    private String email;

    @Column(name="password")
    @Getter @Setter
    private String password;

    @Column(name="userAddress")
    @Getter @Setter
    private String address;

    @Enumerated
    @Getter @Setter
    private Role role;

    @Getter @Setter
    private boolean enable;

    @Getter @Setter
    private String uuId;

    @Getter @Setter
    @ManyToMany
    @JoinTable(name = "user_item",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "itemId"))
    private Set<Item> items = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private Set<Billable> billable = new HashSet<>();

    public User() {}

    public User(String name, String email, String password, String address)
    {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Email: " + email + ", Password: " + password +
                ", Address: " + address + ", Role: " + role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public String getUsername()
    {
        return String.valueOf(id);
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return enable;
    }
}
