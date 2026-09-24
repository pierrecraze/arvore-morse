# Árvore Binária — Código Morse

Tradutor de código Morse feito com uma árvore binária, onde o caminho da raiz até
um nó é o próprio código da letra. Cada `.` desce para a esquerda e cada `-` desce
para a direita, então achar uma letra é só seguir os símbolos digitados.

A árvore já nasce com as 26 letras e os números de 0 a 9.

## Como rodar

Abrir a pasta no IntelliJ e executar a classe `Main`.

Ou pelo terminal:

```bash
javac -d out src/*.java
java -cp out Main
```

## Menu

| Opção | O que faz |
|---|---|
| 1 | Insere um caractere novo, informando o código morse e a letra |
| 2 | Digita uma mensagem em morse e recebe o texto traduzido |
| 3 | Exibe a árvore inteira, de forma hierárquica |
| 4 | Recarrega as letras e números |
| 0 | Sai |

Na opção 2, as sequências são separadas por espaço:

```
Mensagem em morse: ... --- ...
  ...  ->  S
  ---  ->  O
  ...  ->  S
Mensagem: SOS
```

## Como a árvore funciona

```
              (raiz)
           .-'      '-.
          E            T
        .' '.        .' '.
       I     A      N     M
```

A raiz não guarda letra nenhuma, é só o ponto de partida. A partir dela:

- `.` → `E`, `..` → `I`, `...` → `S`
- `-` → `T`, `--` → `M`, `---` → `O`

Ou seja, a posição do nó é o código. Não existe comparação de valores como numa
árvore de busca comum — o que decide o lado é o símbolo lido.

## As operações

`inserir(String morse, char caractere)` — percorre o código símbolo a símbolo,
criando os nós que ainda não existem, e grava a letra no nó onde o código termina.

`buscar(char[] simbolos)`- segue os símbolos a partir da raiz e devolve a letra
do nó onde parou. Devolve `?` quando a sequência não corresponde a nenhum caractere.

`exibir()` — imprime a árvore deitada (a raiz à esquerda), usando recursão para
mostrar a hierarquia das subárvores.

## Nó de passagem

Nem todo nó guarda uma letra. O `9` é `----.`, mas `----` sozinho não é caractere
nenhum é apenas um nó no meio do caminho marcado com `' '`.

Por isso a busca faz duas verificações diferentes:

- durante o percurso, checa se o nó é `null` — significa que o caminho não existe;
- ao final, checa se o nó tem letra se for `' '`, o caminho existe mas não forma
  caractere.

As duas situações devolvem `?` mas por motivos distintos.

## Arquivos

- `src/ArvoreMorse.java` — a árvore: o nó, inserção, busca e exibição.
- `src/Main.java` — menu, leitura do teclado e a tabela dos 36 caracteres.
