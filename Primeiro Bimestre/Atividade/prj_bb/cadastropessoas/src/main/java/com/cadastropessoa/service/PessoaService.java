package com.cadastropessoa.service;

import com.cadastropessoa.dominio.Pessoa;

public interface PessoaService {
    void listar();
    boolean inserir(Pessoa p);
    boolean alterar(Pessoa p);
    boolean excluir(Integer id);
    Pessoa[] buscarPorNome(String parteNome);
    void ordenarPorNome();
    void ordenarPorNomeEIdade();
    Pessoa buscarPorId(Integer id);
}
