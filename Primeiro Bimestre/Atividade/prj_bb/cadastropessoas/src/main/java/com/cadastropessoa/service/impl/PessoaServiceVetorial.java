package com.cadastropessoa.service.impl;

import com.cadastropessoa.dominio.Pessoa;
import com.cadastropessoa.service.PessoaService;
import com.cadastropessoa.service.ordenador.InsertionSort;
import com.cadastropessoa.service.validador.EmailValidator;

public class PessoaServiceVetorial implements PessoaService {

    private final Pessoa[] vetor;
    private int tamanho;

    private int proximoId;

    public PessoaServiceVetorial(int capacidadeMaxima) {
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que 0");
        }
        this.vetor = new Pessoa[capacidadeMaxima];
        this.tamanho = 0;
        this.proximoId = 1; 
    }

    @Override
    public void listar() {
        if (tamanho == 0) {
            System.out.println("[LISTAR] Nenhuma pessoa cadastrada.");
            return;
        }
        System.out.println("[LISTAR] Pessoas cadastradas (" + tamanho + "):");
        for (int i = 0; i < tamanho; i++) {
            Pessoa p = vetor[i];
            System.out.printf("  #%d -> id=%d | nome=%s | email=%s | idade=%d | celular=%s%n",
                    i, p.getId(), p.getNome(), p.getEmail(), p.getIdade(), p.getCelular());
        }
    }

    @Override
    public boolean inserir(Pessoa p) {
        if (p == null) return false;

        if (tamanho >= vetor.length) {
            System.out.println("[INSERIR] Vetor cheio. Capacidade: " + vetor.length);
            return false;
        }

        if (!EmailValidator.isValid(p.getEmail())) {
            System.out.println("[INSERIR] E-mail inválido: " + p.getEmail());
            return false;
        }

        if (!emailDisponivel(p.getEmail(), null)) {
            System.out.println("[INSERIR] E-mail já cadastrado: " + p.getEmail());
            return false;
        }

        p.setId(proximoId++);
        vetor[tamanho++] = p;
        System.out.println("[INSERIR] Pessoa inserida com sucesso!"); 
        return true;
    }

    @Override
    public boolean alterar(Pessoa p) {
        if (p == null || p.getId() == null) return false;

        int index = indicePorId(p.getId());
        if (index == -1) {
            System.out.println("[ALTERAR] ID não encontrado: " + p.getId());
            return false;
        }

        if (!EmailValidator.isValid(p.getEmail())) {
            System.out.println("[ALTERAR] E-mail inválido: " + p.getEmail());
            return false;
        }

        if (!emailDisponivel(p.getEmail(), p.getId())) {
            System.out.println("[ALTERAR] E-mail já cadastrado para outro usuário: " + p.getEmail());
            return false;
        }

        Pessoa alvo = vetor[index];
        alvo.setNome(p.getNome());
        alvo.setEmail(p.getEmail());
        alvo.setIdade(p.getIdade());
        alvo.setCelular(p.getCelular());
        return true;
    }

    @Override
    public boolean excluir(Integer id) {
        if (id == null) return false;

        int index = indicePorId(id);
        if (index == -1) {
            System.out.println("[EXCLUIR] ID não encontrado: " + id);
            return false;
        }

        for (int i = index; i < tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        vetor[--tamanho] = null;
        return true;
    }

    @Override
    public Pessoa[] buscarPorNome(String parteNome) {
        if (parteNome == null || parteNome.isBlank()) return new Pessoa[0];
        String alvo = parteNome.toLowerCase();

        Pessoa[] tmp = new Pessoa[tamanho];
        int k = 0;
        for (int i = 0; i < tamanho; i++) {
            String nome = vetor[i].getNome();
            if (nome != null && nome.toLowerCase().contains(alvo)) {
                tmp[k++] = vetor[i];
            }
        }
        Pessoa[] resultado = new Pessoa[k];
        for (int i = 0; i < k; i++) resultado[i] = tmp[i];
        return resultado;
    }

    @Override
    public void ordenarPorNome() {
        InsertionSort.ordenar(vetor, tamanho, this::compararPorNome);
    }

    @Override
    public void ordenarPorNomeEIdade() {
        InsertionSort.ordenar(vetor, tamanho, (a, b) -> {
            int c = compararPorNome(a, b);
            return (c != 0) ? c : Integer.compare(a.getIdade(), b.getIdade());
        });
    }

    @Override
    public Pessoa buscarPorId(Integer id) {
        int index = indicePorId(id);
        return (index == -1) ? null : vetor[index];
    }


    private int indicePorId(Integer id) {
        if (id == null) return -1;
        for (int i = 0; i < tamanho; i++) {
            Integer atual = vetor[i].getId();
            if (atual != null && atual.equals(id)) return i;
        }
        return -1;
    }

    private int compararPorNome(Pessoa a, Pessoa b) {
        String na = a.getNome() == null ? "" : a.getNome();
        String nb = b.getNome() == null ? "" : b.getNome();
        return na.compareToIgnoreCase(nb);
    }

    private boolean emailDisponivel(String email, Integer ignorarId) {
        String alvo = EmailValidator.normalize(email);
        if (alvo == null) return false;

        for (int i = 0; i < tamanho; i++) {
            Pessoa atual = vetor[i];
            if (atual == null) continue;
            if (ignorarId != null && ignorarId.equals(atual.getId())) continue; 
            String cadastrado = EmailValidator.normalize(atual.getEmail());
            if (alvo.equals(cadastrado)) return false;
        }
        return true;
    }
}
