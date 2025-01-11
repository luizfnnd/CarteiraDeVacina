package com.carteira.model;
import com.carteira.model.Vacina;
import java.util.List;

public class FichaPaciente {
    private int id;
    private String nome;
    private String dtNascimento;
    private String cpf;
    private List<Vacina> vacinas;

    public FichaPaciente(int id, String nome, String dtNascimento, String cpf, List<Vacina> vacinas) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.vacinas = vacinas;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }
}
