package continentes_paises;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;
    private List<Pais> fronteiras;

    // Construtor
    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.fronteiras = new ArrayList<>();
    }

    // Getters e Setters
    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        if (populacao >= 0) {
            this.populacao = populacao;
        } else {
            System.out.println("População não pode ser negativa.");
        }
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        if (dimensao > 0) {
            this.dimensao = dimensao;
        } else {
            System.out.println("Dimensão deve ser maior que zero.");
        }
    }

    public List<Pais> getFronteiras() {
        return fronteiras;
    }

    // Verificar igualdade semântica
    public boolean equals(Pais outro) {
        return this.codigoISO.equalsIgnoreCase(outro.getCodigoISO());
    }

    // Verificar se é limítrofe
    public boolean isLimitrofe(Pais outro) {
        return fronteiras.contains(outro);
    }

    // Densidade populacional
    public double getDensidadePopulacional() {
        return populacao / dimensao;
    }

    // Vizinhos comuns
    public List<Pais> vizinhosComuns(Pais outro) {
        List<Pais> comuns = new ArrayList<>(this.fronteiras);
        comuns.retainAll(outro.getFronteiras());
        return comuns;
    }

    // Adicionar fronteira
    public void adicionarFronteira(Pais pais) {
        if (!this.equals(pais) && !fronteiras.contains(pais)) {
            fronteiras.add(pais);
            pais.fronteiras.add(this); // Relação bidirecional
        }
    }

    @Override
    public String toString() {
        return String.format(
            "País: %s (%s)\nPopulação: %d\nDimensão: %.2f km²\nDensidade Populacional: %.2f hab/km²",
            nome, codigoISO, populacao, dimensao, getDensidadePopulacional()
        );
    }
}

