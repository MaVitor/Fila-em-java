public class FilaCircular {
    private int[] fila;
    private int capacidade;
    private int frente;
    private int traseira;
    private int tamanho;

    public FilaCircular(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.fila = new int[capacidade];
        this.frente = 0;
        this.traseira = 0;
        this.tamanho = 0;
    }

    private void dobrarArray() {
        int novaCapacidade = this.capacidade * 2;
        int[] novaFila = new int[novaCapacidade];
        
        for (int i = 0; i < this.tamanho; i++) {
            novaFila[i] = this.fila[(this.frente + i) % this.capacidade];
        }
        
        this.fila = novaFila;
        this.frente = 0;
        this.traseira = this.tamanho;
        this.capacidade = novaCapacidade;
    }

    public void enfileirar(int item) {
        if (this.tamanho == this.capacidade) {
            dobrarArray();
        }
        
        this.fila[this.traseira] = item;
        this.traseira = (this.traseira + 1) % this.capacidade;
        this.tamanho++;
    }

    public int desenfileirar() {
        if (this.tamanho == 0) {
            throw new IllegalStateException("A fila está vazia.");
        }
        
        int item = this.fila[this.frente];
        this.fila[this.frente] = 0;  // Optional: limpar o valor para evitar "leaks"
        this.frente = (this.frente + 1) % this.capacidade;
        this.tamanho--;
        return item;
    }

    public int frenteDaFila() {
        if (this.tamanho == 0) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return this.fila[this.frente];
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public int tamanhoFila() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Fila: [");
        for (int i = 0; i < this.tamanho; i++) {
            sb.append(this.fila[(this.frente + i) % this.capacidade]);
            if (i < this.tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Classe de Teste
    public static class TesteFila {
        public static void rodarTeste() {
            FilaCircular fila = new FilaCircular(10);

            // Teste de enfileiramento
            System.out.println("Enfileirando elementos...");
            for (int i = 0; i < 15; i++) {
                fila.enfileirar(i);
                System.out.println("Fila após enfileirar " + i + ": " + fila);
            }

            // Teste de desenfileiramento
            System.out.println("\nDesenfileirando elementos...");
            while (!fila.estaVazia()) {
                int removido = fila.desenfileirar();
                System.out.println("Elemento removido: " + removido + ", Fila: " + fila);
            }

            // Teste de frente da fila
            try {
                System.out.println("\nVerificando o elemento da frente...");
                System.out.println("Elemento da frente: " + fila.frenteDaFila());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        TesteFila.rodarTeste();
    }
}
