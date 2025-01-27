package com.dev.exemplo1.escola.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escola {

    private int id;
    private String nome;
    private String endereco;
    private int idEscola;

}
