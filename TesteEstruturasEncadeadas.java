// public class TesteEstruturasEncadeadas {
//     public static void main(String[] args) {
//         // Testando a Fila
//         FilaEncadeada fila = new FilaEncadeada();
//         fila.enqueue("A");
//         fila.enqueue("B");
//         fila.enqueue("C");
        
//         System.out.println("Primeiro da fila: " + fila.first()); // A
//         System.out.println("Removido da fila: " + fila.dequeue()); // A
//         System.out.println("Novo primeiro da fila: " + fila.first()); // B

//         // Testando a Pilha
//         PilhaEncadeada pilha = new PilhaEncadeada();
//         pilha.push("1");
//         pilha.push("2");
//         pilha.push("3");
        
//         System.out.println("Topo da pilha: " + pilha.peek()); // 3
//         System.out.println("Removido da pilha: " + pilha.pop()); // 3
//         System.out.println("Novo topo da pilha: " + pilha.peek()); // 2
//     }
// }

public class TesteEstruturasEncadeadas {

    public static void inverterFila(FilaEncadeada fila) {
        PilhaEncadeada pilha = new PilhaEncadeada();

        // Passo 1: Desenfileirar todos os elementos da fila e empilhá-los
        while (!fila.isEmpty()) {
            pilha.push(fila.dequeue());
        }

        // Passo 2: Desempilhar cada elemento e enfileirá-los de volta
        while (!pilha.isEmpty()) {
            fila.enqueue(pilha.pop());
        }
    }

    public static void main(String[] args) {
        FilaEncadeada fila = new FilaEncadeada();
        fila.enqueue("A");
        fila.enqueue("B");
        fila.enqueue("C");
        fila.enqueue("D");

        System.out.println("Fila antes de inverter:");
        while (!fila.isEmpty()) {
            System.out.println(fila.first());
            fila.dequeue();
        }

        // Reinsere os elementos para inverter
        fila.enqueue("A");
        fila.enqueue("B");
        fila.enqueue("C");
        fila.enqueue("D");

        inverterFila(fila);

        System.out.println("\nFila depois de inverter:");
        while (!fila.isEmpty()) {
            System.out.println(fila.first());
            fila.dequeue();
        }
    }
}
