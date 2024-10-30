public class FilaDuplicacao implements IFila {
    private Object[] array;
    private int inicio, fim, tamanho;

    public FilaDuplicacao(int capacidadeInicial) {
        this.array = new Object[capacidadeInicial];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    private void expandirArray() {
        Object[] novoArray = new Object[array.length * 2];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = array[(inicio + i) % array.length];
        }
        array = novoArray;
        inicio = 0;
        fim = tamanho;
    }

    @Override
    public void enqueue(Object o) {
        if (tamanho == array.length) {
            expandirArray();
        }
        array[fim] = o;
        fim = (fim + 1) % array.length;
        tamanho++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        Object removido = array[inicio];
        array[inicio] = null;
        inicio = (inicio + 1) % array.length;
        tamanho--;
        return removido;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        return array[inicio];
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
