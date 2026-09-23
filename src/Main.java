import java.util.Scanner;

public class Main {

    // tudo e lido como linha, por causa dos pontos e tracos
    private static final Scanner entrada = new Scanner(System.in);


    public static void main(String[] args) {

        ArvoreMorse arvore = new ArvoreMorse();

        carregarAlfabeto(arvore); // a arvore ja nasce completa
        System.out.println("Arvore carregada com A-Z e 0-9.");

        String opcao;


        do {
            menu();
            opcao = lerLinha("Opcao: ");


            switch (opcao) {

                case "1" -> {

                    String morse = lerLinha("Codigo morse (ex: ...): ");
                    String letra = lerLinha("Caractere: ");

                    if (letra.isEmpty()) {
                        System.out.println("Nenhum caractere digitado.");
                    } else {
                        arvore.inserir(morse, letra.charAt(0));
                        System.out.println("Inserido: " + letra.charAt(0) + " = " + morse);
                    }
                }

                case "2" -> traduzirMensagem(arvore);

                case "3" -> arvore.exibir();

                case "4" -> {
                    carregarAlfabeto(arvore);
                    System.out.println("Caracteres carregados.");
                }

                case "0" -> System.out.println("Encerrando.");

                default -> System.out.println("Opcao invalida.");
            }

        } while (!opcao.equals("0"));
    }


    private static void menu() {
        System.out.println();
        System.out.println("===== ARVORE BINARIA - CODIGO MORSE =====");
        System.out.println("1 - Inserir caractere");
        System.out.println("2 - Digitar mensagem em MORSE");
        System.out.println("3 - Exibir arvore");
        System.out.println("4 - Carregar caracteres");
        System.out.println("0 - Sair");
    }


    // ------------------------------------------------------------------
    // Le a mensagem inteira e separa automaticamente cada sequencia
    // pelo espaco entre elas. Cada sequencia vira um char[].
    // ------------------------------------------------------------------

    private static void traduzirMensagem(ArvoreMorse arvore) {

        String mensagem = lerLinha("Mensagem em morse (separe com espaco): ").trim();


        if (mensagem.isEmpty()) {
            System.out.println("Nada digitado.");
            return;
        }


        String[] sequencias = mensagem.split("\\s+"); // um ou mais espacos

        StringBuilder traducao = new StringBuilder();


        for (String sequencia : sequencias) {

            char[] simbolos = sequencia.toCharArray();

            char caractere = arvore.buscar(simbolos);

            traducao.append(caractere);

            System.out.println("  " + sequencia + "  ->  " + caractere);
        }


        System.out.println("Mensagem: " + traducao);
    }


    // ------------------------------------------------------------------
    // Exemplos do proprio enunciado. Falta completar o resto.
    // ------------------------------------------------------------------

    private static final String[][] TABELA_MORSE = {

            {"A", ".-"},    {"B", "-..."},  {"C", "-.-."},  {"D", "-.."},
            {"E", "."},     {"F", "..-."},  {"G", "--."},   {"H", "...."},
            {"I", ".."},    {"J", ".---"},  {"K", "-.-"},   {"L", ".-.."},
            {"M", "--"},    {"N", "-."},    {"O", "---"},   {"P", ".--."},
            {"Q", "--.-"},  {"R", ".-."},   {"S", "..."},   {"T", "-"},
            {"U", "..-"},   {"V", "...-"},  {"W", ".--"},   {"X", "-..-"},
            {"Y", "-.--"},  {"Z", "--.."},

            {"0", "-----"}, {"1", ".----"}, {"2", "..---"}, {"3", "...--"},
            {"4", "....-"}, {"5", "....."}, {"6", "-...."}, {"7", "--..."},
            {"8", "---.."}, {"9", "----."}
    };


    private static void carregarAlfabeto(ArvoreMorse arvore) {

        for (String[] linha : TABELA_MORSE) {

            char caractere = linha[0].charAt(0);
            String morse = linha[1];

            arvore.inserir(morse, caractere);
        }
    }


    private static String lerLinha(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine();
    }
}
