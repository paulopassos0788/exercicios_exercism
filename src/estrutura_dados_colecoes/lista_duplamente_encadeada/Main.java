package estrutura_dados_colecoes.lista_duplamente_encadeada;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        System.out.println("Lista após inserções:");
        // Adicionando elementos
        list.push(11);
        list.push(12);
        list.push(13);
        list.push(14);
        list.printBackward();

        System.out.println("Lista após remocao:");
        list.pop();
        list.printBackward();

        System.out.println("Remove do final da lista");
        list.shift();
        list.printBackward();

        System.out.println("Insere no final da lista");
        list.unshift(15);
        list.printBackward();

    }
}
