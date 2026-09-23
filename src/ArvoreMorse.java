public class ArvoreMorse {

    static class No {

        char caractere; // ' ' = no nulo MAS TEM COISA DEPOIS

        No esquerda; // ponto .

        No direita; // traco -

        No(char caractere) {
            this.caractere = caractere;
            this.esquerda = null;
            this.direita = null;
        }
    }


    private final No raiz = new No(' ');


    public void inserir(String morse, char caractere) {


        No no = raiz;


        for (char simbolo : morse.toCharArray()) {


            if (simbolo == '.') {
                if (no.esquerda == null) {
                    no.esquerda = new No(' '); // no de passagem
                }


                no = no.esquerda;
            }


            else if (simbolo == '-') {
                if (no.direita == null) {
                    no.direita = new No(' ');
                }


                no = no.direita;
            }


        }


        no.caractere = caractere;


    }




    public char buscar(char[] simbolos) {


        No no = buscarNo(raiz, simbolos);


        if (no == null || no.caractere == ' ') {
            return '?'; // sequencia nao existe na arvore
        }


        return no.caractere;


    }


    private No buscarNo(No no, char[] simbolos) {


        for (char simbolo : simbolos) {


            if (no == null) {
                return null; // so vai dar null p caminho que nao existe mais nada
            }


            if (simbolo == '.') {
                no = no.esquerda;
            }


            else if (simbolo == '-') {
                no = no.direita;
            }
        }


        return no;


    }










    // ---------------------------------------------------------------
    // EXIBICAO (adaptado do desenhar da ArvoreBinaria)
    // ---------------------------------------------------------------

    public void exibir() {
        exibir(raiz, 0, "raiz");
    }


    private void exibir(No no, int nivel, String caminho) {

        if (no == null) {
            return;
        }


        exibir(no.direita, nivel + 1, "-");

        System.out.println("      ".repeat(nivel) + caminho + " " + no.caractere);

        exibir(no.esquerda, nivel + 1, ".");
    }
}
