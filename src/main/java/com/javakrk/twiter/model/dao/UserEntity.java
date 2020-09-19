package com.javakrk.twiter.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    @Column(name = "birth_date")
    private String birthDate;

    @OneToMany(mappedBy = "id")
    private Set<PostEntity> postEntities;
}
