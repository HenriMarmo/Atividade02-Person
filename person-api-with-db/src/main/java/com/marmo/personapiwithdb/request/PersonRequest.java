package com.marmo.personapiwithdb.request;

import com.marmo.personapiwithdb.model.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    private String cpf;

    @NotBlank
    @NotNull
    private String rg;

    @NotBlank
    @NotNull
    private Date dataNascimento;

    @NotBlank
    @NotNull
    private String telefone;

    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
}
