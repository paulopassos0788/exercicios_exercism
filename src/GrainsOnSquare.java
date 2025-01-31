import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class GrainsOnSquare {
    public static void main(String[] args) {

        System.out.println(grainsOnSquare(3));
        System.out.println(grainsOnBoard());
    }

    public static BigInteger grainsOnSquare(final int square) {
        // Verifica se o número do quadrado está dentro do intervalo válido
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("O número do quadrado deve estar entre 1 e 64.");
        }

        List<BigInteger> result = new ArrayList<>();
        
        // Preenche a lista com os valores de grãos para cada quadrado
        for (int i = 0; i < 64; i++) {
            result.add(BigInteger.valueOf(2).pow(i));
        }

        // Retorna o valor correspondente ao quadrado especificado
        return result.get(square - 1); // Ajusta o índice para começar em 0
    }

   public static BigInteger grainsOnBoard() {
        List<BigInteger> result = new ArrayList<>();

        BigInteger total = BigInteger.ZERO;

        for (int i = 0; i < 64; i++) {
            result.add(BigInteger.valueOf(2).pow(i));
        }

        for (BigInteger value : result) {
            total = total.add(value);
        }

        return total;
    }

    /*
 *  // Verifica se o número do quadrado está dentro do intervalo válido
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("O número do quadrado deve estar entre 1 e 64.");
        }

        // Calcula o número de grãos no quadrado especificado
        return BigInteger.valueOf(2).pow(square - 1);
 */
}
