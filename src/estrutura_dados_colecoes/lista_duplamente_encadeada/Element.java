package estrutura_dados_colecoes.lista_duplamente_encadeada;

public class Element<T>{

    private final T value;
    private Element<T> prev;
    private Element<T> next;

    Element(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public Element<T> getPrev() {
        return prev;
    }

    public void setPrev(Element<T> prev) {
        this.prev = prev;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }
}
