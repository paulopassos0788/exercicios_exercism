package estrutura_dados_colecoes.lista_duplamente_encadeada;

public class DoublyLinkedList<T> {

    private Element<T> head;
    private Element<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null; // Cabeça da lista
        this.tail = null; // Cauda da lista
        this.size = 0; // Tamanho da lista
    }


    void push(T value) {
        Element<T> newElement = new Element<>(value);
        if (head == null) {
            head = tail = newElement;
        }
        else {
            newElement.setNext(head);
            head.setPrev(newElement);
            head = newElement;
        }
        size++;
    }

    T pop() {
        if (head == null) throw new IllegalStateException("Lista vazia");
        T value = head.getValue();

        if(head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }

        size--;
        return value;
    }

    // Insere no final da lista
    void unshift(T value) {
        Element<T> newElement = new Element<>(value);
        if (tail == null) { // Lista vazia
            head = tail = newElement;
        } else {
            newElement.setPrev(tail);
            tail.setNext(newElement);
            tail = newElement;
        }
        size++;
    }

    // Remove do final da lista
    T shift() {
        if (tail == null) throw new IllegalStateException("Lista vazia");
        T value = tail.getValue();

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }

        size--;
        return value;
    }

    public void printBackward() {
        Element<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
