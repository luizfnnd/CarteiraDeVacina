package com.carteira.model;
public class Vacina {
    private String nome;
    private String dataVacina;
    private int numDoses;

    public Vacina(String nome, String dataVacina, int numDoses) {
        this.nome = nome;
        this.dataVacina = dataVacina;
        this.numDoses = numDoses;
    }

    public String getNome() {
        return nome;
    }

    public String getDataVacina() {
        return dataVacina;
    }

    public int getNumDoses() {
        return numDoses;
    }
}
