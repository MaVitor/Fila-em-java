public class FilaEncadeada implements IFila {
    private No inicio;
    private No fim;
    private int tamanho;

    public FilaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void enqueue(Object o) {
        No novoNo = new No(o);
        if (isEmpty()) {
            inicio = novoNo;
        } else {
            fim.proximo = novoNo;
        }
        fim = novoNo;
        tamanho++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        Object elemento = inicio.elemento;
        inicio = inicio.proximo;
        tamanho--;
        if (isEmpty()) {
            fim = null;
        }
        return elemento;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        return inicio.elemento;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }
}
