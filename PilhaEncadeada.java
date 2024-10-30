public class PilhaEncadeada {
    private No topo;
    private int tamanho;

    public PilhaEncadeada() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void push(Object o) {
        No novoNo = new No(o);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia.");
        }
        Object elemento = topo.elemento;
        topo = topo.proximo;
        tamanho--;
        return elemento;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia.");
        }
        return topo.elemento;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
