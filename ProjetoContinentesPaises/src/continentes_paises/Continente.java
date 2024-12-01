package continentes_paises;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises;

    // Construtor
    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    // Getter para o nome do continente
    public String getNome() {
        return nome;
    }

    // Adicionar país ao continente
    public void adicionarPais(Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }

    // Obter a lista de países
    public List<Pais> getPaises() {
        return paises;
    }

    // Obter a dimensão total do continente
    public double getDimensaoTotal() {
        return paises.stream().mapToDouble(Pais::getDimensao).sum();
    }

    // Obter a população total do continente
    public long getPopulacaoTotal() {
        return paises.stream().mapToLong(Pais::getPopulacao).sum();
    }

    // Obter a densidade populacional do continente
    public double getDensidadePopulacional() {
        double dimensaoTotal = getDimensaoTotal();
        return dimensaoTotal > 0 ? getPopulacaoTotal() / dimensaoTotal : 0;
    }

    // País com maior população
    public Pais getPaisMaiorPopulacao() {
        return paises.stream().max((p1, p2) -> Long.compare(p1.getPopulacao(), p2.getPopulacao())).orElse(null);
    }

    // País com menor população
    public Pais getPaisMenorPopulacao() {
        return paises.stream().min((p1, p2) -> Long.compare(p1.getPopulacao(), p2.getPopulacao())).orElse(null);
    }

    // Obter a razão territorial do maior país em relação ao menor
    public double getRazaoTerritorial() {
        Pais maior = paises.stream().max((p1, p2) -> Double.compare(p1.getDimensao(), p2.getDimensao())).orElse(null);
        Pais menor = paises.stream().min((p1, p2) -> Double.compare(p1.getDimensao(), p2.getDimensao())).orElse(null);
        return (maior != null && menor != null) ? maior.getDimensao() / menor.getDimensao() : 0;
    }
}
