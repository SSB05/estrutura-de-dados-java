public class Merge {
    public static Fila opMerge(Fila filaA, Fila filaB, int tamanhoTotal) {
        Fila filaR = new Fila(tamanhoTotal);

        System.out.println("Início do Merge");
        // Faz a comparação dos elementos enquanto nenhuma das duas filas estiver vazia
        while (filaA.vazia() == false && filaB.vazia() == false) {
            if (filaA.primeiro() <= filaB.primeiro()) {
                filaR.insere(filaA.primeiro());
                filaA.remove();
            } else {
                filaR.insere(filaB.primeiro());
                filaB.remove();
            }
        }
        // Se acabar os elementos da fila B primeiro, copia o que sobrou da fila A
        while (filaA.vazia() == false) {
            filaR.insere(filaA.primeiro());
            filaA.remove();
        }
        // Se acabar os elementos da fila A primeiro, copia o que sobrou da fila B
        while (filaB.vazia() == false) {
            filaR.insere(filaB.primeiro());
            filaB.remove();
        }

        return filaR;
    }
    public static void main(String[] args) {
        //Filas criadas usando a classe no fila.java
        Fila filaA = new Fila(4);
        Fila filaB = new Fila(5);

        System.out.println("Populando a fila A");
        filaA.insere(12);
        filaA.insere(35);
        filaA.insere(52);
        filaA.insere(64);

        System.out.println("\nPopulando a fila B");
        filaB.insere(5);
        filaB.insere(15);
        filaB.insere(23);
        filaB.insere(55);
        filaB.insere(75);

        Fila filaR = opMerge(filaA, filaB, 9);

        System.out.println("\nResultado Fila R: ");
        filaR.imprime();
    }
}