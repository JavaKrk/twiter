package com.javakrk.twiter.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private Date date;

    @ManyToOne
    private UserEntity userEntity;

    @OneToMany(mappedBy = "id")
    private Set<CommentEntity> commentEntities;
}
