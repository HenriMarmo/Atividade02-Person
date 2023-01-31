package com.marmo.personapiwithdb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String telefone;
    private String email;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
}
