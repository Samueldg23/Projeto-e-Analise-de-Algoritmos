package service;

import model.Pessoa;

public class PessoaService {
    Pessoa[] pessoa;
    int tamanho;

    public PessoaService(int tamanho) {
        this.tamanho = tamanho;
        pessoa = new Pessoa[tamanho];
    }

    public Pessoa[] listar() {
        return pessoa;
    }

    public boolean inserir(Pessoa p) {
        if (tamanho < pessoa.length) {
            pessoa[tamanho] = p;
            tamanho++;
            return true;
        }
        return false;
    }

    public Pessoa alterar(Pessoa p) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoa[i].getId().equals(p.getId())) {
                pessoa[i] = p;
                return pessoa[i];
            }
        }
        return null;
    }

    public Pessoa excluir(Integer id) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoa[i].getId().equals(id)) {
                pessoa[i] = null;
                for (int j = i; j < tamanho - 1; j++) {
                    pessoa[j] = pessoa[j + 1];
                }
                pessoa[tamanho - 1] = null;
                tamanho--;
                return pessoa[i];
            }
        }
        return null;
    }

    public Pessoa buscarPorNome(String parteNome) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoa[i].getNome().toLowerCase().contains(parteNome.toLowerCase())) {
                return pessoa[i];
            }
        }
        return null;
    }

    public Pessoa ordenarPorNome() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                if (pessoa[i].getNome().compareToIgnoreCase(pessoa[j].getNome()) > 0) {
                    Pessoa temp = pessoa[i];
                    pessoa[i] = pessoa[j];
                    pessoa[j] = temp;
                }
            }
        }
        return null;
    }

    public Pessoa ordenarPorNomeEIdade() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                if (pessoa[i].getNome().compareToIgnoreCase(pessoa[j].getNome()) > 0) {
                    Pessoa temp = pessoa[i];
                    pessoa[i] = pessoa[j];
                    pessoa[j] = temp;
                } else if (pessoa[i].getNome().equalsIgnoreCase(pessoa[j].getNome())) {
                    if (pessoa[i].getIdade() > pessoa[j].getIdade()) {
                        Pessoa temp = pessoa[i];
                        pessoa[i] = pessoa[j];
                        pessoa[j] = temp;
                    }
                }
            }
        }
        return null;
    }
}
