package com.cadastropessoa.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor        
@AllArgsConstructor       
public class Pessoa {
    private Integer id;
    private String nome;
    private String email;
    private int idade;
    private String celular;
}