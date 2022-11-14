package com.yasir.VeterinaryProject.model;

import lombok.*;

import javax.persistence.*;


import java.util.Set;

@Entity
@Table(name = "tbl_owner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String phoneNumber;

    private String email;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId",referencedColumnName = "id")
    private Set<Animal> animal;




}
