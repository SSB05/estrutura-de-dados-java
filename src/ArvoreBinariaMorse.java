import java.util.Scanner;
//Criação da classe NOde, representa cada nó da árvore
class Node {
    char caractere;
    Node esquerda;
    Node direita;
//Construtor do Node
    Node(char valor) {
        this.caractere = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

public class ArvoreBinariaMorse {
    private Node raiz;
    //Começa a árvore com um nó vazio na raiz
    void inicializar() {
        raiz = new Node('*');
    }
    //percorre a árvore criando o os caminhos dos pontos e traços
    void inserir(String morse, char letra) {
        Node atual = raiz;
        int tamanho = morse.length();
        int x = 0;

        while (x < tamanho) {
            char simbolo = morse.charAt(x);

            if (simbolo == '.') { //se for ponto vai para a esquerda, caso não exista cria um nó vazio
                if (atual.esquerda == null) {
                    atual.esquerda = new Node(' ');
                }
                atual = atual.esquerda;
            } else if (simbolo == '-') {//se for traço vai para a direita, cria vazio também
                if (atual.direita == null) {
                    atual.direita = new Node(' ');
                }
                atual = atual.direita;
            }
            x++;
        }
        // Quando o laço termina, chegamos na posição certa e guardamos a letra
        atual.caractere = letra;
    }
    //faz o mesmo caminho do método inserir, porém esse serve apenas para leitura
    char buscar(String morse) {
        Node atual = raiz;
        int tamanho = morse.length();
        int x = 0;
        while (x < tamanho) {
            char simbolo = morse.charAt(x);

            if (simbolo == '.') {
                atual = atual.esquerda;
            } else if (simbolo == '-') {
                atual = atual.direita;
            }
            //Caso seja informado um código que não existe, o atual fica NULO
            if (atual == null) {
                return '?';
            }
            x++;
        }
        return atual.caractere;
    }

    // Faz a exibição da árvore, inicializando pela esquerda (.) e finalizando na direita (-)
    void mostrarArvore(Node atual, String caminho) {
        if (atual != null) {
            if (atual.caractere != ' ' && atual.caractere != '*') {
                System.out.println("Caminho (" + caminho + ") -> " + atual.caractere);
            }
            mostrarArvore(atual.esquerda, caminho + ".");
            mostrarArvore(atual.direita, caminho + "-");
        }
    }

    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        arvore.inicializar();
        //Array contendo as letras
        char[] letras = {
                'E', 'T', 'I', 'A', 'N', 'M', 'S', 'U', 'R', 'W', 'D', 'K', 'G', 'O',
                'H', 'V', 'F', 'L', 'P', 'J', 'B', 'X', 'C', 'Y', 'Z', 'Q',
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
        };
        //Array contendo os códigos nas respectivas posições do array ddas letras
        String[] codigos = {
                ".", "-", "..", ".-", "-.", "--", "...", "..-", ".-.", ".--", "-..", "-.-", "--.", "---",
                "....", "...-", "..-.", ".-..", ".--.", ".---", "-...", "-..-", "-.-.", "-.--", "--..", "--.-",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"
        };
        //Popular árvore inteira automaticamente
        int cont = 0;
        while (cont < letras.length) {
            arvore.inserir(codigos[cont], letras[cont]);
            cont++;
        }

        System.out.println("Estrutura da Arvore:");
        arvore.mostrarArvore(arvore.raiz, "");

        System.out.println("\nTestes:");
        System.out.println("Busca '...': " + arvore.buscar("..."));
        System.out.println("Busca '---': " + arvore.buscar("---"));

        System.out.println("\nDigite o codigo morse (Separe cada código com espaço):");
        String fraseMorse = Teclado.nextLine();

        fraseMorse = fraseMorse + " "; //Adiciona um espaço no final para forçar o loop a processar a ultima letra digitada

        System.out.print("Código traduzido: ");

        String letraTemporario = "";
        int tamanhoFrase = fraseMorse.length();
        int x = 0;
        // Percorre a frase digitada caractere por caractere
        while (x < tamanhoFrase) {
            char pedaco = fraseMorse.charAt(x);
            // Se encontrar um espaço, a sequência da letra atual terminou
            if (pedaco == ' ') {
                if (letraTemporario.length() > 0) {
                    char traducao = arvore.buscar(letraTemporario);
                    System.out.print(traducao);
                    letraTemporario = "";
                }
            } else {
                letraTemporario = letraTemporario + pedaco; //Concatena os pontos e traços enquanto não acha um espaço
            }
            x++;
        }

        System.out.println();
    }
}