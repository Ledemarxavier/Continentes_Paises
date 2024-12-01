package continentes_paises;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Países da América do Sul
        Pais brasil = new Pais("BRA", "Brasil", 8515767.05);
        brasil.setPopulacao(213317639);

        Pais argentina = new Pais("ARG", "Argentina", 2780400.00);
        argentina.setPopulacao(45376763);

        Pais uruguai = new Pais("URU", "Uruguai", 176215.00);
        uruguai.setPopulacao(3473727);

        brasil.adicionarFronteira(argentina);
        brasil.adicionarFronteira(uruguai);
        argentina.adicionarFronteira(uruguai);

        Continente americaDoSul = new Continente("América do Sul");
        americaDoSul.adicionarPais(brasil);
        americaDoSul.adicionarPais(argentina);
        americaDoSul.adicionarPais(uruguai);

        // Países da América do Norte
        Pais eua = new Pais("USA", "Estados Unidos", 9833517.00);
        eua.setPopulacao(331893745);

        Pais canada = new Pais("CAN", "Canadá", 9984670.00);
        canada.setPopulacao(38005238);

        Pais mexico = new Pais("MEX", "México", 1964375.00);
        mexico.setPopulacao(126014024);

        eua.adicionarFronteira(canada);
        eua.adicionarFronteira(mexico);
        canada.adicionarFronteira(mexico);

        Continente americaDoNorte = new Continente("América do Norte");
        americaDoNorte.adicionarPais(eua);
        americaDoNorte.adicionarPais(canada);
        americaDoNorte.adicionarPais(mexico);

        // Exibindo informações da América do Sul
        System.out.println("==== América do Sul ====");
        exibirInformacoesContinente(americaDoSul);

        // Exibindo informações da América do Norte
        System.out.println("\n==== América do Norte ====");
        exibirInformacoesContinente(americaDoNorte);
    }

    private static void exibirInformacoesContinente(Continente continente) {
        for (Pais pais : continente.getPaises()) {
            exibirInformacoesPais(pais);
        }

        System.out.println("Continente: " + continente.getNome());
        System.out.printf("Dimensão Total: %.2f km²\n", continente.getDimensaoTotal());
        System.out.println("População Total: " + continente.getPopulacaoTotal());
        System.out.printf("Densidade Populacional: %.2f hab/km²\n", continente.getDensidadePopulacional());
        System.out.println("Países:");
        continente.getPaises().forEach(p -> System.out.println("- " + p.getNome()));

        Pais maiorPopulacao = continente.getPaisMaiorPopulacao();
        if (maiorPopulacao != null) {
            System.out.println("\nPaís com maior população: " + maiorPopulacao.getNome());
        }

        Pais menorPopulacao = continente.getPaisMenorPopulacao();
        if (menorPopulacao != null) {
            System.out.println("País com menor população: " + menorPopulacao.getNome());
        }

        System.out.printf("Razão territorial (maior/menor): %.2f\n", continente.getRazaoTerritorial());
    }

    private static void exibirInformacoesPais(Pais pais) {
        System.out.println("País: " + pais.getNome() + " (" + pais.getCodigoISO() + ")");
        System.out.println("População: " + pais.getPopulacao());
        System.out.printf("Dimensão: %.2f km²\n", pais.getDimensao());
        System.out.printf("Densidade Populacional: %.2f hab/km²\n", pais.getDensidadePopulacional());

        List<Pais> fronteiras = pais.getFronteiras();
        if (!fronteiras.isEmpty()) {
            System.out.print("Fronteiras: ");
            fronteiras.forEach(f -> System.out.print(f.getNome() + ", "));
            System.out.println("\b\b "); // Remove última vírgula e espaço
        } else {
            System.out.println("Fronteiras: Nenhuma");
        }
        System.out.println();
    }
}
