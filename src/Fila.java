import java.util.Scanner;

public class Fila {
    private int tamanho;
    private int[] dados;
    private int primeiro;
    private int ultimo;
    private int capacidade;

    Fila(int tamanho) {
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
        this.primeiro = 0;
        this.ultimo = -1;
        this.capacidade = 0;
    }

    boolean cheia() {
        if (capacidade == tamanho) {
            return true;
        } else {
            return false;
        }
    }

    boolean vazia() {
        if (capacidade == 0) {
            return true;
        } else {
            return false;
        }
    }

    void insere(int elemento) {
        if (cheia() == true) {
            System.out.println("Fila está cheia, nao foi possível inserir o valor: " + elemento);
        } else {
            ultimo = ultimo + 1;
            if (ultimo == tamanho) {
                ultimo = 0;
            }
            dados[ultimo] = elemento;
            capacidade = capacidade + 1;
            System.out.println("Inserido: " + elemento);
        }
    }

    void remove() {
        if (vazia() == true) {
            System.out.println("Fila está vazia, não tem como remover");
        } else {
            int valorRemovido = dados[primeiro];
            primeiro = primeiro + 1;
            if (primeiro == tamanho) {
                primeiro = 0;
            }
            capacidade = capacidade - 1;
            System.out.println("Removido: " + valorRemovido);
        }
    }

    int primeiro() {
        if (vazia() == true) {
            System.out.println("Fila está vazia, não há um primeiro elemento");
            return -1;
        } else {
            return dados[primeiro];
        }
    }

    int ultimo() {
        if (vazia() == true) {
            System.out.println("Fila está vazia, não tem um último elemento");
            return -1;
        } else {
            return dados[ultimo];
        }
    }

    void imprime() {
        if (vazia() == true) {
            System.out.println("Fila está vazia");
        } else {
            System.out.print("Fila: ");
            int indice = primeiro;
            int cont = 0;
            while (cont < capacidade) {
                System.out.print(dados[indice] + " ");
                indice = indice + 1;
                if (indice == tamanho) {
                    indice = 0;
                }
                cont = cont + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);

        System.out.print("Informe o tamanho da fila: ");
        int tamanhoInformado = Teclado.nextInt();

        Fila fila = new Fila(tamanhoInformado);

        System.out.println("FILA");

        fila.insere(1);
        fila.insere(2);
        fila.insere(3);

        fila.imprime();

        System.out.println("Primeiro elemento: " + fila.primeiro());
        System.out.println("Ultimo elemento: " + fila.ultimo());

        fila.remove();

        System.out.println("Remoção do primeiro realizado");
        System.out.println("Primeiro elemento após a remoção: " + fila.primeiro());
        System.out.println("Último elemento: " + fila.ultimo());

        fila.insere(4);
        fila.imprime();
    }
}